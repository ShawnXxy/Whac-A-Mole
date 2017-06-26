package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Play extends JFrame implements Runnable { // using Runnable interface to support multi-thread
	
	private JLabel background; // import background image
	private JLabel [] hamsters; 
	private ImageIcon imgHamster;
	private JLabel scoreboard;
	public Play() {
		this.setResizable(false); // cannot change size of window
		this.getContentPane().setLayout(null); // set to null so that to mannual set display
		this.setTitle("Whac-A-Mole");
		this.setBounds(300, 100, 480, 288); // set windows size, parameters are based on image size
		this.setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Play();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
