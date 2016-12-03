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
import components.Schedule;
import java.util.ArrayList;
import utility.Utility;

/**
 *
 * @author jose
 */
public class ExecutionStage implements Runnable {

    private final ALU alu;
    private final LDST ldst;
    private final Multiplier mult;
    private Thread t;
    private final String threadName;
    private long endTime;
    private final int loopCicles;
    private final String input;
    private final int cantInstructions;
    private final Schedule schedule;

    public ExecutionStage(int cantIntructions, int loopCicles, String input) {
        threadName = "ExecutionStage";
        this.alu = new ALU();
        this.ldst = new LDST();
        this.mult = new Multiplier();
        this.loopCicles = loopCicles;
        this.cantInstructions = cantIntructions;        
        this.schedule = Schedule.getInstance(cantInstructions);
        this.input = input;
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
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

        System.out.println("Inicio etapa execution " + loopCicles);

        decodedInst = this.decodeInstruction(input);
        if (decodedInst.get(1).equals("000") && decodedInst.get(0).equals("0100")) {
            this.schedule.insertSheduleCicle(loopCicles+4, 2, loopCicles);
            this.mult.addInput(decodedInst);
            System.out.println("Entro al Multiplicador");
            this.mult.start();
        } else if (decodedInst.get(1).equals("011")) {
            this.schedule.insertSheduleCicle(loopCicles+3, 2, loopCicles);
            this.ldst.addInput(decodedInst);
            this.ldst.start();
            System.out.println("Entro al ST/LD");
        } else {
            System.out.println("Entro al ALU");
            this.schedule.insertSheduleCicle(loopCicles+2, 2, loopCicles);
            this.alu.addInput(decodedInst);
            this.alu.start();
        }

        this.schedule.insertSheduleCicle(loopCicles+1, 1, loopCicles);
        
        if (loopCicles == cantInstructions) {
            this.endTime = System.nanoTime() + 10000;
        }
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

}
