package stages;

import components.*;

/**
 *
 * @author nicolasjimenez
 */
public class MainStages {

    public static void main(String[] args) throws InterruptedException {

        RegisterBank registers = RegisterBank.getInstance();
        InstructionMemory instructions = InstructionMemory.getInstance();
        instructions.addInstruction("100010101");
        instructions.addInstruction("100000001");
        instructions.addInstruction("100011111");

        String instruction;
        String instruction2;

        InstructionFetch fetch = new InstructionFetch();

        fetch.start();
        instruction = fetch.getInstructionFetched();
        System.out.println("la instruccion " + instruction);

       // Thread.sleep(100);
        InstructionFetch fetch2 = new InstructionFetch();

        fetch2.start();
        instruction2 = fetch2.getInstructionFetched();
        System.out.println("la instruccion " + instruction2);
    }

}
