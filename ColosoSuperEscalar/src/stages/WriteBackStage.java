/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import components.RegisterBank;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class WriteBackStage implements Runnable {

    private Thread t;
    private final String threadName;
    private final ArrayList<String> input;
    private final int cantInstructions;
    private int cicles;
    private ExecutionStage execute;

    public WriteBackStage(ExecutionStage pExecute, ArrayList<String> input, int pCantInst) {
        threadName = "WriteBackStage";
        this.input = input;
        cantInstructions = pCantInst;
        cicles = 2;
        this.execute = pExecute;
    }

    @Override
    public void run() {
        int loopCicle = 1;
        while (cantInstructions >= loopCicle) {
            RegisterBank reg = RegisterBank.getInstance();

            if (this.input.get(1).compareTo("010") == 0) {
                RegisterBank.getInstance().writeAddress("1111", this.input.get(5));
            } else if (this.input.get(1).compareTo("011") == 0 && (this.input.get(0).compareTo("0001") == 0 || this.input.get(0).compareTo("0011") == 0 || this.input.get(0).compareTo("0101") == 0)) {
                reg.writeAddress(this.input.get(3), this.input.get(4));
            } else if (this.input.get(1).compareTo("000") == 0 || this.input.get(1).compareTo("001") == 0 || this.input.get(1).compareTo("100") == 0) {
                reg.writeAddress(this.input.get(3), this.input.get(5));
            }

            long time_start, time_end;
            time_start = System.nanoTime();

            try {
                Thread.sleep(0, 800);
            } catch (InterruptedException ex) {
                Logger.getLogger(IssueStage.class.getName()).log(Level.SEVERE, null, ex);
            }

            time_end = System.nanoTime();
            System.out.println("the task has taken " + (time_end - time_start) + " nanoseconds");
            
            this.countCicles(this.input.get(1), this.input.get(0));
            loopCicle++;
        }
    }

    public void start() {

        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    
    private void countCicles(String decode, String opcode) {
        if(opcode.equals("011")) {
            cicles += 2;
        }
        else if( opcode.equals("000") && decode.equals("0100")) {
            cicles += 3;
        }
        else {
            cicles += 1;
        }
    }
    
    public int getCicles() {
        return cicles;
    }
}
