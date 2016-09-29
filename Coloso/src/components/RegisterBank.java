package components;

import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class RegisterBank {

    private  String pc;
    private final ArrayList<String> registers;
    private static RegisterBank instance = null;

    public RegisterBank() {

        pc = new String();
        registers = new ArrayList();
        
        for (int i = 0; i < 16; i++) {
            registers.add("0");
        }
    }

   public static RegisterBank getInstance() {
      if(instance == null) {
         instance = new RegisterBank();
      }
      return instance;
   }
    
   public String readPC (){
       
       return pc;
   }
   
   public void writePC( String value){
       
       pc= value;
   }
   
   
    /**
     * Reads a specific register
     *
     * @param address expected in binary
     * @return register value, expected in binary
     */
    public String readAddress(int address) {

        String value = "";

        switch (address) {

            case 0000:
                value = registers.get(0);
                break;
            case 0001:
                value = registers.get(1);
                break;
            case 0010:
                value = registers.get(2);
                break;
            case 0011:
                value = registers.get(3);
                break;
            case 0100:
                value = registers.get(4);
                break;
            case 0101:
                value = registers.get(5);
                break;
            case 0110:
                value = registers.get(6);
                break;
            case 0111:
                value = registers.get(7);
                break;
            case 1000:
                value = registers.get(8);
                break;
            case 1001:
                value = registers.get(9);
                break;
            case 1010:
                value = registers.get(10);
                break;
            case 1011:
                value = registers.get(11);
                break;
            case 1100:
                value = registers.get(12);
                break;
            case 1101:
                value = registers.get(13);
                break;
            case 1110:
                value = registers.get(14);
                break;
            case 1111:
                value = registers.get(15);

        }
        return value;
    }

    /**
     * Writes to a specific register
     *
     * @param address expected in binary
     * @param value expected in binary
     * @param enable writeEnable
     */
    public void writeAddress(int address, String value, boolean enable) {

        if (!enable) {
            return;
        }

        switch (address) {

            case 0000:
                registers.set(0, value);
                break;
            case 0001:
                registers.set(1, value);
                break;
            case 0010:
                registers.set(2, value);
                break;
            case 0011:
                registers.set(3, value);
                break;
            case 0100:
                registers.set(4, value);
                break;
            case 0101:
                registers.set(5, value);
                break;
            case 0110:
                registers.set(6, value);
                break;
            case 0111:
                registers.set(7, value);
                break;
            case 1000:
                registers.set(8, value);
                break;
            case 1001:
                registers.set(9, value);
                break;
            case 1010:
                registers.set(10, value);
                break;
            case 1011:
                registers.set(11, value);
                break;
            case 1100:
                registers.set(12, value);
                break;
            case 1101:
                registers.set(13, value);
                break;
            case 1110:
                registers.set(14, value);
                break;
            case 1111:
                registers.set(15, value);
        }
    }

    public ArrayList<String> getRegisters() {
        return registers;
    }


}
