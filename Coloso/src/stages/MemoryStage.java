package stages;

import components.DataMemory;
import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class MemoryStage implements Runnable {

    private final ArrayList<String> dataIn;

    private Thread t;
    private final String threadName;
    private ArrayList<String> output;

    /**
     *
     * @param dataIn
     */
    public MemoryStage(ArrayList<String> dataIn) {

        threadName = "MemoryStage";

        this.dataIn = dataIn;

    }

    @Override
    public void run() {

        DataMemory dataMemory = DataMemory.getInstance();

        String opcode = dataIn.get(0);
        String type = dataIn.get(1);
        String encode = dataIn.get(2);
        String rDestination = dataIn.get(3);
        String address = dataIn.get(4);
        String data = dataIn.get(5);

        String readMemory = dataMemory.readMemory(address);

        output.set(0, opcode);
        output.set(1, type);
        output.set(2, encode);
        output.set(3, rDestination);
        output.set(4, readMemory);
        output.set(5, address);

        if (type.equals("011")) {

            if (opcode.equals("0000") || opcode.equals("0001") || opcode.equals("0001")
                    || opcode.equals("0100") || opcode.equals("0101") || opcode.equals("1000")
                    || opcode.equals("10001")) {

                dataMemory.writeMemory(address, data);
            }
        }
    }

    public void start() {

        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public ArrayList<String> getOutput() throws InterruptedException {
        Thread.sleep(100);
        return output;
    }
}
