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
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
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
    
    private JButton butCancel;
    
    private JFrame frame;
    private JPanel background;
    private JPanel buttonPanel;
    
    private ViewListener listen;
    private KeybController keyControl;
    
    public CalView(){
        keyControl = new KeybController();
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
        display.setEditable(false);
        
        buttonPanel.add(setNumPanel());
        buttonPanel.add(setOperPanel());
        
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        background.add(display);
        background.add(buttonPanel);
        background.add(setCanPanel());
        
        frame.addWindowFocusListener(new WindowAdapter() {
         public void windowGainedFocus(WindowEvent e) {
        background.requestFocusInWindow();
        }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 1000);
        frame.setLocation(1200, 0);
        frame.add(background);
        frame.setVisible(true);
    }
    
    public JPanel setNumPanel(){
        String numString = "789456123 0 ";
        int[] keyArray = {55, 56, 57, 52, 53, 54, 49, 50, 51, 255, 48, 255};
        numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(5, 3, 2, 2));
        for(int i = 0; i < numString.length(); i++){
            String butTop = numString.substring(i, i+1);
            JButton numBut = new JButton();
            keyControl.addAction(numBut, butTop, butTop, keyArray[i]);
            if(butTop.equals(" ")){
                numBut.setEnabled(false);
            }
            else
                numBut.addActionListener(new numActionListener());
            setUpNumKeyboard(numBut, numString.charAt(i));
            numPanel.add(numBut);
        }
        return numPanel;
    }
    
    public void setUpNumKeyboard(JComponent c, char k){
        String name = (KeyStroke.getKeyStroke(k)).toString();
        numButAction action = new numButAction(name);
        c.getInputMap(c.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(k), name);
        c.getActionMap().put(name, action);
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
            setUpOperKeyboard(operBut, operString.charAt(i));
            operPanel.add(operBut);
        }
        return operPanel;
    }
    
    public void setUpOperKeyboard(JButton c, char k){
        class operButAction extends AbstractAction{
        public operButAction(String s){
            super(s);
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            //System.out.println("actionPerformed in Action class");
            JButton source = (JButton) ae.getSource();
            ActionListener[] aListener = source.getActionListeners();
            aListener[0].actionPerformed(ae);
        }
        
        }
        
        String name = (KeyStroke.getKeyStroke(k)).toString();
        operButAction action = new operButAction(name);
        c.getInputMap(c.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(k), name);
        c.getActionMap().put(name, action);
    }
    
    private class operActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.print("got to actionPerformed in operActionListener");
            JButton source = (JButton) e.getSource();
            listen.operButPressed(source);
        }
        
    }
    
    public JPanel setCanPanel(){
        JPanel canPanel = new JPanel();
        butCancel = new JButton("Clear");
        butCancel.addActionListener(new canActionListener());
        canPanel.add(butCancel);
        return canPanel;
    }
    
    private class canActionListener implements ActionListener{
        @Override 
        public void actionPerformed(ActionEvent e){
            JButton source = (JButton) e.getSource();
            listen.clearButPressed(source);
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
    
    class numButAction extends AbstractAction{
        public numButAction(String s){
            super(s);
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton source = (JButton) ae.getSource();
            ActionListener[] aListener = source.getActionListeners();
            aListener[0].actionPerformed(ae);
        }
        
    }
    
}
