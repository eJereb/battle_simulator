package battle_simulator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

class GUI extends JFrame{
	
	public Inp_B gumbi;
	public Main main;
	
	public GUI() {
	    super();
	    
	    setTitle("V procesu");
	    setLayout(new BorderLayout());
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setMinimumSize(new Dimension(800, 600));
	    setResizable(false);
	    gumbi=new Inp_B();
	    main=new Main();
	    add( main, BorderLayout.NORTH);
	    add( gumbi, BorderLayout.SOUTH);
	    pack();
	  }			
}



class Main extends JPanel{
	BufferedImage ozadje;
	BufferedImage igralec1;
	BufferedImage igralec2;
	JProgressBar[] pbars = new JProgressBar[2];
	
	
	public void setProgresBars() {
		for(int i=0;i<2;i++) {
			pbars[i] = new JProgressBar();
			pbars[i].setMinimum(0);
			pbars[i].setMaximum(100);
			pbars[i].setValue(100);
			pbars[i].setBackground(null);
			pbars[i].setBounds(30+i*550, 250, 150, 15);
			pbars[i].setForeground(new Color(0, 255, 0));
			add(pbars[i]);
		}setLayout(null);
	}
	public void updateProgressBars (Character[] characters) {
		for(int i=0;i<2;i++) {
			pbars[i].setValue(characters[i].getCurr_stats()[0]);
		}
	}

	public Main() {
		//setMinimumSize(new Dimension(800, 400));
		ozadje = null;
		try { 
			ozadje = ImageIO.read(new File("slike/Ozadje.png"));
			igralec1 = ImageIO.read(new File("slike/Jerry.png"));
			igralec2 = ImageIO.read(new File("slike/Tom.png"));
							
		} catch(IOException e){	
		}
		setProgresBars();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(ozadje, 0, 0, 800, 400, this);
		g.drawImage(igralec1, 50, 250, 100, 100, this);
		g.drawImage(igralec2, 600, 250, 100, 100, this);
			
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 400);
	}
}
class Inp_B extends JPanel{
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	
	public void changeButtons(Character character) {
		JButton[] buttons = {button1,button2,button3,button4};
		for (int i=0;i<character.getSkills().length;i++) {
			buttons[i].setText(character.getSkills()[i].getName());
			buttons[i].addActionListener(new AListener(character.getSkills()[i]));
		}
	}
	
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
	    button1=b1;
	    
	    JButton b2 = new JButton("Also does nothing");
	    gbag.fill = GridBagConstraints.HORIZONTAL;
	    gbag.gridx = 1;
		gbag.gridy = 0;
	    add(b2, gbag);
	    button2=b2;
	    
	    JButton b3 = new JButton("same thing");
	    gbag.fill = GridBagConstraints.HORIZONTAL;
	    gbag.gridx = 0;
		gbag.gridy = 1;
	    add(b3, gbag);
	    button3=b3;
	    
	    JButton b4 = new JButton("the same as others");
	    gbag.fill = GridBagConstraints.HORIZONTAL;
	    gbag.gridx = 1;
		gbag.gridy = 1;
	    add(b4, gbag);
	    button4=b4;
	    	    
	}	
}

class AListener implements ActionListener{
	private final Skill skill;
	
	AListener(Skill skill){
		super();
		this.skill=skill;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game.skillClick(this.skill);
	}
}

public class Game {
	
	public static int whosTurnIsIt;
	// gets first used skill and second  for that turn
	public static Skill[] selectedSkills = new Skill[2];
	public static int counter;
	
	public static void skillClick(Skill skill) {
		selectedSkills[whosTurnIsIt]=skill;
		counter=0;
	}
	
	public static int damage_calcualtion(Character[] characters) {
		int speed_priority = speed_calcualtion(characters);
		switch(selectedSkills[speed_priority].getFun_Name()) {
		case "atack_ability"  : atack_ability(characters[speed_priority],characters[1-speed_priority],selectedSkills[speed_priority].getType(),selectedSkills[speed_priority].getNumber());break;
		case "buff_ability"   : buff_ability(characters[speed_priority],characters[1-speed_priority],selectedSkills[speed_priority].getNumber());break;
		case "debuff_ability" : debuff_ability(characters[speed_priority],characters[1-speed_priority],selectedSkills[speed_priority].getNumber());break;
		case "heal_ability"   : heal_ability(characters[speed_priority],characters[1-speed_priority],selectedSkills[speed_priority].getNumber());break;
		}
		if(characters[1-speed_priority].getCurr_stats()[0] <= 0) {
			if(1-speed_priority == 0)
			 return -1;
			else return 1;
		}
		switch(selectedSkills[1-speed_priority].getFun_Name()) {
		case "atack_ability"  : atack_ability(characters[1-speed_priority],characters[speed_priority],selectedSkills[1-speed_priority].getType(),selectedSkills[1-speed_priority].getNumber());break;
		case "buff_ability"   : buff_ability(characters[1-speed_priority],characters[speed_priority],selectedSkills[1-speed_priority].getNumber());break;
		case "debuff_ability" : debuff_ability(characters[1-speed_priority],characters[speed_priority],selectedSkills[1-speed_priority].getNumber());break;
		case "heal_ability"   : heal_ability(characters[1-speed_priority],characters[speed_priority],selectedSkills[1-speed_priority].getNumber());break;
		}
		if(characters[speed_priority].getCurr_stats()[0] <= 0) {
			if(speed_priority == 0)
			 return -1;
			else return 1;
		}
		return 0;
		
		
		
	}
	
	public static int speed_calcualtion(Character[] characters) {
		if (characters[0].getCurr_stats()[5]<characters[1].getCurr_stats()[5]) {
			return 1;
		} else return 0;
	}
	
	
	public static Character createTom() {
		//Creates and return a game character 
		Character tom = new Character();
		int[] stat_Table = {100,50,150,30,70,100};
		//Skills for Tom format: name, desc, cd,type, fun_name, num
		Skill scratch = new Skill("scratch","Scratches the opponent",0,"physical","atack_ability",40);
		Skill scary_face = new Skill("Scary face","Scares the opponent",4,"special","debuf_ability",1/3);
		Skill sleep = new Skill("sleep","Recovs some health",6,"special","heal_ability",50);
		Skill assasinate = new Skill("assasinate","Deals heavy damage to opponent",10,"physical","atack_ability",90);
		Skill[] skills = {scratch,scary_face,sleep,assasinate};
		int[] skill_cd = {0,0,0,0};
		tom.setSTART_STATS(stat_Table);
		tom.setCurr_stats(stat_Table);
		tom.setSkills(skills);
		tom.setSkill_cd(skill_cd);
		return tom;
	}
	public static Character createJerry() {
		//Creates and return a game character 
		Character jerry = new Character();
		int[] stat_Table = {100,70,50,40,150,80};
		//Skills for Tom format: name, desc, cd,type, fun_name, num
		Skill bite = new Skill("Bite","Bites the opponent",0,"physical","atack_ability",80);
		Skill chesse = new Skill("Chesse","Throws chesse at the opponent",4,"special","atack_ability",60);
		Skill Heal = new Skill("Heal","Heals self for a set amount",5,"special","heal_ability",50);
		Skill tail_atack = new Skill("Tail Atack","attacks opponet with a tail",0,"physical","atack_ability",60);
		Skill[] skills = {tail_atack,chesse,Heal,bite};
		int[] skill_cd = {0,0,0,0};
		jerry.setSTART_STATS(stat_Table);
		jerry.setCurr_stats(stat_Table);
		jerry.setSkills(skills);
		jerry.setSkill_cd(skill_cd);
		return jerry;
		
	}
	
	public static void atack_ability(Character self,Character enemy,String type, int dmg) {
		int hp = enemy.getCurr_stats()[0];
		if (type=="special") {
			hp = hp - self.getCurr_stats()[3]*dmg/(enemy.getCurr_stats()[4]*4);
		} else {
			hp = hp - self.getCurr_stats()[1]*dmg/(enemy.getCurr_stats()[2]*4);
		}
		enemy.setHP(hp);
	}
	
	public static void buff_ability(Character self,Character enemy, int change) {
		int[] stats = self.getCurr_stats();
		for (int i=0;i<stats.length;i++) {
			stats[i] = stats[i]*change;
		}
		self.setCurr_stats(stats);
	}
	
	public static void debuff_ability(Character self,Character enemy, int change) {
		int[] stats = enemy.getCurr_stats();
		for (int i=1;i<stats.length;i++) {
			stats[i] = stats[i]*change;
		}
		enemy.setCurr_stats(stats);
	}
	
	public static void heal_ability(Character self,Character enemy, int heal) {
		int hp = self.getCurr_stats()[0];
		self.setHP(hp+heal);
	}
	

	public static void main(String[] args) {
		GUI gui=new GUI();
		gui.setVisible(true);
		Character[] characters = {createJerry(),createTom()};
		gui.gumbi.changeButtons(characters[0]);
		whosTurnIsIt = 0;
		int whoWon=0;
		counter=1;
		String str="";
		//mainloop
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(counter == 0) {
				whosTurnIsIt=1-whosTurnIsIt;
				if (whosTurnIsIt == 0) {
					whoWon = damage_calcualtion(characters);
					gui.main.updateProgressBars(characters);
					if (whoWon != 0) break;
				}
				gui.gumbi.changeButtons(characters[whosTurnIsIt]);
				counter=1;
			}	
		}while(true);
		if (whoWon == 1) str="Player 1 wins";
		else str="Player 2 wins";
		JOptionPane.showMessageDialog(null, str);
			

	}	

}
