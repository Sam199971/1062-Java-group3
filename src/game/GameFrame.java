package game;  
  
import java.awt.Color;  
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;  
import javax.swing.JPanel;  
  

public class GameFrame extends JFrame implements KeyListener{  
  
    private static final int WIDTH = 650;//frame width
    private static final int HEIGHT = 600; //frame height
    private GamePanel panel;
      
      
    public GameFrame(){  
        	this.setSize(WIDTH, HEIGHT);//frame size
        	this.setTitle("My game");//frame title
        	this.setVisible(true);
        	addKeyListener(this);//keyboard listen
        
    }
    
    public void draw(){  
        panel= new GamePanel();
        Thread t = new Thread(panel);
        t.start();  
      
        this.add(panel);
    }

	

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_UP){//KeyEvent.VK_UP =>up key on keyboard
			
			panel.jump();
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 
      
      
      
}  
  

 