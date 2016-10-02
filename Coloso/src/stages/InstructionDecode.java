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
     *  Constructor, se setea una lista para salida de 6 campos
     * @param instruction
     */
    public InstructionDecode(String instruction) {

        threadName = "InstructionDecodeStage";
        this.instruction = instruction;
        output = new ArrayList();

        for (int i = 0; i < 6; i++) {

            output.add("0");
        }

    }

    /**
     * Metodo de thread, aqui se toman los valores de la instruccion
     * y se toman valores dependiendo del tipo de instruccion
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

        String destinationSource = instruction.substring(9, 13);
        output.set(3, destinationSource);

        String source1 = instruction.substring(13, 17);
        String dataSource1 = register.readAddress(source1);
        output.set(4, dataSource1);

        System.out.println("encode "+encode);
        System.out.println("type " +type);
        System.out.println("opcode " +opCode );
        System.out.println("destination "+destinationSource);
        System.out.println("source1 "+dataSource1);
        
        if (encode.equals("00")) {

            String source2 = instruction.substring(17, 21);
            System.out.println("source2Dir "+source2);
            String dataSource2 = register.readAddress(source2);
            System.out.println("source2 "+ dataSource2);
            output.set(5, dataSource2);

        } else {

            String immediate = instruction.substring(17, 32);
            System.out.println( "immediate "+immediate);
            
            String extended = "00000000000000000"+immediate;
            System.out.println(extended.length());
            
            output.set(5, extended);
        }

    }

    /**
     * Punto de entrada del thread
     */
    public void start() {

        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    /**
     * Obtiene el valor del output de esta etapa
     * @return
     * @throws InterruptedException 
     */
    public ArrayList<String> getOutput() throws InterruptedException {
        
        Thread.sleep(10);
        return output;
    }

}
