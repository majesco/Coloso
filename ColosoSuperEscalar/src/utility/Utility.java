/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Utility {
    
    public static String completeBinary(String binary, int finalsize) {
        String value = binary;
        for (int i = 0; i < (finalsize - binary.length()); i++) {
            value = "0" + value;
        }
        return value;
    }
    
    public static String completeBinaryInstruction(String binary, int finalsize) {
        String value = binary;
        for (int i = 0; i < (finalsize - binary.length()); i++) {
            value = value + "0";
        }
        return value;
    }
    
    public static String decimalToBinary(int pNumber) {
        return Integer.toBinaryString(pNumber);
    }
    
    public static int binaryToDecimal(String pBinary) {
        return Integer.parseInt(pBinary, 2);
    }
    
    public static ArrayList<String> createList(int size) {
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            list.add("0");
        }
        return list;
    }
}
