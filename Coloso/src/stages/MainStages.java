package stages;

import components.*;
import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class MainStages {

    private final InstructionMemory instructions = InstructionMemory.getInstance();
    private final RegisterBank registers = RegisterBank.getInstance();

    public static void main(String[] args) throws InterruptedException {

          //MainStages main = new MainStages();
          //main.start(3);
    }

    public void start(int cantidadInstrucciones) throws InterruptedException {


        System.out.println("cant "+cantidadInstrucciones);
        while( cantidadInstrucciones>0){
            
            String instruction =fetch();
            ArrayList<String> decoded = decode(instruction);
            ArrayList<String> executed = execute(decoded);
            ArrayList<String> memory = memory(executed);
            writeBack(memory);
           
            cantidadInstrucciones--;
        }
        
   
    }

    private String fetch() throws InterruptedException {

        InstructionFetch temp = new InstructionFetch();

        temp.start();
        return temp.getInstructionFetched();
    }

    private ArrayList<String> decode(String instruction) throws InterruptedException {

        InstructionDecode temp = new InstructionDecode(instruction);

        temp.start();
        return temp.getOutput();
    }

    private ArrayList<String> execute(ArrayList<String> decoded) throws InterruptedException {

        ExecutionStage temp = new ExecutionStage(decoded);

        temp.start();
        return temp.getOutput();
    }

    private ArrayList<String> memory(ArrayList<String> exceuted) throws InterruptedException {

        MemoryStage temp = new MemoryStage(exceuted);

        temp.start();
        return temp.getOutput();
    }

    private void writeBack(ArrayList<String> memorized) throws InterruptedException {

        WriteBackStage temp = new WriteBackStage(memorized);

        temp.start();
    }

}
