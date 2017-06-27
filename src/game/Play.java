package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Play extends JFrame implements Runnable { // using Runnable interface to support multi-thread
	
	private JLabel background; // import background image
	private JLabel[] hamsters; // use an array because there should be 9 hamsters in this game
	private ImageIcon imgHamster;
	private JLabel scoreboard;
	private int score = 0;
	// intializing game
	public Play() {
		// create game window
		this.setResizable(false); // cannot change size of window
		this.getContentPane().setLayout(null); // set to null so that to mannual set display
		this.setTitle("Whac-A-Mole");
		this.setBounds(300, 100, 480, 288); // set windows size, parameters are based on image size
		// create background image
		background = new JLabel();
		ImageIcon image = new ImageIcon(this.getClass().getResource("background.jpg")); // find background image
		background.setIcon(image);
		background.setBounds(0, -35, 480, 288);
		// set cursor
//		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(""), new Point(), "self" ));
		// create hamsters
		imgHamster = new ImageIcon(this.getClass().getResource("mole.png"));
		hamsters = new JLabel[9];
		for (int i = 0; i < 9; i++) { 
			hamsters[i] = new JLabel();
			hamsters[i].setSize(imgHamster.getIconWidth(), imgHamster.getIconHeight());
//			hamsters[i].setIcon(imgHamster);
			// set mouse event listener
			hamsters[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Object obj = e.getSource();
					if (obj instanceof JLabel) {// if JLabel is clicked, make the source of the event to JLabel 
						JLabel label = (JLabel) obj;
						if (label.getIcon() != null) { // click event only works when image of hamster is shown
							score++;
							scoreboard.setText("Your Score: " + score);
						}
						label.setIcon(null); // hamster is hidden when clicked
					}
				}
			});
			this.getContentPane().add(hamsters[i]);
		}
		// coordinates for each hamster
		hamsters[0].setLocation(88, 53);
		hamsters[1].setLocation(240, 53);
		hamsters[2].setLocation(390, 53);
		hamsters[3].setLocation(55, 160);
		hamsters[4].setLocation(245, 160);
		hamsters[5].setLocation(430, 160);
		hamsters[6].setLocation(36, 296);
		hamsters[7].setLocation(230, 296);
		hamsters[8].setLocation(445, 296);
		// scoreboard
		scoreboard = new JLabel();
		scoreboard.setBounds(360, 10, 230, 50); // position
		scoreboard.setFont(new Font("", 20 , 25)); // font
		scoreboard.setForeground(Color.blue); // color
		scoreboard.setText("Your Score: ");
		this.getContentPane().add(scoreboard);
		
		this.getContentPane().add(background);
		
		this.setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Play p1 = new Play();
		Thread t1 = new Thread(p1);
		t1.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(500);
				int index = (int) (Math.random() * 9); // hamster randomly show
				// make hamster show and hide constantly
				if (hamsters[index].getIcon() == null) {
					hamsters[index].setIcon(imgHamster);
					Thread.sleep(900); // hamster show in 900ms
					if (hamsters[index].isShowing()) {
						hamsters[index].setIcon(null);
					}
				}
			} catch (InterruptedException e) {
				
			}		
		}
	}

}
