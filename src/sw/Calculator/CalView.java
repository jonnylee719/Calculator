/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.Calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author Jonathan
 */
public class CalView {
    JTextArea display;
    JButton but0;
    JButton but1;
    JButton but2;
    JButton but3;
    JButton but4;
    JButton but5;
    JButton but6;
    JButton but7;
    JButton but8;
    JButton but9;
    
    JButton butAdd;
    JButton butSubt;
    JButton butMult;
    JButton butDivi;
    
    JButton butEqual;
    JButton butCancel;
    
    JFrame frame;
    JPanel background;
    JPanel buttonPanel;
    
    public CalView(){
        buildGUI();
    }
    
    public void buildGUI(){
        frame = new JFrame();
        background = new JPanel();
        buttonPanel = new JPanel();
        
        but0 = new JButton("0");
        but1 = new JButton("1");
        but2 = new JButton("2");
        but3 = new JButton("3");
        but4 = new JButton("4");
        but5 = new JButton("5");
        but6 = new JButton("6");
        but7 = new JButton("7");
        but8 = new JButton("8");
        but9 = new JButton("9");
        butAdd = new JButton("+");
        butSubt = new JButton("-");
        butMult = new JButton("*");
        butDivi = new JButton("/");
        butEqual = new JButton("=");
        butCancel = new JButton("CE");
        display = new JTextArea();
        
        buttonPanel.setLayout(new GridLayout(0,5));
        buttonPanel.add(but0);
        buttonPanel.add(but1);
        buttonPanel.add(but2);
        buttonPanel.add(but3);
        buttonPanel.add(but4);
        buttonPanel.add(but5);
        buttonPanel.add(but6);
        buttonPanel.add(but7);
        buttonPanel.add(but8);
        buttonPanel.add(but9);
        buttonPanel.add(butAdd);
        buttonPanel.add(butSubt);
        buttonPanel.add(butMult);
        buttonPanel.add(butDivi);
        buttonPanel.add(butEqual);
        buttonPanel.add(butCancel);
        
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        background.add(display);
        background.add(buttonPanel);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(1000, 1500);
        frame.add(background);
        frame.setVisible(true);
    }
    public static void setUIFont(javax.swing.plaf.FontUIResource f){   
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while(keys.hasMoreElements()){
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }
}
