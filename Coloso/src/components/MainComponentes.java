/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author nicolasjimenez
 */
public class MainComponentes {

    public static void main(String[] args) {

        RegisterBank reg1 = RegisterBank.getInstance();
        RegisterBank reg3 = new RegisterBank();
        RegisterBank reg2 = RegisterBank.getInstance();
        String x = "00101";
       reg2.writeAddress(0000, x, true);
//        
        System.out.println(reg3.readAddress(0000));
        System.out.println(reg1.readAddress(0000));
        
//        for(int i= 0 ; i<reg1.getRegisters().size() ; i++){
//            
//            System.out.println(reg1.getRegisters().get(i));
//        }
    }

}
