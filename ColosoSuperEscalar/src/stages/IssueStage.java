/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import components.BranchPredictor;
import components.InstructionMemory;
import components.RegisterBank;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Utility;

/**
 *
 * @author jose
 */
public class IssueStage implements Runnable {

    private Thread t;
    private final String threadName;
    private String instructionFetched;
    private final int cantInstructions;
    private final RegisterBank register;

    public IssueStage(int pCantInst) {
        threadName = "IssueStage";
        cantInstructions = pCantInst;
        register = RegisterBank.getInstance();
    }

    @Override
    public void run() {

        InstructionMemory instructionMemory = InstructionMemory.getInstance();
        int loopCicles = 1;

        while (cantInstructions >= loopCicles) {

            String address = register.readAddress("1111");

            String instruction = instructionMemory.readInstruction(address);

            String pcActual = register.readAddress("1111");
            String pc;

            if (!BranchPredictor.brach(instruction)) {
                int number0 = Integer.parseInt(address, 2);
                int number1 = Integer.parseInt("1", 2);

                int sum = number0 + number1;
                pc = Integer.toBinaryString(sum);
                register.writeAddress("1111", Utility.completeBinary(pc, 32));
            } else {
                pc = Integer.toBinaryString(BranchPredictor.getNewPC(pcActual, instruction));
                register.writeAddress("1111", Utility.completeBinary(pc, 32));
            }

            try {
                synchronized (this) {
                    instructionFetched = instruction;
                    loopCicles++;
                    t.sleep(0, 1000);
                    this.notifyAll();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(IssueStage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
