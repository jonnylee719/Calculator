/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.Calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author Jonathan
 */
public class CalView {
    private JTextArea display;
    
    //All numBut
    private JButton numBut;
    private JPanel numPanel;
    
    //All OperaBut
    private JButton operBut;
    private JPanel operPanel;
    
    JButton butCancel;
    
    private JFrame frame;
    private JPanel background;
    private JPanel buttonPanel;
    
    ViewListener listen;
    
    public CalView(){
        buildGUI();
    }
    
    public void buildGUI(){
        try{
            setUIFont(new javax.swing.plaf.FontUIResource("Sans Serif", Font.BOLD, 30));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        frame = new JFrame("Calculator App");
        background = new JPanel();
        buttonPanel = new JPanel();
        display = new JTextArea();
        
        buttonPanel.add(setNumPanel());
        buttonPanel.add(setOperPanel());
        
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        background.add(display);
        background.add(buttonPanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 1000);
        frame.setLocation(1200, 0);
        frame.add(background);
        frame.setVisible(true);
    }
    
    public JPanel setNumPanel(){
        String numString = "789456123 0 ";
        numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(5, 3, 2, 2));
        for(int i = 0; i < numString.length(); i++){
            String butTop = numString.substring(i, i+1);
            JButton numBut = new JButton(butTop);
            if(butTop.equals(" ")){
                numBut.setEnabled(false);
            }
            else
                numBut.addActionListener(new numActionListener());
            numPanel.add(numBut);
        }
        return numPanel;
    }
    
    private class numActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton source = (JButton) e.getSource();
            listen.numButPressed(source);
        }
    }
    
    public JPanel setOperPanel(){
        operPanel = new JPanel();
        operPanel.setLayout(new GridLayout(5, 1, 2, 2));
        String operString = "+-*/=";
        for(int i = 0; i< operString.length(); i++){
            String keyTop = operString.substring(i, i+1);
            operBut = new JButton(keyTop);
            operBut.addActionListener(new operActionListener());
            operPanel.add(operBut);
        }
        return operPanel;
    }
    
    private class operActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            listen.operButPressed(source);
        }
    }
    
    public void attach(ViewListener vl){
        this.listen = vl;
    }
    
    public CalView getCurrentView(){
        return this;
    }
    
    public JTextArea getDisplay(){
        return display;
    }
    
    public void addTextD(String s){
        display.append(s);
    }
    
    public void setDisplay(String s){
        display.setText(s);
    }
    
    public String getKeyTop(JButton b){
        return b.getText();
    }
    public static void setUIFont(javax.swing.plaf.FontUIResource f){   
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while(keys.hasMoreElements()){
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof javax.swing.plaf.FontUIResource) 
                UIManager.put(key, f);
        }
    }
}
