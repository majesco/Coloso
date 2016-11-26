package stages;

import components.*;
import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class MainStages {

    private final InstructionMemory instructions;
    private final RegisterBank registers;
    
    private final ArrayList<Boolean> funtionalUnits;
    private IssueStage issue;
    private ExecutionStage execute;
    private WriteBackStage writeback;
    
    public MainStages() {
        this.instructions = InstructionMemory.getInstance();
        this.registers = RegisterBank.getInstance();
        this.funtionalUnits = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            this.funtionalUnits.add(Boolean.FALSE);
            System.out.println("Valor X: "+Boolean.FALSE);
        }
    }


    public void start(int cantidadInstrucciones) throws InterruptedException {

        System.out.println("cant "+cantidadInstrucciones);
        this.issue = new IssueStage(this, cantidadInstrucciones);
        //this.execute = new ExecutionStage();
        //this.writeback = new WriteBackStage(input, cantidadInstrucciones);
        
        this.issue.start();
        //this.execute.start();
        //this.writeback.start();
    }

    

}
