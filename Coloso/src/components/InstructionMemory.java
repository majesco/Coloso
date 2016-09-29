package components;

import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class InstructionMemory {

    private final ArrayList<String> instructions;
    private static InstructionMemory instance = null;

    public InstructionMemory() {

        instructions = new ArrayList();

        for (int i = 0; i < 1000; i++) {
            instructions.add("0");
        }
    }

    public static InstructionMemory getInstance() {
        if (instance == null) {
            instance = new InstructionMemory();
        }
        return instance;
    }

    /**
     * Access the instruction memory and returns the value.
     *
     * @param address, expected in binary
     * @return an instruction encoded in binary
     */
    public String readInstruction(int address) {

        int index = binaryToDecimal(address);
        return instructions.get(index);
    }

    /**
     * Binary to Decimal converter
     *
     * @param number
     * @return
     */
    private int binaryToDecimal(int number) {

        String s = Integer.toString(number);
        int n = Integer.parseInt(s, 2);
        return n;
    }

}
