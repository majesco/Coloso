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

//        DataMemory dM1 = DataMemory.getInstance();
//        
//        DataMemory dM3 = new  DataMemory();
//        
//        DataMemory dM2 = DataMemory.getInstance();
//
//        String x = "00111";
//       dM2.writeMemory("0100", x, true);
////        
//    //    System.out.println(dM3.readMemory(0100));
//        System.out.println(dM1.readMemory("0100"));
////

//            RegisterBank reg1  = RegisterBank.getInstance();
//            RegisterBank reg2 = RegisterBank.getInstance();
//            
//            String data = "00111";
//            
//            reg1.writeAddress(0100, data, true);
//            
//            System.out.println(reg2.readAddress(0100) );

            InstructionMemory iM1 = InstructionMemory.getInstance();
            InstructionMemory iM2 = InstructionMemory.getInstance();
            
            String insData = "0101010";
            String insData2 = "011111";
            
            iM1.addInstruction(insData);
            iM2.addInstruction(insData2);
            
            System.out.println(iM2.readInstruction("00000001"));
            
            
            
        
        
    }

}
