/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import utility.Utility;

/**
 *
 * @author jose
 */
public class BranchPredictor {

    public static boolean brach(String instruction) {
        RegisterBank register = RegisterBank.getInstance();
        boolean value = false;

        String opCode = instruction.substring(0, 4);
        String type = instruction.substring(4, 7);
        String dataSource1 = register.readAddress(instruction.substring(9, 13));
        String dataSource2 = register.readAddress(instruction.substring(13, 17));

        if (type.equals("010")) {
            switch (opCode) {
                case "0000":
                    if (Utility.binaryToDecimal(dataSource1) == Utility.binaryToDecimal(dataSource2)) {
                        value = true;
                    }
                    break;
                case "0001":
                    if (Utility.binaryToDecimal(dataSource1) > Utility.binaryToDecimal(dataSource2)) {
                        value = true;
                    }
                    break;
                case "0010":
                    if (Utility.binaryToDecimal(dataSource1) >= Utility.binaryToDecimal(dataSource2)) {
                        value = true;
                    }
                    break;
                case "0011":
                    value = true;
                    break;
                default:
                    value = false;
                    break;
            }
        }

        return value;
    }

    public static int getNewPC(String pc, String instruction) {

        String immediate = instruction.substring(17, 32);
        String extended = "00000000000000000" + immediate;

        int actualPC = Utility.binaryToDecimal(pc);
        int address = Utility.binaryToDecimal(extended);

        return actualPC + address;
    }

}
