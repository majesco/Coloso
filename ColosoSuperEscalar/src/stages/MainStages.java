package stages;

import components.*;

/**
 *
 * @author nicolasjimenez
 */
public class MainStages {

    private final InstructionMemory instructions = InstructionMemory.getInstance();
    private final RegisterBank registers = RegisterBank.getInstance();


    public void start(int cantidadInstrucciones) throws InterruptedException {


        System.out.println("cant "+cantidadInstrucciones);
        
    }

    

}
