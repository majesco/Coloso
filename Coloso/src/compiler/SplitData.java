/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author jose
 */
public class SplitData {
    
    private static final String[] listAritmetic= {"ADD", "SUB", "ADDUN", "SUBUN", "MUL"};
    private static final String[] listLogic = {"AND", "OR", "NOR", "XOR"};
    private static final String[] listControl = {"BREQ", "BRGT", "BRGTEQ", "JUMP", "BRLN"};
    private static final String[] listMemory = {"STOREREG", "STOREBYTE", "STOREHALF", "LOADREG", "LOADBYTE", "LOADHALF"};
    private static final String[] listDisplacement = {"SHIFTL", "SHIFTR", "INIT"};
        
    public static ArrayList<String> getSplitedString(String pData, String pDelimit){
        ArrayList<String> instruction = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(pData, pDelimit);
        while (st.hasMoreElements()) {
            instruction.add(st.nextElement().toString());
        }
        return instruction;
    }
    
    public static int getNumberOfChar(String pData, String pSearched) {
        String sTexto = pData;
        int contador = 0;
        while (sTexto.contains(pSearched)) {
            sTexto = sTexto.substring(sTexto.indexOf(
                    pSearched) + pSearched.length(), sTexto.length());
            contador++;
        }
        return contador;
    }
    
    public static boolean containsAritmetic(String pData) {
        int i = 0;
        boolean flag = false;
        while(i < listAritmetic.length) {
            if(pData.contains(listAritmetic[i])) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
    
    public static boolean containsLogic(String pData) {
        int i = 0;
        boolean flag = false;
        while(i < listLogic.length) {
            if(pData.contains(listLogic[i])) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
    
    public static boolean containsMemory(String pData) {
        int i = 0;
        boolean flag = false;
        while(i < listMemory.length) {
            if(pData.contains(listMemory[i])) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
    
    public static boolean containsControl(String pData) {
        int i = 0;
        boolean flag = false;
        while(i < listControl.length) {
            if(pData.contains(listControl[i])) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
    
    public static boolean containsDisplacement(String pData) {
        int i = 0;
        boolean flag = false;
        while(i < listDisplacement.length) {
            if(pData.contains(listDisplacement[i])) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
    
}
