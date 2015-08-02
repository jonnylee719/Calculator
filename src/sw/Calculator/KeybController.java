/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan
 */
public class KeybController {
    public static void main(String[] args){
        JFrame frame = new JFrame("testing action");
        JPanel panel = new JPanel();
        
        String b = "1";
        int mnemonic = 49;
        JButton num1 = new JButton();
        
        KeybController control = new KeybController();
        control.addAction(num1, b, b, mnemonic);
        
        panel.add(num1);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
    }
    
    public void addAction(JButton but, String text, String desc, Integer mnemonic){
        Action butAction = new JButtonAction(text, desc, mnemonic);
        but.setAction(butAction);
    }
    
    class JButtonAction extends AbstractAction{
        public JButtonAction(String text, String desc, Integer mnemonic){
            super(text);
            putValue(SHORT_DESCRIPTION, desc);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("it's pressed");
        }
    }
}
