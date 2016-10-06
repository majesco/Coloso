/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Compiler {

    private final String instructions;
    private final List<String> listInstruction;

    public Compiler(String pInstruction) {
        this.instructions = pInstruction;
        this.listInstruction = SplitData.getSplitedString(this.instructions, "\n");
    }

    public ArrayList<String> compile() {
        ArrayList<String> value = new ArrayList<>();
        String data = "";
        for (int i = 0; i < this.listInstruction.size(); i++) {
            String instruct = this.listInstruction.get(i);

            if (SplitData.containsAritmetic(instruct)) {
                List<String> instructionString = SplitData.getSplitedString(instruct, ",! ");
                if (instruct.contains("!")) {
                    data = this.getOpCode(instructionString.get(0)) +"000"+"01"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(2))+this.immediateToBinary(instructionString.get(3));
                } else {
                    data = this.getOpCode(instructionString.get(0))+"000"+"00"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(2))+this.getReg(instructionString.get(3));
                }
            } else if (SplitData.containsLogic(instruct)) {
                List<String> instructionString = SplitData.getSplitedString(instruct, ",! ");
                if (instruct.contains("!")) {
                    data = this.getOpCode(instructionString.get(0))+"001"+"01"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(2))+this.immediateToBinary(instructionString.get(3));
                } else {
                    data = this.getOpCode(instructionString.get(0))+"001"+"00"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(2))+this.getReg(instructionString.get(3));
                }
            } else if (SplitData.containsMemory(instruct)) {
                List<String> instructionString = SplitData.getSplitedString(instruct, ",() ");
                if (SplitData.getNumberOfChar(instruct, ",") == 2) {
                    data = this.getOpCode(instructionString.get(0))+"011"+"01"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(3))+this.immediateToBinary(instructionString.get(2));
                } else {
                    data = this.getOpCode(instructionString.get(0))+"011"+"01"+this.getReg(instructionString.get(1))+this.immediateToBinary(instructionString.get(2));
                }
            } else if (SplitData.containsControl(instruct)) {
                List<String> instructionString = SplitData.getSplitedString(instruct, ", ");
                if (instruct.contains("JUMP") && instruct.contains("BRLN")) {
                    data = this.getOpCode(instructionString.get(0))+"010"+"01"+instructionString.get(1);
                } else {
                    data = this.getOpCode(instructionString.get(0))+"010"+"01"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(2))+instructionString.get(3);
                }
            } else if (SplitData.containsDisplacement(instruct)) {
                List<String> instructionString = SplitData.getSplitedString(instruct, ",( )");
                if (instruct.contains("INIT")) {
                    data = this.getOpCode(instructionString.get(0)) +"100"+"00"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(2));
                } else {
                    String shamt = decimalToBinary(Integer.parseInt(instructionString.get(2)));
                    data = this.getOpCode(instructionString.get(0))+"100"+"11"+this.getReg(instructionString.get(1))+this.getReg(instructionString.get(3))+completeBinary(shamt, 15);
                }
            }
            value.add(this.completeBinaryInstruction(data, 32));
        }
        return value;
    }

    public String getOpCode(String pOperation) {
        String value = "";
        switch (pOperation) {
            case "ADD":
                value = this.decimalToBinary(0);
                break;
            case "SUB":
                value = this.decimalToBinary(1);
                break;
            case "ADDUN":
                value = this.decimalToBinary(2);
                break;
            case "SUBUN":
                value = this.decimalToBinary(3);
                break;
            case "MUL":
                value = this.decimalToBinary(4);
                break;
            case "AND":
                value = this.decimalToBinary(0);
                break;
            case "OR":
                value = this.decimalToBinary(1);
                break;
            case "NOR":
                value = this.decimalToBinary(2);
                break;
            case "XOR":
                value = this.decimalToBinary(3);
                break;
            case "BREQ":
                value = this.decimalToBinary(0);
                break;
            case "BRGT":
                value = this.decimalToBinary(1);
                break;
            case "BRGTEQ":
                value = this.decimalToBinary(2);
                break;
            case "JUMP":
                value = this.decimalToBinary(3);
                break;
            case "BRLN":
                value = this.decimalToBinary(4);
                break;
            case "STOREREG":
                value = this.decimalToBinary(0);
                break;
            case "LOADREG":
                value = this.decimalToBinary(1);
                break;
            case "STOREBYTE":
                value = this.decimalToBinary(2);
                break;
            case "LOADBYTE":
                value = this.decimalToBinary(3);
                break;
            case "STOREHALF":
                value = this.decimalToBinary(4);
                break;
            case "LOADHALF":
                value = this.decimalToBinary(5);
                break;
            case "SHIFTR":
                value = this.decimalToBinary(0);
                break;
            case "SHIFTL":
                value = this.decimalToBinary(1);
                break;
            case "INIT":
                value = this.decimalToBinary(2);
                break;
        }
        return this.completeBinary(value, 4);
    }

    public String getReg(String pOperation) {
        String value = "";
        switch (pOperation) {
            case "C0":
                value = this.decimalToBinary(0);
                break;
            case "C1":
                value = this.decimalToBinary(1);
                break;
            case "C2":
                value = this.decimalToBinary(2);
                break;
            case "C3":
                value = this.decimalToBinary(3);
                break;
            case "C4":
                value = this.decimalToBinary(4);
                break;
            case "C5":
                value = this.decimalToBinary(5);
                break;
            case "C6":
                value = this.decimalToBinary(6);
                break;
            case "C7":
                value = this.decimalToBinary(7);
                break;
            case "C8":
                value = this.decimalToBinary(8);
                break;
            case "C9":
                value = this.decimalToBinary(9);
                break;
            case "C10":
                value = this.decimalToBinary(10);
                break;
            case "C11":
                value = this.decimalToBinary(11);
                break;
            case "C12":
                value = this.decimalToBinary(12);
                break;
            case "C13":
                value = this.decimalToBinary(13);
                break;
            case "C14":
                value = this.decimalToBinary(14);
                break;
            case "C15":
                value = this.decimalToBinary(15);
                break;
        }
        return this.completeBinary(value, 4);
    }

    public String getAddressingMemory(int pType) {
        String value = "";

        switch (pType) {
            case 0:
                value = this.decimalToBinary(0);
                break;
            case 1:
                value = this.decimalToBinary(1);
                break;
            case 2:
                value = this.decimalToBinary(2);
                break;
            case 3:
                value = this.decimalToBinary(3);
                break;
        }
        return value;
    }

    public String immediateToBinary(String imm) {
        String value;
        int tempValue;

        tempValue = Integer.parseInt(imm);
        value = Integer.toBinaryString(tempValue);

        return this.completeBinary(value, 15);
    }

    public String decimalToBinary(int pNumber) {
        return Integer.toBinaryString(pNumber);
    }

    public String completeBinary(String binary, int finalsize) {
        String value = binary;
        for (int i = 0; i < (finalsize - binary.length()); i++) {
            value = "0" + value;
        }
        return value;
    }
    
    public String completeBinaryInstruction(String binary, int finalsize) {
        String value = binary;
        for (int i = 0; i < (finalsize - binary.length()); i++) {
            value = value + "0";
        }
        return value;
    }
}
