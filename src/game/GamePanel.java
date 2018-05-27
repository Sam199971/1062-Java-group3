package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class GamePanel extends JPanel implements Runnable {

	private int f = 0;// jump flag
	private int jumpspeed = 20;
	private int downspeed = 19;
	private int runspeed = 15;
	private boolean hit = true;
	private long time;// time
	private int jumphight = 240;
	private int dx1 = this.getWidth();
	private int dy1 = 315 + 43;
	private int dx2 = 150;
	private int dy2 = 50 * 3 + 315 + 43;

	private Image image;
	private Shape shape[];
	private int hiting,hiting2;
	private Checkbox c[], c2[];
	int m=0;//move flag
	
	@Override
	public void run() {
		// time = -System.currentTimeMillis();//get now time
		
		try {
			image = ImageIO.read(this.getClass().getResource("2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		shape = new Shape[7];

		shape[0] = new Trex(image, 0 + 150, 0 + 315 + 43, (891 - 848) * 3 + 150, 50 * 3 + 315 + 43, 848, 0, 891, 50);// T.rex
		shape[1] = new Cactus(image, 0 + this.getWidth(), 0 + 347 + 43, (245 - 228) * 3 + this.getWidth(),
				37 * 3 + 347 + 43, 228, 0, 245, 37);// Cactus
		shape[2] = new Cloud(image, 0 + this.getWidth(), 0 + 100, (133 - 85) * 3 + this.getWidth(), 17 * 3 + 100, 85, 0,
				133, 17);// Cloud
		shape[3] = new Ground(image, 0, 0 + 458 + 43, 1180 * 6, (70 - 58) * 6 + 458 + 43, 0, 58, 1180, 70);// Ground
		shape[4] = new Ground(image, 1180 * 6, 0 + 458 + 43, 1180 * 6 + 1180, (70 - 58) * 6 + 458 + 43, 0, 58, 1180, 70);// Ground2
        
		shape[5] = new Trex(image, 0 + 150, 0 + 315 + 43, (980-936) * 3 + 150, 48 * 3 + 315 + 43, 936, 0, 980, 48);// T.rex 1 move
		shape[6] = new Trex(image, 0 + 150, 0 + 315 + 43, (1024-980) * 3 + 150, 48 * 3 + 315 + 43, 980, 0, 1024, 48);// T.rex 2 move
		while (hit) {

			for (int j = 1; j <= 4; j++) {
				shape[j].dx1 -= runspeed;
				shape[j].dx2 -= runspeed;

				if (shape[3].dx2 == 850) {
					shape[4] = new Ground(image, 0 + this.getWidth(), 0 + 458 + 43, 1180 * 6, (70 - 58) * 6 + 458 + 43,
							0, 58, 1180, 70);// Ground

				} else if (shape[4].dx2 == this.getWidth()) {
					shape[3] = new Ground(image, 0 + this.getWidth(), 0 + 458 + 43, 1180 * 6, (70 - 58) * 6 + 458 + 43,
							0, 58, 1180, 70);
				}

				if (shape[j].dx2 < 0) {// x>frame width
					System.gc();
					if (j == 3) {
						shape[3] = new Ground(image, 0 + this.getWidth(), 0 + 458 + 43, 1180 * 6,
								(70 - 58) * 6 + 458 + 43, 0, 58, 1180, 70);// Ground
					}
					if (j == 4) {
						shape[4] = new Ground(image, 0 + this.getWidth(), 0 + 458 + 43, 1180 * 6,
								(70 - 58) * 6 + 458 + 43, 0, 58, 1180, 70);// Ground
					}
					if (j == 1) {
						shape[1] = new Cactus(image, 0 + this.getWidth(), 0 + 347 + 43,
								(245 - 228) * 3 + this.getWidth(), 37 * 3 + 347 + 43, 228, 0, 245, 37);// Cactus
					}
					if (j == 2) {
						shape[2] = new Cloud(image, 0 + this.getWidth(), 0 + 100, (133 - 85) * 3 + this.getWidth(),
								17 * 3 + 100, 85, 0, 133, 17);// Cloud
					}

					if (runspeed < 35) {
						runspeed += 2;
						jumpspeed += 2.5;
					}
					if(downspeed <25){
						downspeed++;
					}
					

				}

			}
			
			Trexjump();// Trex_jump
			

			checkhit();// check obj1 obj2 hit or not hit
			try {
				Thread.sleep(30);// delay 3 second

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m+=1;
			repaint();

		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		try {
			
			shape[2].draw(g);
			shape[1].draw(g);
			if(f!=0){
				shape[0].draw(g);// Trex_jump
			}
			else{
				if(m%4==0){
					shape[5].draw(g);
				}
				else{
					
					shape[6].draw(g);
				}
				
			}
			
			
			shape[3].draw(g);
			shape[4].draw(g);
			
			if(hit==false){
				c[hiting].draw(g);
				c2[hiting2].draw(g);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

	}

	/*
	 * private void checkhit() { // TODO Auto-generated method stub
	 * if(obj1.x>obj2.x){//check obj1 is on the the right.
	 * if(obj1.x<obj2.x+obj2.w &&obj1.y<obj2.y+h){ hit=false; //time +=
	 * System.currentTimeMillis();
	 * //System.out.printf("%09d\n",time/1000);//play game how long } } else
	 * if(obj1.x<obj2.x){//check obj1 is on the the left.
	 * if(obj1.x+obj1.w>obj2.x &&obj1.y<obj2.y+h){ hit=false; //time +=
	 * System.currentTimeMillis();
	 * //System.out.printf("%09d\n",time/1000);//play game how long } } else{
	 * hit=true; }
	 * 
	 * }
	 */

	private void checkhit() {
		
		c = new Checkbox[5];// T.rex
		c2 = new Checkbox[3];// Cactus

		int dx1 = shape[0].dx1;
		int dy1 = shape[0].dy1;
		int dx = shape[1].dx1;
		int dy = shape[1].dy1;
		c[0] = new Checkbox(dx1 + 20 * 3, dy1 + 5, 20 * 3, 20 * 3);// head
		c[1] = new Checkbox(dx1 + 5 * 3, dy1 + 22 * 3, 25 * 3, 15 * 3);// body
		c[2] = new Checkbox(dx1 + 30 * 3, dy1 + 20 * 3, 6 * 3, 9 * 3);// hand
		c[3] = new Checkbox(dx1 + 10 * 3, dy1 + 38 * 3, 17 * 3, 9 * 3);// foot
		c[4] = new Checkbox(dx1, dy1 + 17 * 3, 5 * 3, 15 * 3);// tail

		c2[0] = new Checkbox(dx + 5 * 3, dy + 5, 7 * 3, 50 * 3);// body
		c2[1] = new Checkbox(dx, dy + 30, 5 * 3, 15 * 3);// L hand
		c2[2] = new Checkbox(dx + 12 * 3, dy + 20, 5 * 3, 15 * 3);// R hand

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (c[i].x > c2[j].x) {// check obj1 is on the the right.
					if (c[i].x < c2[j].x + c2[j].w && c[i].y + c[i].h > c2[j].y) {
						hit = false;
						hiting=i;
						hiting2=j;
						break;
						// time += System.currentTimeMillis();
						// System.out.printf("%09d\n",time/1000);//play game how
						// long
					}
				} else if (c[i].x < c2[j].x) {// check obj1 is on the the left.
					if (c[i].x + c[i].w > c2[j].x && c[i].y + c[i].h > c2[j].y) {
						hit = false;
						hiting=i;
						hiting2=j;
						break;
						// time += System.currentTimeMillis();
						// System.out.printf("%09d\n",time/1000);//play game how
						// long
					}
				} else {
					hit = true;
				}
			}
		}

	}

	private void Trexjump() {
		// TODO Auto-generated method stub

		if (f == 1) {// f==1 jump up
			shape[0].dy1 -= jumpspeed;
			shape[0].dy2 -= jumpspeed;
			if (shape[0].dy1 < dy1 - jumphight) {// dy2==t.rex height
				f = -1;// f==-1 down

			}
		} else if (f == -1) {// f==-1 down
			shape[0].dy1 += downspeed;
			shape[0].dy2 += downspeed;
			if (shape[0].dy2 > dy2) {// dy2==ground
				f = 0;// f==0 rest
			}
		} else if (f == 0) {// f==0 rest
			shape[0].dy1 = dy1;
			shape[0].dy2 = dy2;
		}

	}

	public void jump() {
		// TODO Auto-generated method stub
		if (shape[0].dy2 == dy2) {// obj2.y==ground
			f = 1;// f==1 jump up

		}
	}

}

// Reference: http://larry850806.github.io/2016/06/10/Java-Thread/
// Reference: http://blog.sina.com.cn/s/blog_5c5bc9070100ytxz.html
// Reference:http://davidhsu666.com/archives/gamecollisiondetection/
