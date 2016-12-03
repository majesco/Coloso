package stages;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author nicolasjimenez
 */
public class MainStages implements Observer {

    private IssueStage issue;
    private long time;
    //private ExecutionStage execute;

    public MainStages() {
    }

    public void start(int cantidadInstrucciones) {
        this.issue = new IssueStage(cantidadInstrucciones);
        this.issue.addObserver(this);
        this.issue.start();

    }

    @Override
    public void update(Observable o, Object o1) {
        this.time = issue.getTime();
        System.out.println("Tiempo de ejecucion: " + this.time);
    }

}
