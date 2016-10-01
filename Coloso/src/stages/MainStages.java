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
        String instruction3;

        String instruction4;

        InstructionFetch fetch = new InstructionFetch();
        InstructionFetch fetch3 = new InstructionFetch();

        InstructionFetch fetch4 = new InstructionFetch();

        fetch.start();
        instruction = fetch.getInstructionFetched();
        System.out.println("la instruccion " + instruction);
        System.out.println(registers.readPC());
        // Thread.sleep(100);
        InstructionFetch fetch2 = new InstructionFetch();

        fetch2.start();
        instruction2 = fetch2.getInstructionFetched();
        System.out.println("la instruccion " + instruction2);
        System.out.println(registers.readPC());

        fetch3.start();
        instruction3 = fetch3.getInstructionFetched();
        System.out.println("la instruccion " + instruction3);
        System.out.println(registers.readPC());

        fetch4.start();
        instruction4 = fetch4.getInstructionFetched();
        System.out.println("la instruccion " + instruction4);
        System.out.println(registers.readPC());

    }

}
