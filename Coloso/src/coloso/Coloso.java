package coloso;

/**
 *
 * @author nicolasjimenez
 */
public class Coloso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

           System.out.println(binaryToDecimal("10000"));
    }

    private static int binaryToDecimal(String s) {
        int n = Integer.parseInt(s, 2);
        return n ;
    }
}
