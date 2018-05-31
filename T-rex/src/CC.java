import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CC extends JFrame{
	
	
	public static void main(String[] args) {
		Frame ff=new Frame();
		ff.setSize(800,800);
		ff.setVisible(true);
		ff.make();
		ff.move();
		
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
