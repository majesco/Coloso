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
        instructions.addInstruction("000000000001100000001");
        instructions.addInstruction("10010000100110000000000000001000");
        instructions.addInstruction("100011111");
        
        registers.writeAddress("0000", "11111");
        registers.writeAddress("0001", "10101");
        
        registers.writeAddress("1000", "1010101010101");
        registers.writeAddress("1010", "11110000");
        
        String instruction ;        
        String instruction2 ;
        String instruction3;

        String instruction4;
//
        InstructionFetch fetch = new InstructionFetch();
        InstructionFetch fetch3 = new InstructionFetch();

        InstructionFetch fetch4 = new InstructionFetch();

        fetch.start();
        instruction = fetch.getInstructionFetched();
        System.out.println("instrucc "+instruction);

        InstructionFetch fetch2 = new InstructionFetch();

        fetch2.start();
        instruction2 = fetch2.getInstructionFetched();
        System.out.println("instrucc "+instruction2);

        fetch3.start();
        instruction3 = fetch3.getInstructionFetched();


        fetch4.start();
        instruction4 = fetch4.getInstructionFetched();

        InstructionDecode iD = new InstructionDecode(instruction2);
        iD.start();
        System.out.println(iD.getOutput());

      //  InstructionDecode iD2 = new InstructionDecode(instruction1);
    //    iD2.start();

    //    System.out.println(iD.getOutput());
    //    System.out.println(iD2.getOutput());

    }

}
