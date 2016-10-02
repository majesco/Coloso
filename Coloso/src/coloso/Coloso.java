package coloso;

import GUI.IDE;

/**
 *
 * @author nicolasjimenez
 */
public class Coloso  {


    private static int binaryToDecimal(String s) {
        int n = Integer.parseInt(s, 2);
        return n ;
    }
    
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String concat = "01011";
        String base = "000001";
        System.out.println(concat + base);
        IDE ide = new IDE();
        

    }
    
}
