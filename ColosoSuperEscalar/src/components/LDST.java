/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author jose
 */
public class LDST implements Runnable {

    private Thread t;
    private final String threadName;
    
    public LDST(){
        this.threadName = "LDST";
    }
    
    /**
     * Punto de entrada del thread.
     */
    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
