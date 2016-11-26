/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import java.util.ArrayList;
import utility.Utility;

/**
 *
 * @author jose
 */
public class ExecutionStage {
    
    private IssueStage issue;
    private ArrayList<String> input;
    private ArrayList<String> output;
    
    public ExecutionStage(IssueStage pIssue) {
        this.issue = pIssue;
    }
    
    public void start() {
        String value = "0";
        String Cs = this.input.get(4);
        String Ct = this.input.get(6);
        String Imm = this.input.get(5);
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
            } else if (input.get(0).compareTo("0100") == 0) {
                if (input.get(2).compareTo("00") == 0) {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) * Utility.binaryToDecimal(Ct));
                } else {
                    value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) * Utility.binaryToDecimal(Imm));
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
        } else if (input.get(1).compareTo("010") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
                if (Cs.compareTo(Ct) == 0) {
                    value = Imm;
                }
            } else if (input.get(0).compareTo("0001") == 0) {
                if (Utility.binaryToDecimal(Cs) > Utility.binaryToDecimal(Ct)) {
                    value = Imm;
                }
            } else if (input.get(0).compareTo("0010") == 0) {
                if (Utility.binaryToDecimal(Cs) >= Utility.binaryToDecimal(Ct)) {
                    value = Imm;
                }
            } else if (input.get(0).compareTo("0011") == 0) {
                value = Imm;
            } else if (input.get(0).compareTo("0100") == 0) {
                value = Imm;
            }
        } else if (input.get(1).compareTo("011") == 0) {
            value = Cs;
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
        this.output.add(this.input.get(6));//Memory address
        this.output.add(Utility.completeBinary(value, 32));//Data
    }
    
    public ArrayList<String> getOutput() throws InterruptedException {

        Thread.sleep(10);
        System.out.println("output execution " + output);

        return output;
    }
    
}
