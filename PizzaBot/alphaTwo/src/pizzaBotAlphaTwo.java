/*This is Alpha Two of PizzaBot: The Stonening, an interactive text game.
 * Story by: Jason Brown
 * Written by: Jason Brown and Bryan Dobberstein
 * Coded by: Bryan Dobberstein
 */

import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class pizzaBotAlphaTwo extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1653874834216389457L;
	JTextArea gameTA;
	JTextField stonedTF;
    JButton butA, butB, butC, butD, resetBut;
    int stoned = 0, level = 0;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
        new pizzaBotAlphaTwo();
    }

    public pizzaBotAlphaTwo() {
        JPanel tPanel = new JPanel(); //create top panel and add to frame
            this.add(tPanel, BorderLayout.PAGE_START);
            
        JPanel mPanel = new JPanel(); //create middle panel and add to frame
        	this.add(mPanel, BorderLayout.CENTER);
        	
        JPanel bPanel = new JPanel(); //create bottom panel and add to frame
        	this.add(bPanel, BorderLayout.PAGE_END);
            
        stonedTF = new JTextField("You are " + stoned + "% stoned.", 12); //create stoned % text field and add to top panel
        stonedTF.setEditable(false);
        tPanel.add(stonedTF);
        
        gameTA = new JTextArea(10, 30); //create main game text area and add to middle panel
        gameTA.setEditable(false);
        gameTA.setLineWrap(true);
        gameTA.setWrapStyleWord(true);
        gameTA.setText("You are a pizza delivery bot waiting for your next run. Get high while waiting?\n\nHit A for yes or B for no.");
        mPanel.add(gameTA, BorderLayout.CENTER);

//create buttons and add to bottom panel 
        ListenForButton buttonClick = new ListenForButton();
        
        butA = new JButton("A");
        butA.setVisible(true);
        butA.addActionListener(buttonClick);
        bPanel.add(butA);
        
        butB = new JButton("B");
        butB.setVisible(true);
        butB.addActionListener(buttonClick);
        bPanel.add(butB);
        
        butC = new JButton("C");
        butC.setVisible(false);
        butC.addActionListener(buttonClick);
        bPanel.add(butC);
        
        butD = new JButton("D");
        butD.setVisible(false);
        butD.addActionListener(buttonClick);
        bPanel.add(butD);
        
        
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("PizzaBot : the Stonening Alpha 2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private class ListenForButton implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
//level 0
    		if(level == 0) {
    			if(e.getSource() == butA) {
    				stoned = 50;
    				stonedTF.setText("You are " + stoned + "% stoned.");
    				level = 10;
    				gameTA.setText("Now you're out of <drug>.\nTake delivery near dealer?\n\nHit A for yes, B for no.");
    			}
    			
    			else if(e.getSource() == butB) {
    				level = 11;
    				gameTA.setText("Game over pending further development of this branch");
    			}
    		}
    		
    		else if(level ==10) {
    			if(e.getSource() == butA) {
    				level = 20;
    				gameTA.setText("As you arrive you see Drug Lord.\nEncounter Drug Lord?\n\nHit A for yes, B for no.");
    			}
    			
    			else if(e.getSource() == butB) {
    				level = 21;
    				gameTA.setText("You take another delivery");
    			}
    		}
    		
    		else if(level == 20) {
    			if(e.getSource() == butA) {
    				level = 30;
    			}
    		}
    		
    	}
    	
    }
    
}