package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class GamePanel extends JPanel implements Runnable{  
	
    private int x = this.getWidth();  
    private int y = 350; 
    private int x2 = 130;  
    private int y2 = 350;
	private int f=0;
    private int h = 100;  
	private int w = 50;
	private int jumpspeed=10;
	private int runspeed=9;  
	
	
    @Override  
    public void paint(Graphics g) {  
        super.paint(g);  
        g.setColor(Color.green); 
        g.fillOval(x, y, w, h);
        g.setColor(Color.black);
        g.fillRect(x2, y2, w, h);
        
    }  
      
     
    @Override  
    public void run() {  
        while(true){
            x-=runspeed; 
            adjustRect2();
            if(x<0 ){//x>frame width 
                x = this.getWidth();  
                y = 350 ;  
            } 
            
            try {
				Thread.sleep(30);//delay 3 second
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            repaint();
        }
        
          
    }


	private void adjustRect2() {
		// TODO Auto-generated method stub
		
		if(f==1){//f==1 jump up
			y2-=jumpspeed;
			if(y2==y-(h+60)){//jump Max height is 100+60 y2:350-160=190
				f=-1;//f==-1 down
			}
        } 
		else if(f==-1){//f==-1 down
            y2+=jumpspeed;
            if(y2==y){//y2==ground
            	f=0;//f==0 rest
            }
        } 
		else if(f==0){//f==0 rest
            y2=y;
        }
        
		
	}
	public void jump() {
		// TODO Auto-generated method stub
		if(y2==y){//y2==ground
			f=1;
		}
        
           
	}
	
      
           
} 

//Reference: http://larry850806.github.io/2016/06/10/Java-Thread/
//Reference: http://blog.sina.com.cn/s/blog_5c5bc9070100ytxz.html