import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class pizzaBotAlphaTwo extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1653874834216389457L;
	JLabel lab1, lab2, lab3;
    JButton but1, but2, resetBut;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
        new pizzaBotAlphaTwo();
    }

    public pizzaBotAlphaTwo() {
        JPanel thePanel = new JPanel();
            this.add(thePanel, BorderLayout.PAGE_START);


        lab1 = new JLabel("You're in a place with some stuff\n");
            lab1.setVisible(true);
            thePanel.add(lab1);

        lab2 = new JLabel("Yay, you did something!\n");
            lab2.setVisible(false);
            thePanel.add(lab2);

        lab3 = new JLabel("You did something wrong. Now you're dead.\n");
            lab3.setVisible(false);
            thePanel.add(lab3);

        ListenForButton buttonClick = new ListenForButton();
        
        JPanel butpan = new JPanel();
    	this.add(butpan, BorderLayout.PAGE_END);        

        but1 = new JButton("Choice 1");
            but1.addActionListener(buttonClick);
            butpan.add(but1);

        but2 = new JButton("Choice 2");
            but2.addActionListener(buttonClick);                
            butpan.add(but2);

        resetBut = new JButton("Reset");
            resetBut.addActionListener(buttonClick);
            butpan.add(resetBut);

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("PizzaBot : the Stonening Alpha 2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }

        private class ListenForButton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == but1){
                    lab1.setVisible(false);
                    lab2.setVisible(true);
                    lab3.setVisible(false);
                }

                else if(e.getSource() == but2) {
                    lab1.setVisible(false);
                    lab2.setVisible(false);
                    lab3.setVisible(true);
                }

                else if(e.getSource() == resetBut) {
                    lab1.setVisible(true);
                    lab2.setVisible(false);
                    lab3.setVisible(false);
                }
            }
        }

		// TODO Auto-generated method stub


}
