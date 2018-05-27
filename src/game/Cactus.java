package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Cactus extends Shape {
	
	
	public Cactus(Image image, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2) {
		super(image,dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image,dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2,null);
		g.setColor(Color.red);
		/*g.drawRect(dx1+5*3, dy1+5, 7*3, 50*3);//body
		g.drawRect(dx1, dy1+30, 5*3, 15*3);//hand
		g.drawRect(dx1+12*3, dy1+20, 5*3, 15*3);//hand*/
	}

}
