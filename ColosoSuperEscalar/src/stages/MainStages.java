package stages;

import components.*;

/**
 *
 * @author nicolasjimenez
 */
public class MainStages {

    private final InstructionMemory instructions;
    private final RegisterBank registers;

    private IssueStage issue;
    private ExecutionStage execute;

    public MainStages() {
        this.instructions = InstructionMemory.getInstance();
        this.registers = RegisterBank.getInstance();
    }

    public void start(int cantidadInstrucciones) throws InterruptedException {

        System.out.println("cant " + cantidadInstrucciones);
        this.issue = new IssueStage(cantidadInstrucciones);
        this.execute = new ExecutionStage(this.issue, cantidadInstrucciones);

        
        this.issue.start();
        this.execute.start();
    }

}
