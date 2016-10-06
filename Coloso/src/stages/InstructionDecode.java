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
     * Constructor, se setea una lista para salida de 6 campos
     *
     * @param instruction
     */
    public InstructionDecode(String instruction) {

        threadName = "InstructionDecodeStage";
        this.instruction = instruction;
        output = new ArrayList();

        for (int i = 0; i < 7; i++) {

            output.add("0");
        }

    }

    /**
     * Metodo de thread, aqui se toman los valores de la instruccion y se toman
     * valores dependiendo del tipo de instruccion
     */
    @Override
    public void run() {

        RegisterBank register = RegisterBank.getInstance();
        String opCode = instruction.substring(0, 4);
        output.set(0, opCode);

        String type = instruction.substring(4, 7);
        output.set(1, type);

        String encode = instruction.substring(7, 9);
        output.set(2, encode);

        if (type.equals("010")) {

            String source1 = instruction.substring(9, 13);
            output.set(4, source1);

            String source2 = instruction.substring(13, 17);
            output.set(6, source2);

            //      if (encode.equals("0000") || encode.equals("0001") || encode.equals("0010")) {
            String immediate = instruction.substring(17, 32);

            String extended = "00000000000000000" + immediate;

            output.set(5, extended);

            return;
        }

        String destinationSource = instruction.substring(9, 13);
        output.set(3, destinationSource);

        String source1 = instruction.substring(13, 17);
   //     System.out.println("substring "+source1 );
        output.set(4, source1);



        if (encode.equals("00")) {

            String source2 = instruction.substring(17, 21);
            output.set(6, source2);

        } else {

            String immediate = instruction.substring(17, 32);

            String extended = "00000000000000000" + immediate;

            output.set(5, extended);
        }

    }

    /**
     * Punto de entrada del thread
     */
    public void start() {

        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    /**
     * Obtiene el valor del output de esta etapa
     *
     * @return
     * @throws InterruptedException
     */
    public ArrayList<String> getOutput() throws InterruptedException {

        Thread.sleep(10);
        System.out.println("output decode "+ output);
        return output;
    }

}
