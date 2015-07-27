/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan
 */
public class CalController {
    private JTextArea display;
    private int add;
    private int subtract;
    private int multiply;
    private int divide;
    
    private String num1;
    private String num2;
    private String result;
    
    private CalModel model;
    private CalView view;
    
    //Constructor
    public CalController(){
        model = new CalModel();
        view = new CalView();
        display = view.display;
        display.setText(model.getTotal());
        addAllListeners();
    }
    
    public void addAllListeners(){
        view.but0.addActionListener(new SimpleOperationListener());
        view.but1.addActionListener(new SimpleOperationListener());
        view.but2.addActionListener(new SimpleOperationListener());
        view.but3.addActionListener(new SimpleOperationListener());
        view.but4.addActionListener(new SimpleOperationListener());
        view.but5.addActionListener(new SimpleOperationListener());
        view.but6.addActionListener(new SimpleOperationListener());
        view.but7.addActionListener(new SimpleOperationListener());
        view.but8.addActionListener(new SimpleOperationListener());
        view.but9.addActionListener(new SimpleOperationListener());
        view.butAdd.addActionListener(new SimpleOperationListener());
        view.butSubt.addActionListener(new SimpleOperationListener());
        view.butMult.addActionListener(new SimpleOperationListener());
        view.butDivi.addActionListener(new SimpleOperationListener());
        view.butEqual.addActionListener(new SimpleOperationListener());
        view.butCancel.addActionListener(new SimpleOperationListener());
        
    }
    
    private class SimpleOperationListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Object source = e.getSource();
            
            if(source == view.but0){
                if(Integer.parseInt(display.getText()) == 0)
                    ;
                else{
                display.append("0");
                }
            }
            else if(source == view.but1){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("1");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("1");
                else{
                display.append("1");}
            }
            else if(source == view.but2){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("2");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("2");
                else{
                display.append("2");}
            }
            else if(source == view.but3){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("3");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("3");
                else{
                display.append("3");}
            }
            else if(source == view.but4){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("4");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("4");
                else{
                display.append("4");}
            }
            else if(source == view.but5){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("5");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("5");
                else{
                display.append("5");}
            }
            else if(source == view.but6){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("6");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("6");
                else{
                display.append("6");}
            }
            else if(source == view.but7){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("7");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("7");
                else{
                display.append("7");}
            }
            else if(source == view.but8){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("8");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("8");
                else{
                display.append("8");}
            }
            else if(source == view.but9){
                if(add == 1 || subtract == 1 || multiply == 1 || divide == 1){
                    display.append("9");
                }
                else if(Integer.parseInt(display.getText()) == 0)
                    display.setText("9");
                else{
                display.append("9");}
            }
            //this is the operation buttons
            else if(source == view.butAdd){
                num1 = display.getText();
                add = 1;
                subtract = 0;
                multiply = 0;
                divide = 0;
                display.append("+");
            }
            else if(source == view.butSubt){
                num1 = display.getText();
                add = 0;
                subtract = 1;
                multiply = 0;
                divide = 0;
                display.append("-");
            }
            else if(source == view.butMult){
                num1 = display.getText();
                add = 0;
                subtract = 0;
                multiply = 1;
                divide = 0;
                display.append("*");
            }
            else if(source == view.butDivi){
                num1 = display.getText();
                add = 0;
                subtract = 0;
                multiply = 0;
                divide = 1;
                display.append("/");
            }
            else if(source == view.butEqual){
                // Calculate the index of the start to num2
                String templ = display.getText();
                int templ2 = num1.length()+1;
                num2 = templ.substring(templ2);
                
                model.setTotal(num1);
                if(add > 0)
                    model.add(num2);
                else if(subtract > 0)
                    model.subtract(num2);
                else if(multiply > 0)
                    model.multiply(num2);
                else if(divide > 0)
                    model.divide(num2);
                
                result = model.getTotal();
                display.setText(result);
            }
            else if(source == view.butCancel){
                model.reset();
                String resetValue = model.getTotal();
                display.setText(resetValue);
            }
        }
    }
}
