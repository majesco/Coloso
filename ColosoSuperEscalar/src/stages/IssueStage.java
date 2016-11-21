/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import components.InstructionMemory;
import components.RegisterBank;
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

    public IssueStage(int pCantInst) {
        threadName = "IssueStage";
        cantInstructions = pCantInst;
    }

    @Override
    public void run() {

        System.out.println("Etapa Issue");
        InstructionMemory instructionMemory = InstructionMemory.getInstance();
        int loopCicles = 1;
        
        while ( cantInstructions >= loopCicles ) {
            System.out.println("Inicio de la etapa issue");
            RegisterBank register = RegisterBank.getInstance();
            String address = register.readAddress("1111");

            String instruction = instructionMemory.readInstruction(address);
            instructionFetched = instruction;

            int number0 = Integer.parseInt(address, 2);
            int number1 = Integer.parseInt("1", 2);

            int sum = number0 + number1;
            String pc = Integer.toBinaryString(sum);
            register.writeAddress("1111", Utility.completeBinary(pc, 32));
            
            loopCicles++;
        }
    }

    /**
     * Punto de entrada del thread.
     */
    public void start () {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    /**
     * Se retorna el resultado de la instruccion (el fetch)
     *
     * @return
     * @throws InterruptedException
     */
    public String getInstructionFetched() throws InterruptedException {
        Thread.sleep(1);
        System.out.println("output fetch " + instructionFetched);

        return instructionFetched;
    }
}
