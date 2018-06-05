package slick.tutorial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Checkbox {
	public float x ,y, w, h;
	public Checkbox(float dx1, float dy1,float w,float h){//t=target
		this.x=dx1;
		this.y=dy1;
		this.h=h;
		this.w=w;
		
		
		
		
	}
	public void draw(org.newdawn.slick.Graphics g){
		
		g.setColor(org.newdawn.slick.Color.red);
		g.drawRect((int)x, (int)y, (int)w,(int)h);
		
	}
	
}
/*g.drawRect(dx1+5*3, dy1+5, 7*3, 50*3);//body
g.drawRect(dx1, dy1+30, 5*3, 15*3);//L hand
g.drawRect(dx1+12*3, dy1+20, 5*3, 15*3);//R hand*/

/*g.drawRect(dx1+20*3, dy1+5, 20*3, 20*3);//head
g.drawRect(dx1+5*3, dy1+22*3, 25*3, 15*3);//body
g.drawRect(dx1+30*3, dy1+20*3, 6*3, 9*3);//hand
g.drawRect(dx1+10*3, dy1+38*3, 17*3, 9*3);//foot
g.drawRect(dx1, dy1+17*3, 5*3, 15*3);//tail*/

