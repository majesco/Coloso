package stages;

import components.*;

/**
 * First stage of the CPU
 *
 * @author nicolasjimenez
 */
public class InstructionFetch implements Runnable {

    private Thread t;
    private final String threadName;
    private String instructionFetched = "";

    public InstructionFetch() {

        threadName = "InstructionFetchStage";
    }

    /**
     * Logica del thread
     */
    @Override
    public void run() {

        RegisterBank register = RegisterBank.getInstance();
        String address = register.readAddress("1111");
        InstructionMemory instructionMemory = InstructionMemory.getInstance();

        String instruction = instructionMemory.readInstruction(address);
        instructionFetched = instruction;

        int number0 = Integer.parseInt(address, 2);
        int number1 = Integer.parseInt("1", 2);

        int sum = number0 + number1;
        register.writeAddress("1111", Integer.toBinaryString(sum));
    }

    /**
     * Punto de entrada del thread.
     */
    public void start() {

        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    /**
     * Se retorna el resultado de la instruccion (el fetch)
     *
     * @return
     * @throws InterruptedException
     */
    public String getInstructionFetched() throws InterruptedException {
        Thread.sleep(1);
        System.out.println("output fetch " + instructionFetched);

        return instructionFetched;
    }

}
