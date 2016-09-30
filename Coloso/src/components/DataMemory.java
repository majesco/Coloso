package components;

import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class DataMemory {

    private final ArrayList<String> dataMemory;
    private static DataMemory instance = null;

    
    public DataMemory() {

        dataMemory = new ArrayList();
                for (int i = 0; i < 1000; i++) {
            dataMemory.add("0");
        }
    }
    
   public static DataMemory getInstance() {
      if(instance == null) {
         instance = new DataMemory();
      }
      return instance;
   }
   
    /**
     * Reads from the data memory Return the content of the memory address
     *
     * @param address the address to read from.
     * @return
     */
    public String readMemory(String address) {

        int index = binaryToDecimal(address);

        System.out.println(dataMemory.get(index).getClass());
        return dataMemory.get(index);

    }

    /**
     * Writes to data memory in a specific address
     *
     * @param address the address to write, expected in binary
     * @param data the data to write, expected in binary
     * @param enable boolean to enable or not enable the write.
     */
    public void writeMemory(String address, String data, boolean enable) {

        if (!enable) {
            return;
        }

        int index = binaryToDecimal(address);
        dataMemory.set(index, data);
    }

    /**
     * Binary to Decimal converter
     *
     * @param number
     * @return
     */
    private int binaryToDecimal(String number) {
        
        int n = Integer.parseInt(number, 2);
        return n;
    }
    
}
