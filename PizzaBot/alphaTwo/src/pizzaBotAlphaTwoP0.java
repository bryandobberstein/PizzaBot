/*This is Alpha Two of PizzaBot: The Stonening, an interactive text game.
 * Story by: Jason Brown
 * Written by: Jason Brown and Bryan Dobberstein
 * Coded by: Bryan Dobberstein
 */

import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class pizzaBotAlphaTwoP0 extends JFrame {

    /**
	 * Naming conventions: labels are named for the level on the decision tree, the choice made on the previous level, and
	 * modifiers (at this point level of intoxication is the only modifier). For example, the first label is l0c0s0 (level zero,
	 * choice zero as the only choice made at that point is to turn the game on, stoned 0.
	 */
	private static final long serialVersionUID = 1653874834216389457L;
	JLabel l0c0s0, l1c0s1, l1c1s0, l2c0s1, l2c1s1, l3c0s1, l3c1s1, l3c2s1, l3c3s1;
    JButton yesBut, noBut, resetBut;
    int stoned = 0, level = 0;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
        new pizzaBotAlphaTwoP0();
    }

    public pizzaBotAlphaTwoP0() {
        JPanel thePanel = new JPanel();
            this.add(thePanel, BorderLayout.PAGE_START);

//Generate labels for game text.
//l0
        l0c0s0 = new JLabel("Pizza Bot: The Stonening\nGet high?");
        l0c0s0.setVisible(true);
        thePanel.add(l0c0s0);
//l1 Yes from l0c0s0
        l1c0s1 = new JLabel("You are " + stoned +" stoned.\nYou are out of drug. Take delivery near dealer?");
        l1c0s1.setVisible(false);
        thePanel.add(l1c0s1);
//l1 No from l0c0s0
        l1c1s0 = new JLabel("You are not stoned.\nThis path requires further development");
        l1c1s0.setVisible(false);
        thePanel.add(l1c1s0);
//l2 Yes  
        l2c0s1 = new JLabel("You are " + stoned +" stoned.\nSee dealer.\nEncounter dealer?");
        l2c0s1.setVisible(false);
        thePanel.add(l2c0s1);
//l2 No
        l2c1s1 = new JLabel("You are " + stoned +" stoned.\nYou take another delivery.");
        l2c1s1.setVisible(false);
        thePanel.add(l2c1s1);
//l3
        l3c0s1 = new JLabel("You are " + stoned +" stoned.\nYou encounter drug dealer\nHe wants you to make delivery for him.\nMake delivery?");
        l3c0s1.setVisible(false);
        thePanel.add(l3c0s1);

        l3c1s1 = new JLabel("You are " + stoned +" stoned.\nYou panic and run.\nDL's bodyguard shoots you.");
        l3c1s1.setVisible(false);
        thePanel.add(l3c1s1);

        l3c2s1 = new JLabel("You are " + stoned +" stoned.\n");
        l3c2s1.setVisible(false);
        thePanel.add(l3c2s1);

        l3c3s1 = new JLabel("You are " + stoned +" stoned.\n");
        l3c3s1.setVisible(false);
        thePanel.add(l3c3s1);




        ListenForButton buttonClick = new ListenForButton();
        
        JPanel butpan = new JPanel();
    	this.add(butpan, BorderLayout.PAGE_END);        
//yes button
        yesBut = new JButton("Yes");
        yesBut.addActionListener(buttonClick);
        butpan.add(yesBut);
//no button
        noBut = new JButton("No");
        noBut.addActionListener(buttonClick);                
        butpan.add(noBut);

/*        resetBut = new JButton("Reset");
            resetBut.addActionListener(buttonClick);
            butpan.add(resetBut);*/

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("PizzaBot : the Stonening Alpha 2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }

        private class ListenForButton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == yesBut){
                    if(level == 0) { //level 0
                    	l0c0s0.setVisible(false);
                    	l1c0s1.setVisible(true);
                    	level++;
                    }
                    
                    else if(level == 1) { //level1
                    	l1c0s1.setVisible(false);
                    	l2c0s1.setVisible(true);
                    	level++;
                    }
                    
                    else if(level == 2) { //level 2
                    	l2c0s1.setVisible(false);
                    	l3c0s1.setVisible(true);
                    	level++;
                    }
                }

                else if(e.getSource() == noBut) {
                    if(level == 0) { //level 0 no
                    	l0c0s0.setVisible(false);
                    	l1c1s0.setVisible(true);
                    	level++;
                    }
                }

/*                else if(e.getSource() == resetBut) {
                    lab1.setVisible(true);
                    lab2.setVisible(false);
                    lab3.setVisible(false);
                }*/
            }
        }

		// TODO Auto-generated method stub


}
