package game;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Rect {
	protected int x,y,w,h;
	
	public Rect(int x, int y, int w, int h) {
		// TODO Auto-generated constructor stub
		this.h=h;
		this.w=w;
		this.x=x;
		this.y=y;
		
		
	}
	public Rect() {
		// TODO Auto-generated constructor stub
	}
	public abstract void draw(Graphics g);
	

}
