package components;

import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class InstructionMemory {

    private final ArrayList<Integer> instructions;

    public InstructionMemory() {

        instructions = new ArrayList();
    }

    /**
     *  Access the instruction memory and returns the value.
     * @param address, expected in binary
     * @return an instruction encoded in binary
     */
    public int readInstruction(int address) {

        int index = binaryToDecimal(address);
        return instructions.get(index);
    }

    /**
     * Binary to Decimal converter
     * @param number
     * @return 
     */
    private int binaryToDecimal(int number) {

        String s = Integer.toString(number);
        int n = Integer.parseInt(s, 2);
        return n;
    }

}
