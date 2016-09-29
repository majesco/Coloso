package stages;

import components.RegisterBank;

/**
 * First stage of the CPU
 *
 * @author nicolasjimenez
 */
public class InstructionFetch implements Runnable {

    private Thread t;
    private final String threadName;

    public InstructionFetch() {

        threadName = "InstructionFetchStage";
    }

    @Override
    public void run() {

        RegisterBank register = RegisterBank.getInstance();
       // Instruction;
     
        String address = register.readPC();
        
        String instruction = register.readAddress( Integer.parseInt(address));
    }

    
    public void start() {
        
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
