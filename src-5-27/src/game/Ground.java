package game;

import java.awt.Graphics;
import java.awt.Image;

public class Ground extends Shape {

	public Ground(Image image, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2) {
		super(image,dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image,dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2,null);
	}

}
