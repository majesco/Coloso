package components;

import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class InstructionMemory {

    private final ArrayList<String> instructions;
    private static InstructionMemory instance = null;
    private int pointer = 0;

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
    public String readInstruction(String address) {

        int index = binaryToDecimal(address);
        return instructions.get(index);
    }
    
    
    public void addInstruction( String instruction){
        
        instructions.set(pointer, instruction);
        pointer++;
    }

    /**
     * Binary to Decimal converter
     *
     * @param number
     * @return
     */
    private int binaryToDecimal(String number) {

        int n = Integer.parseInt(number, 2);
        return n;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }
    
}
