/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.Calculator;

/**
 *
 * @author Jonathan
 */
public class CalModel {
    private static final int INITIAL_VALUE = 0;
    private int total;
    
    public CalModel(){
        reset();
    }
    
    public void reset(){
        total = INITIAL_VALUE;
    }
    
    public String getTotal(){
        String retValue = total + "";
        return retValue;
    }
    
    public void setTotal(String in){
        total = Integer.parseInt(in);
    }
    
    public void add(String in){
        int operand = Integer.parseInt(in);
        total = total + operand;
    }
    
    public void subtract(String in){
        int operand = Integer.parseInt(in);
        total = total - operand;
    }
    
    public void multiply(String in){
        int operand = Integer.parseInt(in);
        total = total * operand;
    }
    
    public void divide(String in){
        int operand = Integer.parseInt(in);
        total = total / operand;
    }
    
}
