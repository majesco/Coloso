/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import stages.ExecutionStage;
import utility.Utility;

/**
 *
 * @author jose
 */
public class ALU {

    private Thread t;
    //private final String threadName;
    private ArrayList<String> input;
    private ArrayList<String> output;
    private final ExecutionStage execute;
    private final RegisterBank reg;

    public ALU(ExecutionStage execute) {
        //this.threadName = "ALU";
        this.execute = execute;
        this.reg = RegisterBank.getInstance();
    }

    public void addInput(ArrayList<String> input) {
        this.input = input;
    }

    public void start() {
        String value = "0";
        String Cs = input.get(4);
        String Ct = input.get(6);
        String Imm = input.get(5);

        this.output = new ArrayList<>();

        if (input.get(1).compareTo("000") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) + Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) + Utility.binaryToDecimal(Imm));
                }
            } else if (input.get(0).compareTo("0001") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) - Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) - Utility.binaryToDecimal(Imm));
                }
            } else if (input.get(0).compareTo("0010") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) + Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) + Utility.binaryToDecimal(Imm));
                }
            } else if (input.get(0).compareTo("0011") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) - Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) - Utility.binaryToDecimal(Imm));
                }
            }
        } else if (input.get(1).compareTo("001") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) & Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) & Utility.binaryToDecimal(Imm));
                }
            } else if (input.get(0).compareTo("0001") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) | Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) | Utility.binaryToDecimal(Imm));
                }
            } else if (input.get(0).compareTo("0010") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(~(Utility.binaryToDecimal(Cs) | Utility.binaryToDecimal(Ct)));
                } else {
                    value = Utility.decimalToBinary(~(Utility.binaryToDecimal(Cs) | Utility.binaryToDecimal(Imm)));
                }
            } else if (input.get(0).compareTo("0011") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) ^ Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) ^ Utility.binaryToDecimal(Imm));
                }
            }
        } else if (input.get(1).compareTo("100") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
                value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) << Utility.binaryToDecimal(Imm));
            } else if (input.get(0).compareTo("0001") == 0) {
                value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) >> Utility.binaryToDecimal(Imm));
            } else if (input.get(0).compareTo("0010") == 0) {
                value = Cs;
            }
        }

        this.output.add(this.input.get(0));//Opcode
        this.output.add(this.input.get(1));//Type
        this.output.add(this.input.get(2));//Encode
        this.output.add(this.input.get(3));//RD address
        this.output.add(Utility.completeBinary(value, 32));//Data

        try {
            Thread.sleep(0, 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ALU.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Write Back stage");
        reg.writeAddress(input.get(3), Utility.completeBinary(value, 32));

        try {
            Thread.sleep(0, 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ALU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Punto de entrada del thread.
     */
//    public void start() {
//        if (t == null) {
//            t = new Thread(this, threadName);
//            t.start();
//        }
//    }
}
