/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;


/**
 *
 * @author jose
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String delims = " ,()";
//        String splitString = "STOREBYTE C3, (OFF15, C5)";
//
//        System.out.println("StringTokenizer Example: \n");
//        StringTokenizer st = new StringTokenizer(splitString, delims);
//        System.out.println("Number of tokens: " + getNumber(splitString, "("));
//        while (st.hasMoreElements()) {
//            System.out.println("StringTokenizer Output: " + st.nextElement());
//        }
        Compiler comp = new Compiler("ADD C3, C4, !123\nLOADREG C5, (1234)\nXOR C6, C3, C4\nSHIFTL C4, 23(C4)");
        String inst1 = comp.compile().get(0);
        System.out.println("Instrucción #1: " + inst1);
        String inst2 = comp.compile().get(1);
        System.out.println("Instrucción #2: " + inst2);
        String inst3 = comp.compile().get(2);
        System.out.println("Instrucción #3: " + inst3);
        String inst4 = comp.compile().get(3);
        System.out.println("Instrucción #4: " + inst4);
    }

    public static int getNumber(String pText, String sTextoBuscado) {
        String sTexto = pText;
        int contador = 0;
        while (sTexto.contains(sTextoBuscado)) {
            sTexto = sTexto.substring(sTexto.indexOf(
                    sTextoBuscado) + sTextoBuscado.length(), sTexto.length());
            contador++;
        }
        return contador;
    }
}
