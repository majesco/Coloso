/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import components.ALU;
import components.LDST;
import components.Multiplier;
import components.RegisterBank;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Utility;

/**
 *
 * @author jose
 */
public class ExecutionStage implements Runnable {

    private final IssueStage issue;
    private String input;
    private ArrayList<String> output;
    private final int numInstructions;
    private final ALU alu;
    private final LDST ldst;
    private final Multiplier mult;
    private Thread t;
    private final String threadName;
    private String prevInput;

    public ExecutionStage(IssueStage pIssue, int pCantInst) {
        threadName = "ExecutionStage";
        this.issue = pIssue;
        this.alu = new ALU(this);
        this.ldst = new LDST();
        this.mult = new Multiplier();
        this.numInstructions = pCantInst;
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public void setOutput(ArrayList<String> output) {
        this.output = output;
    }

    public ArrayList<String> getOutput() {

        return output;
    }

    public ArrayList<String> decodeInstruction(String instructionFetched) {
        RegisterBank register = RegisterBank.getInstance();

        ArrayList<String> decode = Utility.createList(7);
        String opCode = instructionFetched.substring(0, 4);
        decode.set(0, opCode);

        String type = instructionFetched.substring(4, 7);
        decode.set(1, type);

        String encode = instructionFetched.substring(7, 9);
        decode.set(2, encode);

        if (type.equals("010")) {

            String source1 = instructionFetched.substring(9, 13);
            decode.set(4, source1);

            String source2 = instructionFetched.substring(13, 17);
            decode.set(6, source2);

            String immediate = instructionFetched.substring(17, 32);

            String extended = "00000000000000000" + immediate;

            decode.set(5, extended);

            return decode;
        }

        String destinationSource = instructionFetched.substring(9, 13);
        decode.set(3, destinationSource);

        String source1 = instructionFetched.substring(13, 17);

        String dataSource1 = register.readAddress(source1);
        decode.set(4, Utility.completeBinary(dataSource1, 32));

        if (encode.equals("00")) {

            String source2 = instructionFetched.substring(17, 21);
            String dataSource2 = register.readAddress(source2);
            decode.set(6, Utility.completeBinary(dataSource2, 32));

        } else {

            String immediate = instructionFetched.substring(17, 32);

            String extended = "00000000000000000" + immediate;

            decode.set(5, extended);
        }

        return decode;
    }

    @Override
    public void run() {

        ArrayList<String> decodedInst;

        int i = 1;
        this.prevInput = "";

        while (i <= this.numInstructions) {

            try {
                synchronized (issue) {
                    issue.wait();

                    this.input = this.issue.getInstructionFetched();

                    if (input != null && !input.equals(prevInput)) {
                        i++;
                        decodedInst = this.decodeInstruction(input);
                        if (decodedInst.get(1).equals("000") && decodedInst.get(0).equals("0100")) {
                            //this.mult.addInput(decodedInst);
                            System.out.println("Entro al Multiplicador");
                            //this.mult.start();
                        } else if (decodedInst.get(1).equals("011")) {
                            System.out.println("Entro al ST/LD");
                        } else {
                            System.out.println("Entro al ALU");
                            this.alu.addInput(decodedInst);
                            this.alu.start();
                        }
                    }
                    this.prevInput = this.input;
                    if(i == numInstructions){
                        this.prevInput = "0";
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ExecutionStage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
