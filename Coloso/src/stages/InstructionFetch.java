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

    @Override
    public void run( ) {

        RegisterBank register = RegisterBank.getInstance();
        String address = register.readPC();
        InstructionMemory instructionsMemory = InstructionMemory.getInstance();

        String instruction = instructionsMemory.readInstruction(address);
        instructionFetched = instruction;

        int number0 = Integer.parseInt(address, 2);
        int number1 = Integer.parseInt("1", 2);

        int sum = number0 + number1;
        register.writePC( Integer.toBinaryString(sum) );
    }

    public void start() {

        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public String getInstructionFetched() throws InterruptedException {
        Thread.sleep(1);
        return instructionFetched;
    }

}
