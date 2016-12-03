/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import components.BranchPredictor;
import components.InstructionMemory;
import components.RegisterBank;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Utility;

/**
 *
 * @author jose
 */
public class IssueStage extends Observable implements Runnable {

    private Thread t;
    private final String threadName;
    private String instructionFetched;
    private final int cantInstructions;
    private final RegisterBank register;
    private long initTime;
    private long time;

    public IssueStage(int pCantInst) {
        threadName = "IssueStage";
        cantInstructions = pCantInst;
        register = RegisterBank.getInstance();
    }

    @Override
    public void run() {

        InstructionMemory instructionMemory = InstructionMemory.getInstance();
        int loopCicles = 1;
        ExecutionStage exe = null;

        System.out.println("Inicio del Issue ");
        this.initTime = System.nanoTime();

        while (cantInstructions >= loopCicles) {

            String address = register.readAddress("1111");

            String instruction = instructionMemory.readInstruction(address);

            String pcActual = register.readAddress("1111");
            String pc;

            if (!BranchPredictor.brach(instruction)) {
                int sum = Integer.parseInt(address, 2) + Integer.parseInt("1", 2);
                pc = Integer.toBinaryString(sum);
                register.writeAddress("1111", Utility.completeBinary(pc, 32));
            } else {
                pc = Integer.toBinaryString(BranchPredictor.getNewPC(pcActual, instruction));
                register.writeAddress("1111", Utility.completeBinary(pc, 32));
            }

            instructionFetched = instruction;
            try {
                t.sleep(0, 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(IssueStage.class.getName()).log(Level.SEVERE, null, ex);
            }
            exe = new ExecutionStage(cantInstructions, loopCicles, instructionFetched);
            exe.start();

            loopCicles++;

        }
        if (cantInstructions < loopCicles && exe != null) {
            try {
                t.sleep(0, 3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(IssueStage.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setTime(exe.getEndTime() - this.initTime);
        }
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time / 3000;
        setChanged();
        notifyObservers();
    }

    /**
     * Punto de entrada del thread.
     */
    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    /**
     * Se retorna el resultado de la instruccion (el issue)
     *
     * @return
     */
    public String getInstructionFetched() {
        return instructionFetched;
    }
}
