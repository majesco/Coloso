/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import components.RegisterBank;
import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class WriteBackStage implements Runnable {

    private Thread t;
    private final String threadName;
    private final ArrayList<String> input;

    public WriteBackStage(ArrayList<String> input) {
        threadName = "WriteBackStage";
        this.input = input;
    }

    @Override
    public void run() {
        RegisterBank reg = RegisterBank.getInstance();

        if (this.input.get(1).compareTo("010") == 0) {
            RegisterBank.getInstance().writePC(this.input.get(5));
        } else if (this.input.get(1).compareTo("011") == 0 && (this.input.get(0).compareTo("0001") == 0 || this.input.get(0).compareTo("0011") == 0 || this.input.get(0).compareTo("0101") == 0)) {
            reg.writeAddress(this.input.get(3), this.input.get(4));
        } else if (this.input.get(1).compareTo("000") == 0 || this.input.get(1).compareTo("001") == 0 || this.input.get(1).compareTo("100") == 0) {
            reg.writeAddress(this.input.get(3), this.input.get(5));
        }
    }

    public void start() {

        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
