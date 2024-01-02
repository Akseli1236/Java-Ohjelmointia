package sudoku;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.*;

/**
 *
 * @author aksel
 */
public class Sudoku {
    private int i;
    private int j;
    private char c;
    
    private TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();

    public Sudoku(int i, int j, char c) {
        this.i = i;
        this.j = j;
        this.c = c;
    }
    
    public void set(int i, int j, char c){
        
    }
    
    public void print(){
        
    }
    
    public boolean check(){
        return true;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
    
    
}
