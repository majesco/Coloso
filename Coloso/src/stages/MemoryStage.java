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
    private ArrayList<String> output = new ArrayList();

    /**
     * Constructor, se espera una lista con datos
     *
     * @param dataIn
     */
    public MemoryStage(ArrayList<String> dataIn) {

        threadName = "MemoryStage";

        this.dataIn = dataIn;

        for (int i = 0; i < 6; i++) {

            output.add("0");
        }
    }

    /**
     * Logica del thread. Se obtienen los valores de entrada como opcode, type,
     * address etc... Se lee de la memoria de datos y se escribe a ella
     * dependiendo de la instruccion
     */
    @Override
    public void run() {

        DataMemory dataMemory = DataMemory.getInstance();

        String opcode = dataIn.get(0);
        String type = dataIn.get(1);
        String encode = dataIn.get(2);
        String rDestination = dataIn.get(3);
        String data = dataIn.get(4);
        String address = dataIn.get(5);

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
     * Obtiene la salida de esta etapa
     *
     * @return @throws InterruptedException
     */
    public ArrayList<String> getOutput() throws InterruptedException {
        Thread.sleep(10);
                System.out.println("output memory " + output);

        return output;
    }
}
