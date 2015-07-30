/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.Calculator;

import javax.swing.JButton;

/**
 *
 * @author Jonathan
 */
public class CalController_modified {
    private String num1 = "";
    private String num2 = "";
    private String crtOper;
    private String result;
    
    private CalModel model;
    private CalView view;
    
    //States that the controller can be in:
    //0 = no number entered yet
    //1 = num1 entered
    //2 = num1 entered and operator entered
    private int calState = 0;
    private boolean operEntered = false;
    
    public CalController_modified(){
        model = new CalModel();
        view = new CalView();
        setUpViewListener();
    }
    
    public void setUpViewListener(){
        view.attach(new ViewListener() {

            @Override
            public void numButPressed(JButton b) {
                numButAction(b);
            }
            
            @Override
            public void operButPressed(JButton b){
                operButAction(b);
            }
            
            @Override
            public void clearButPressed(JButton b){
                clearButAction(b);
            }
        });
    }
    
    public void numButAction(JButton b){
        if(calState == 0){
            calState = 1;
            num1 = view.getKeyTop(b);
            view.setDisplay(num1);
        }
        else if (calState == 1){ 
            if(num1.equals("0")){         //the first number is 0, so cannot append to num1
                num1 = view.getKeyTop(b); 
                view.setDisplay(num1);
            }
            else{
                String crtKey = view.getKeyTop(b);
                num1 = num1 + crtKey;
                view.setDisplay(num1);
            }
        }
        else if(calState == 2){
            if(num2.equals("") || num2.equals("0")){
                num2 = view.getKeyTop(b); 
            }
            else{
                String crtKey = view.getKeyTop(b);
                num2 = num2 + crtKey;
            }
            view.setDisplay(num1 + crtOper + num2);
        }
    }
    
    public void operButAction(JButton b){
        String keyTop = view.getKeyTop(b);
        if(calState == 0 && !result.equals("")){ // Conditions calState == 0, crtOper == "", operEntered == false
            if(keyTop.equals("=")){
                view.setDisplay(result);
            }
            else{
            num1 = result;
            result = "";
            calState = 2;
            crtOper = keyTop;
            operEntered = true;
            view.setDisplay(num1 + crtOper);
            }
        }
        else if(calState == 0){
            view.setDisplay("Error! Need to enter number first.");
        }
        else if (calState == 1){
            if(keyTop.equals("=")){
                result = num1;
                calState = 0;
                operButAction(b);
            }
            else{ // This means the keyTop is +,-,*,/
                crtOper = keyTop;
                operEntered = true;
                view.setDisplay(num1 + crtOper);
                calState = 2;
            }
        }
        else if (calState == 2 && num2 == ""){
            calState = 1;
            operButAction(b);
        }
        else if(calState == 2){
            if(keyTop.equals("=")){
                result = doOperation(crtOper);
                view.setDisplay(result);
            }
            else{ 
                num1 = doOperation(crtOper);
                crtOper = keyTop;
                view.setDisplay(num1 + crtOper);
                calState = 2;
                operEntered = true;
            }
        }
    }
    
    public String doOperation(String operator){
        String rlt = null;
        if(crtOper.equals("+")){
            model.setTotal(num1);
            model.add(num2);
            rlt = model.getTotal();
            //System.out.println(rlt);
        }
        else if(crtOper.equals("-")){
            model.setTotal(num1);
            model.subtract(num2);
            rlt = model.getTotal();
        }
        else if(crtOper.equals("*")){
            model.setTotal(num1);
            model.multiply(num2);
            rlt = model.getTotal();
        }
        else if(crtOper.equals("/")){
             model.setTotal(num1);
             model.divide(num2);
             rlt = model.getTotal();
        }
        num1 = "";
        num2 = "";
        crtOper = "";
        operEntered = false;
        calState = 0;
        return rlt;
    }
    
    public void clearButAction(JButton b){
        
    }
}
