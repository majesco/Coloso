package stages;

import components.*;

/**
 *
 * @author nicolasjimenez
 */
public class MainStages {

    private IssueStage issue;
    //private ExecutionStage execute;

    public MainStages() {
    }

    public void start(int cantidadInstrucciones) {
        this.issue = new IssueStage(cantidadInstrucciones);
        //this.execute = new ExecutionStage(this.issue, cantidadInstrucciones);

        //this.execute.start();
        this.issue.start();
    }

}
