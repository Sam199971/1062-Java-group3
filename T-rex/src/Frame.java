import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.peer.ComponentPeer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	final int y = 400;
	int x=700;
	
	ImageIcon stree,btree;
	JLabel label;
	private JLabel label2;
	public Frame() {
		super();
		getContentPane().setLayout(null);
		btree = new ImageIcon(getClass().getResource("2b.PNG"));
		stree = new ImageIcon(getClass().getResource("2s.PNG"));
		
		
		
		//make();
		
		
		
		//label = new JLabel(btree);
		
		//label.setBounds(x, y,btree.getIconWidth(),btree.getIconHeight());
		
		
		
		//this.add(label);
		//this.move();
	}
	
	void make() {
		int k=3;
		label = new JLabel(btree);
		label.setBounds(x, y,btree.getIconWidth(),btree.getIconHeight());
			
		this.add(label);
		
		
	}
	
	
	void move() {
        while(true){
            label.setLocation(x,y);  
            try {
            	Thread.currentThread().sleep(50); 
          	}catch (InterruptedException e) {  
            	e.printStackTrace();  
            }  
            x-=10;
            if(x<-label.getWidth()) {
            	x=this.getWidth();
            }
        }
	}

	
	
	
}
