
package components;

import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class RegisterBank {

    private final ArrayList<Integer> registers;
    
    
    public RegisterBank(){
        
    registers = new ArrayList();
    }
    
    /**
     *  Reads a specific register
     * @param address       expected in binary
     * @return      register value, expected in binary
     */
    public int readAddress( int address ){
        
        int value =0;
        
       switch (address){
           
           case 0000:       value = registers.get(0);
           case 0001:       value = registers.get(1);
           case 0010:       value = registers.get(2);
           case 0011:       value = registers.get(3);
           case 0100:       value = registers.get(4);
           case 0101:       value = registers.get(5);
           case 0110:       value = registers.get(6);
           case 0111:       value = registers.get(7);
           case 1000:       value = registers.get(8);
           case 1001:       value = registers.get(9);
           case 1010:       value = registers.get(10);                
           case 1011:       value = registers.get(11);
           case 1100:       value = registers.get(12);
           case 1101:       value = registers.get(13);
           case 1110:       value = registers.get(14);
           case 1111:       value = registers.get(15);
         
       }
        return value;     
    }

    /**
     *  Writes to a specific register
     * @param address   expected in binary
     * @param value     expected in binary
     * @param enable    writeEnable
     */
    public void writeAddress( int address, int value, boolean enable ){
        
        if (!enable)
            return;
        
        switch (address){
           
           case 0000:       registers.set(0, value);
           case 0001:       registers.set(1, value);
           case 0010:       registers.set(2, value);
           case 0011:       registers.set(3, value);
           case 0100:       registers.set(4, value);
           case 0101:       registers.set(5, value);
           case 0110:       registers.set(6, value);
           case 0111:       registers.set(7, value);
           case 1000:       registers.set(8, value);
           case 1001:       registers.set(9, value);
           case 1010:       registers.set(10, value);        
           case 1011:       registers.set(11, value);
           case 1100:       registers.set(12, value);
           case 1101:       registers.set(13, value);
           case 1110:       registers.set(14, value);
           case 1111:       registers.set(15, value);
       }
    }    

    
    
}
