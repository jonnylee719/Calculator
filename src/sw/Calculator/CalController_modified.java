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
    private String num1;
    private String num2;
    private String result;
    
    private CalModel model;
    private CalView view;
    
    //States that the controller can be in:
    //0 = no number entered yet
    //1 = num1 entered
    //2 = num2 entered
    private int calState = 0;
    
    public CalController_modified(){
        view = new CalView();
        setUpViewListener();
    }
    
    public void setUpViewListener(){
        view.attach(new ViewListener() {

            @Override
            public void numButPressed(JButton b) {
                numButAction(b);
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
                view.addTextD(crtKey);
            }
        }
        else {                            //if calState == 2
            if(num2.equals("0")){         //num2 is currently 0, so cannot append to num1
                num2 = view.getKeyTop(b); 
                view.setDisplay(num2);
            }
            else{
                String crtKey = view.getKeyTop(b);
                num2 = num2 + crtKey;
                view.addTextD(crtKey);
            }
        }
    }
}
