package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Trex extends Shape{
	
	public Trex(Image image, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2) {
		super(image,dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2);
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image,dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2,null);
		g.setColor(Color.red);
		/*g.drawRect(dx1+20*3, dy1+5, 20*3, 20*3);//head
		g.drawRect(dx1+5*3, dy1+22*3, 25*3, 15*3);//body
		g.drawRect(dx1+30*3, dy1+20*3, 6*3, 9*3);//hand
		g.drawRect(dx1+10*3, dy1+38*3, 17*3, 9*3);//foot
		g.drawRect(dx1, dy1+17*3, 5*3, 15*3);//tail*/
		
	}

}
