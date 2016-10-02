/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stages;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class ExecutionStage implements Runnable {

    private Thread t;
    private final String threadName;
    private final ArrayList<String> input;
    private final ArrayList<String> output;

    public ExecutionStage(ArrayList<String> input) {
        threadName = "ExecutionStage";
        this.input = input;
        output = new ArrayList();

        for (int i = 0; i < 6; i++) {

            output.add("0");
        }
    }

    @Override
    public void run() {
        String value = "";
        String Cs = this.input.get(4);
        String Ct = this.input.get(5);
        if (input.get(1).compareTo("000") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) + this.binaryToInteger(Ct));
            } else if (input.get(0).compareTo("0001") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) - this.binaryToInteger(Ct));
            } else if (input.get(0).compareTo("0010") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) + this.binaryToInteger(Ct));
            } else if (input.get(0).compareTo("0011") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) - this.binaryToInteger(Ct));
            } else if (input.get(0).compareTo("0100") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) * this.binaryToInteger(Ct));
            }
        } else if (input.get(1).compareTo("001") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) & this.binaryToInteger(Ct));
            } else if (input.get(0).compareTo("0001") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) | this.binaryToInteger(Ct));
            } else if (input.get(0).compareTo("0010") == 0) {
                value = this.decimalToBinary(~this.binaryToInteger(Cs));
            } else if (input.get(0).compareTo("0011") == 0) {
                value = this.decimalToBinary(this.binaryToInteger(Cs) ^ this.binaryToInteger(Ct));
            }
        } else if (input.get(1).compareTo("010") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
            } else if (input.get(0).compareTo("0001") == 0) {

            } else if (input.get(0).compareTo("0010") == 0) {

            } else if (input.get(0).compareTo("0011") == 0) {

            } else if (input.get(0).compareTo("0100") == 0) {

            }
        } else if (input.get(1).compareTo("011") == 0) {
            value = Cs;
        } else if (input.get(1).compareTo("100") == 0) {
            if (input.get(0).compareTo("0000") == 0) {
                this.decimalToBinary(this.binaryToInteger(Cs) << 2);
            } else if (input.get(0).compareTo("0001") == 0) {
                this.decimalToBinary(this.binaryToInteger(Cs) >> 2);
            } else if (input.get(0).compareTo("0010") == 0) {
                value = Cs;
            }
        }
        
        this.output.add(this.input.get(0));//Opcode
        this.output.add(this.input.get(1));//Type
        this.output.add(this.input.get(2));//Encode
        this.output.add(this.input.get(3));//RD address
        this.output.add(this.input.get(5));//Memory address
        this.output.add(value);//Data
    }

    public void start() {

        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public ArrayList<String> getOutput() throws InterruptedException {

        Thread.sleep(10);
        return output;
    }
    
    public int binaryToInteger(String data) {
        return Integer.parseInt(data, 2);
    }
    
    public String decimalToBinary(int pNumber) {
        return Integer.toBinaryString(pNumber);
    }
}
