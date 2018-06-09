package game;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Shape {
	protected int dx1,dy1,dx2,dy2,sx1,sy1,sx2,sy2,ox1,ox2;
	protected Image image;
	
	public Shape(Image image, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2) {
		// TODO Auto-generated constructor stub
		this.image=image;
		this.dx1=dx1;
		this.dy1=dy1;
		this.dx2=dx2;
		this.dy2=dy2;
		this.sx1=sx1;
		this.sy1=sy1;
		this.sx2=sx2;
		this.sy2=sy2;
		this.ox1=dx1;
		this.ox2=dx2;
	}
	public abstract void draw(Graphics g);
	
}
