/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Utility;

/**
 *
 * @author jose
 */
public class LDST implements Runnable {

    private Thread t;
    private final String threadName;
    private ArrayList<String> input;

    public LDST() {
        this.threadName = "LDST";
    }

    /**
     * Punto de entrada del thread.
     */
    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public void addInput(ArrayList<String> input) {
        this.input = input;
    }

    @Override
    public void run() {
        DataMemory dataMemory = DataMemory.getInstance();
        RegisterBank reg = RegisterBank.getInstance();

        String opcode = input.get(0);
        String type = input.get(1);
        String encode = input.get(2);
        String Ct = input.get(3);
        String Imm = input.get(5);
        String data = reg.readAddress(Ct);
        String address = Utility.completeBinary(Imm, 32);

        String readMemory = "00000000000000000000000000000000";

        if (opcode.equals("0000") || opcode.equals("0010") || opcode.equals("0100")) {
            dataMemory.writeMemory(address, Utility.completeBinaryInstruction(data, 32));
        } else {
            readMemory = dataMemory.readMemory(address);
        }

        try {
            t.sleep(0, 2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ALU.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Write Back stage LD/ST");
        if (opcode.equals("0001") || opcode.equals("0011") || opcode.equals("0101")) {
            reg.writeAddress(Ct, Utility.completeBinary(readMemory, 32));
        }

        try {
            t.sleep(0, 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ALU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
