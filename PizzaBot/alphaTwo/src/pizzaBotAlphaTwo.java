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
    JButton butA, butB, resetBut;
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
        gameTA.setText("You are a pizza delivery bot waiting for your next run. Get high while waiting?");
        mPanel.add(gameTA, BorderLayout.CENTER);

//create buttons and add to bottom panel 
        ListenForButton buttonClick = new ListenForButton();
        
        butA = new JButton("Yes");
        butA.setVisible(true);
        butA.addActionListener(buttonClick);
        bPanel.add(butA);
        
        butB = new JButton("No");
        butB.setVisible(true);
        butB.addActionListener(buttonClick);
        bPanel.add(butB);
        
        resetBut = new JButton("Reset");
        resetBut.setVisible(false);
        resetBut.addActionListener(buttonClick);
        bPanel.add(resetBut);
        
        
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
    				gameTA.setText("Now you're out of <drug>.\nTake delivery near dealer?");
    			}
    			
    			else if(e.getSource() == butB) {
    				level = 11;
        			gameTA.setText("Game over pending further development.\nClick Reset to start over.\nClose window to exit");
        			butA.setVisible(false);
        			butB.setVisible(false);
        			resetBut.setVisible(true); //this else-if model for standard game over   				
    			}
    		}
    		
    		else if(level == 10) {
    			if(e.getSource() == butA) {
    				level = 20;
    				gameTA.setText("As you arrive you see Drug Lord.\nEncounter Drug Lord?");
    			}
    			
    			else if(e.getSource() == butB) {
    				level = 21;
    				gameTA.setText("You take another delivery.\nAt the first house You are offered a hit as a tip. Take it?");
    			}
    		}
    		
    		else if(level == 11) {
    			if(e.getSource() == resetBut) {
    				level = 0;
    				butA.setVisible(true);
    				butB.setVisible(true);
    				resetBut.setVisible(false);
    				stoned = 0;
    				stonedTF.setText("You are " + stoned + "% stoned.");
    				gameTA.setText("You are a pizza delivery bot waiting for your next run. Get high while waiting?");
    			}
    		}
    		
    		
    		else if(level == 20) {
    			if(e.getSource() == butA) {
    				level = 30;
    				gameTA.setText("Drug lord want you to make a delivery. Make it?");
    			}
    			
    			else if(e.getSource() == butB) {
    				if(stoned < 70) {
    					level = 86;
            			gameTA.setText("You panic and run. The last thing you hear is the sound of a particle blaster powering up.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				
    				else if(stoned >= 70 && stoned < 80) {
    					level = 86;
            			gameTA.setText("Guards kick your ass for having the cheek to say no to Darth Uglord.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				
    				else if(stoned >= 80) {
    					level = 86;
            			gameTA.setText("Before you can even say no, you realize that Darth Uglord is actually Darth Atan, the dark one. You attack him for great justice and are murdered by great body guards.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    			}
    		}
    		
    		else if(level == 21) {
    			if(e.getSource() == butA) {
    				level = 31;
    				stoned += 10;
    				stonedTF.setText("You are " + stoned + "% stoned.");
    				gameTA.setText("At the next house you are offered another hit. Take it?");
    			}
    			else if(e.getSource() == butB) {
    				level = 31;
    				gameTA.setText("At the next house you are offered another hit. Take it?");
    			}
    		}
    		
    		else if(level == 30) {
    			if(e.getSource() == butA) {
    				if(stoned < 60) {
    					level = 86;
    					gameTA.setText("You make the delivery without screwing up. Yay. Tomorrow is another day\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				else if(stoned >= 60 && stoned < 70) {
    					level = 86;
    					gameTA.setText("You loudly proclaim that you are proud to take this highly illegal delivery. Darth Uglord\'s guard panic and kick your ass.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				else if(stoned >= 70 && stoned < 80) {
    					level = 86;
    					gameTA.setText("You try to decide if this is real or a halucination. While you stare at Darth Uglord, his guards get nervouse and kick your ass.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				else if(stoned >= 80 && stoned < 90) {
    					level = 40;
    					gameTA.setText("The recipient is so happy he offers you a hit. Take it?");
    				}
    				else if(stoned >=90) {
    					level = 86;
    					gameTA.setText("You get pulled over less than a block away. Yay. Tomorrow is another day\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    			}
    			else if(e.getSource() == butB) {
    				if(stoned < 60) {
    					level = 86;
    					gameTA.setText("Darth Uglord turns out to be a cop.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				else if(stoned >= 60 && stoned < 70) {
    					level = 86;
    					gameTA.setText("Darth Uglord turns out to be a cop who throws you in the drunk tank. You wake up and a released to resume your norma useless life.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				else if(stoned >= 70 && stoned < 80) {
    					level = 86;
    					gameTA.setText("Darth Uglord turns out to be a cop who throws you in the drunk tank. There you are given a hot meal. You are beat up by your fellow inmates who take you food.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    				else if(stoned >= 80) {
    					level = 86;
    					gameTA.setText("Darth Uglord turns out to be a cop who throws you in the drunk tank where you are killed for your shoes.\nClick Reset to start over.\nClose window to exit");
            			butA.setVisible(false);
            			butB.setVisible(false);
            			resetBut.setVisible(true);
    				}
    			}
    		}
    		
    		else if(level == 31) {
    			if(e.getSource() == butA) {
    				level = 41;
    				stoned += 10;
    				stonedTF.setText("You are " + stoned + "% stoned.");
    				gameTA.setText("Again at the next house you are offered another hit. Take it?");
    			}
    			else if(e.getSource() == butB) {
    				level = 41;
    				gameTA.setText("Again at the next house you are offered another hit. Take it?");
    			}
    		}
    		
    		else if(level == 40) {
    			if(e.getSource() == butA) {
    				level = 86;
    				gameTA.setText("You wake up modified pleasurebot in a brothel. Yay!\nHit Reset to cash in on Karma and start over.");
    				butA.setVisible(false);
        			butB.setVisible(false);
        			resetBut.setVisible(true);
    			}
    			else if(e.getSource() == butB) {
    				level = 86;
    				gameTA.setText("No, your reward is a job well done.\nHit reset to return to your shitty job.");
    				butA.setVisible(false);
        			butB.setVisible(false);
        			resetBut.setVisible(true);
    			}
    		}
    		
    		else if(level == 41) {
    			if(e.getSource() == butA) {
    				level = 50;
    				stoned += 15;
    				stonedTF.setText("You are " + stoned + "% stoned.");
    				gameTA.setText("Yet again you are offered another hit. Take it?");
    			}
    			else if(e.getSource() == butB) {
    				level = 50;
    				gameTA.setText("Yet again you are offered another hit. Take it?");
    			}
    		}
    		
    		else if(level == 50) {
    			if(e.getSource() == butA) {
    				level = 60;
    				stoned += 15;
    				stonedTF.setText("You are " + stoned + "% stoned.");
    				gameTA.setText("When it rains drugs as tips it pours drugs as tips. At the next house you are offered another hit. Take it?");
    			}
    			else if(e.getSource() == butB) {
    				level = 60;
    				gameTA.setText("When it rains drugs as tips it pours drugs as tips. At the next house you are offered another hit. Take it?");
    			}
    		}
    		
    		else if(level == 60) {
    			if(stoned >= 90){
    				level = 86;
    				gameTA.setText("You are too high and die in a horrible accident on the way home. There's a lesson to be learned here. Or not.\nHit Reset to cash in on Karma and start over.");
    				butA.setVisible(false);
        			butB.setVisible(false);
        			resetBut.setVisible(true);
    			}
    			else {
    				level = 87;
    				gameTA.setText("Back to work, where the last delivery of the night is to your dealer. Take it?");
    				
    			}
    		}
    		
    		
//game over, reset to beginning    		
    		else if(level == 86) {
    			if(e.getSource() == resetBut) {
    				level = 0;
    				butA.setVisible(true);
    				butB.setVisible(true);
    				resetBut.setVisible(false);
    				stoned = 0;
    				stonedTF.setText("You are " + stoned + "% stoned.");
    				gameTA.setText("You are a pizza delivery bot waiting for your next run. Get high while waiting?");
    			}	
    		}
    		
    		else if(level == 87) {
    			if(e.getSource() == butA) {
    				level = 20;
    				gameTA.setText("As you arrive you see Drug Lord.\nEncounter Drug Lord?");
    			}
    			
    			else if(e.getSource() == butB) {
    				level = 86;
    				gameTA.setText("Tommorrow is another day. Unfortunately.\nHit Reset or close window.");
    				butA.setVisible(false);
        			butB.setVisible(false);
        			resetBut.setVisible(true);
    			}
    		}
    		
    	}
    	
    }
    
}