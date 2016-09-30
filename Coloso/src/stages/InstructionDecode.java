
package stages;

import components.RegisterBank;

/**
 *
 * @author nicolasjimenez
 */
public class InstructionDecode  implements Runnable{
    
    private Thread t;
    private final String threadName;

    /**
     * 
     */
    public InstructionDecode() {

        threadName = "InstructionFetchStage";
    }

    @Override
    public void run() {

        RegisterBank register = RegisterBank.getInstance();
       // Instruction;
     
        String address = register.readPC();
        
        String instruction = register.readAddress( address);
        
        
    }

    
    public void start() {
        
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

