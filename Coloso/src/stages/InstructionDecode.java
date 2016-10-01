package stages;

import components.RegisterBank;
import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class InstructionDecode implements Runnable {

    private Thread t;
    private final String threadName;
    private final String instruction;

    private final ArrayList<String> output;

    /**
     *
     * @param instruction
     */
    public InstructionDecode(String instruction) {

        threadName = "InstructionFetchStage";
        this.instruction = instruction;
        output = new ArrayList();

        for (int i = 0; i < 6; i++) {

            output.add("0");
        }

    }

    @Override
    public void run() {

        RegisterBank register = RegisterBank.getInstance();

        String opCode = instruction.substring(0, 4);
        output.set(0, opCode);

        String encode = instruction.substring(4, 7);
        output.set(1, encode);

        String type = instruction.substring(7, 9);
        output.set(2, type);

        String destinationSource = instruction.substring(9, 13);
        output.set(3, destinationSource);

        String source1 = instruction.substring(13, 17);
        String dataSource1 = register.readAddress(source1);
        output.set(4, dataSource1);

        if (encode.equals("00")) {

            String source2 = instruction.substring(17, 20);
            String dataSource2 = register.readAddress(source2);
            output.set(5, dataSource2);

        } else {

            String immediate = instruction.substring(17, 33);
            String dataImmediate = register.readAddress(immediate);
            
            String extended = "00000000000000000"+dataImmediate;
            
            output.set(3, extended);
        }

    }

    public void start() {

        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public ArrayList<String> getOutput() {
        return output;
    }

}
