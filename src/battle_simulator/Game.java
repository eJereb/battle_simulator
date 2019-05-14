package battle_simulator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GUI extends JFrame{
	public GUI() {
	    super();
	    
	    setTitle("V procesu");
	    setLayout(new BorderLayout());
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setMinimumSize(new Dimension(800, 600));

	    add( new Main(), BorderLayout.NORTH);
	    add( new Inp_B(), BorderLayout.SOUTH);
	    pack();
	  }			
}

class Main extends JPanel{
	public Main() {
		setMinimumSize(new Dimension(800, 400));
		
	}
	
}

class Inp_B extends JPanel{
	public Inp_B() {
		setMinimumSize(new Dimension(800, 200));
		setLayout(new GridBagLayout());
		GridBagConstraints gbag = new GridBagConstraints();
		gbag.fill = GridBagConstraints.HORIZONTAL;
		
		JButton b1 = new JButton("Do nothing");
		gbag.fill = GridBagConstraints.HORIZONTAL;
		gbag.ipady = 50;
		gbag.ipadx = 275;
		gbag.gridx = 0;
		gbag.gridy = 0;
	    add(b1, gbag);
	    
	    JButton b2 = new JButton("Also does nothing");
	    gbag.fill = GridBagConstraints.HORIZONTAL;
	    gbag.gridx = 1;
		gbag.gridy = 0;
	    add(b2, gbag);
	    
	    JButton b3 = new JButton("same thing");
	    gbag.fill = GridBagConstraints.HORIZONTAL;
	    gbag.gridx = 0;
		gbag.gridy = 1;
	    add(b3, gbag);
	    
	    JButton b4 = new JButton("the same as others");
	    gbag.fill = GridBagConstraints.HORIZONTAL;
	    gbag.gridx = 1;
		gbag.gridy = 1;
	    add(b4, gbag);
	    
	    
	}
	
}




public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui=new GUI();
		gui.setVisible(true);

	}	

}
