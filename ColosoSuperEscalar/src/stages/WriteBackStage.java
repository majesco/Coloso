/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import components.RegisterBank;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class WriteBackStage implements Runnable, Observer {

    private Thread t;
    private final String threadName;
    private final int cantInstructions;
    private int cicles;
    private final ExecutionStage execute;
    private ArrayList<String> input;
    private ArrayList<String> prevInput;

    public WriteBackStage(ExecutionStage pExecute, int pCantInst) {
        threadName = "WriteBackStage";
        cantInstructions = pCantInst;
        cicles = 2;
        this.execute = pExecute;
    }

    @Override
    public void run() {

        int loopCicle = 1;
        prevInput = null;
        RegisterBank reg = RegisterBank.getInstance();

        while (cantInstructions >= loopCicle) {

            //System.out.println("Input: "+input);
            //System.out.println("Previous Input: "+prevInput);
            if (input != null && !input.equals(prevInput)) {
                //System.out.println("Inicio de la etapa WriteBack con la instruccion: " + loopCicle);
                //System.out.println("Valor de la entrada writeback: "+input);
                if (input.get(1).compareTo("010") == 0) {
                    System.out.println("Entro a actualizar PC");
                    reg.writeAddress("1111", input.get(5));
                } else if (input.get(1).compareTo("011") == 0 && (input.get(0).compareTo("0001") == 0 || input.get(0).compareTo("0011") == 0 || input.get(0).compareTo("0101") == 0)) {
                    System.out.println("Entro a guardar el ST");
                    reg.writeAddress(input.get(3), input.get(4));
                } else if (input.get(1).compareTo("000") == 0 || input.get(1).compareTo("001") == 0 || input.get(1).compareTo("100") == 0) {
                    System.out.println("Entro a actualizar registros");
                    reg.writeAddress(input.get(3), input.get(5));
                }

                countCicles(input.get(1), input.get(0));
                loopCicle++;
                prevInput = input;
            }
            try {
                t.sleep(0, 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(IssueStage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void start() {

        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    private void countCicles(String decode, String opcode) {
        if (opcode.equals("011")) {
            cicles += 2;
        } else if (opcode.equals("000") && decode.equals("0100")) {
            cicles += 3;
        } else {
            cicles += 1;
        }
    }

    public int getCicles() {
        return cicles;
    }

    @Override
    public void update(Observable o, Object o1) {
        input = this.execute.getOutput();
        System.out.println("Valor del output exe: "+input);
        System.out.println("stages.WriteBackStage.update()");
    }
}
