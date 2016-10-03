package coloso;

import GUI.IDE;

/**
 *
 * @author nicolasjimenez
 */
public class Coloso {

    private static int binaryToDecimal(String s) {
        int n = Integer.parseInt(s, 2);
        return n;
    }

    public Coloso() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ObservableValue ov = new ObservableValue(0);
        TextObserver to = new TextObserver(ov);
        ov.addObserver(to);
        
        ov.setValue(23);
    }
}
