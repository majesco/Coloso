/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.Observable;

/**
 *
 * @author jose
 */
public class Schedule extends Observable {
    
    private final int[][] schedule;
    private static Schedule instance;
    
    public Schedule(int instructions) {
        schedule = new int[instructions][3];
    }
    
    /**
     * Singleton
     *
     * @param instructions
     * @return
     */
    public static Schedule getInstance(int instructions) {
        if (instance == null) {
            instance = new Schedule(instructions);
        }
        return instance;
    }
    
    public void insertSheduleCicle(int cicle, int stage, int instruction) {
        this.schedule[instruction-1][stage] = cicle;
    }
    
}
