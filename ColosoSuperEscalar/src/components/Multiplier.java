/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Utility;

/**
 *
 * @author jose
 */
public class Multiplier {

    private Thread t;
    private final String threadName;
    private ArrayList<String> input;
    private ArrayList<String> output;
    private final RegisterBank reg;

    public Multiplier() {
        this.reg = RegisterBank.getInstance();
        this.threadName = "Multiplier";
    }

    public void addInput(ArrayList<String> input) {
        this.input = input;
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

//    @Override
    public void start() {
        String value = "0";
        String Cs = input.get(4);
        String Ct = input.get(6);
        String Imm = input.get(5);
        
        this.output = new ArrayList<>();

        if (input.get(2).compareTo("00") == 0) {
            value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) * Utility.binaryToDecimal(Ct));
        } else {
            value = Utility.decimalToBinary(Utility.binaryToDecimal(Cs) * Utility.binaryToDecimal(Imm));
        }
        
        this.output.add(this.input.get(0));//Opcode
        this.output.add(this.input.get(1));//Type
        this.output.add(this.input.get(2));//Encode
        this.output.add(this.input.get(3));//RD address
        this.output.add(Utility.completeBinary(value, 32));//Data

        try {
            Thread.sleep(0, 3000);
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

}
