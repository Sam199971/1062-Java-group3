package mygame;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.TimeZone;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import mygame.Checkbox;

public class Play extends BasicGameState {

	Animation movingGround, movingGround2, movingTrex, jumpTrex, trex, movingCactus, movingCloud,movingCactus2;

	boolean quit = false;
	int[] duration2 = { 100, 100 };// Animation speed
	int[] duration = { 200, 200 };

	float fwidth = 800;// frame width
	float trexPositionX = 200;
	float trexPositionY = 320;
	float cactusPositionX = fwidth;
	float cactusPositionY = 355;
	float dx = fwidth + 100;
	float dy = 100;
	float gx = 0, gx2 = 3600;// ground PositionX
	float gy = 450;// ground PositionY
	int keyflag = 0;// key up 1 jump ,-1 down ,0 ground
	float score = 0;
	float bestRecord = 0;

	float runspeed = 0.7f;
	float jumpspeed = 0.5f;
	float downspeed = 0.02f;

	TrueTypeFont ttf;
	private Checkbox c[], c2[];// check hit box

	private boolean hit;

	private int hiting;

	private int hiting2;

	private boolean readHistory;



	public Play(int state) {

	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

		score = 0;
		readHistory=false;
		hit = false;
		fwidth = 800;// frame width
		trexPositionX = 200;
		trexPositionY = 320;
		cactusPositionX = fwidth + 1000;
		cactusPositionY = 355;
		dx = fwidth + 100;
		dy = 100;
		gx = 0;
		gx2 = 3600;
		gy = 450;// ground PositionY
		keyflag = 0;// key up 1 jump ,-1 down ,0 ground
		runspeed = 0.7f;
		jumpspeed = 0.5f;
		downspeed = 0.2f;

		Image[] ground = { new Image("res/8.png"), new Image("res/8.png") };
		Image[] ground2 = { new Image("res/8.png"), new Image("res/8.png") };

		Image[] trexMove = { new Image("res/2.png"), new Image("res/3.png") };
		Image[] trexJump = { new Image("res/1.png"), new Image("res/1.png") };
		Image[] cactus = { new Image("res/4.png"), new Image("res/4.png") };
		Image[] cactus2 = { new Image("res/5.png"), new Image("res/5.png") };
		Image[] cloud = { new Image("res/7.png"), new Image("res/7.png") };

		movingGround = new Animation(ground, duration, false);
		movingGround2 = new Animation(ground2, duration, false);
		movingCactus = new Animation(cactus, duration, false);
		movingCactus2 = new Animation(cactus2, duration, false);
		movingCloud = new Animation(cloud, duration, false);
		movingTrex = new Animation(trexMove, duration2, true);
		jumpTrex = new Animation(trexJump, duration, false);

		trex = movingTrex;

		Font font = new Font("Verdana", Font.BOLD, 30);
		ttf = new TrueTypeFont(font, true);
		
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

		if (score % 400 < 200) {
			g.setBackground(org.newdawn.slick.Color.lightGray);
		} else {
			g.setBackground(org.newdawn.slick.Color.black);
			for (int i = 0; i < 3; i++) {
				movingGround.draw(gx, gy);
				movingGround.draw(gx2, gy);
			}

		}

		movingGround.draw(gx, gy);
		movingGround.draw(gx2, gy);
		movingCloud.draw(dx, dy);
		movingCactus.draw(cactusPositionX, cactusPositionY);
		//movingCactus2.draw(cactusPositionX+100, cactusPositionY-40);
		trex.draw(trexPositionX, trexPositionY);

		if (hit) {
			c[hiting].draw(g);
			c2[hiting2].draw(g);
		}
		
		
		
	
		g.drawString("g X: " + gx + "\ng g X2: " + gx2 + "\ng t Y: " + trexPositionY + "\nspeed: " + runspeed, 400,
				100);

		if (bestRecord != 0) {
			ttf.drawString(fwidth - 450, 0, String.format(" %010.0f", bestRecord), org.newdawn.slick.Color.gray);
		}
		ttf.drawString(fwidth - 200, 0, String.format(" %010.0f", score), org.newdawn.slick.Color.gray);

		if (quit) {
			g.drawString("Resume(R)", 250, 100);
			g.drawString("Main Manu(M)", 250, 150);
			g.drawString("Quit & Save Game(Q)", 250, 200);
			g.drawString("Back Game(B)", 250, 250);
			g.drawString("History Game(H)", 250, 300);
		}
		if(readHistory){
			
		}
	}

	

	

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input input = container.getInput();
		if (hit) {
			movingTrex.setAutoUpdate(!hit);
			container.setPaused(hit);// game pause
			if (score > bestRecord) {
				bestRecord = score;
			}

		} else {
			groundUpadte(delta);
			TrexUpadate(delta);
			cactusUpadate(delta);
			otherUpdate(delta);
			checkhit();
			score += delta * 0.01f;

		}

		//// keyBoard
		if (input.isKeyDown(Input.KEY_UP)) {
			if (trexPositionY == gy - 130 || trexPositionY > gy - 130) {
				keyflag = 1;
			}
			if (hit) {
				game.getState(1).init(container, game);
				container.resume();// game resume
			}

		}

		if (input.isKeyDown(Input.KEY_DOWN)) {

		}

		if (input.isKeyDown(Input.KEY_RIGHT)) {
			hit = false;
			movingTrex.setAutoUpdate(true);
			container.setPaused(hit);// game pause
		}

		if (input.isKeyDown(Input.KEY_LEFT)) {

		}

		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
			movingTrex.setAutoUpdate(!quit);
			container.setPaused(quit);// game pause
		}

		if (quit) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
				game.getState(1).init(container, game);
				container.resume();

			}

			if (input.isKeyDown(Input.KEY_M)) {
				hit = false;
				quit = false;
				game.getState(1).init(container, game);
				container.resume();
				game.enterState(0);

			}
			if (input.isKeyDown(Input.KEY_Q)) {
				inserSql();
				System.exit(0);
				
			}
			if (input.isKeyDown(Input.KEY_B)) {
				quit = false;
				movingTrex.setAutoUpdate(!quit);
				container.setPaused(quit);// game pause
			}
			if (input.isKeyDown(Input.KEY_H)) {
				
				readHistory=true;
				readSql();
			}
		}
	}

	private void readSql() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/mydb?" + "user=root&password=0000&serverTimezone=UTC&useSSL=false");
			Statement stmt = conn.createStatement();
			
			
			
			ResultSet rs = stmt.executeQuery("select s.user_id, user_name, user_score"
					+ " from user_table s");


			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) );
			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	private void inserSql() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/mydb?" + "user=root&password=0000&serverTimezone=UTC&useSSL=false");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select s.user_id, user_name, user_score"
					+ " from user_table s");
			int i=1;
			while (rs.next()) {
				i++;
			}
			SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			String sdate = nowdate.format(new java.util.Date());
			
			
			//System.out.println(strDate);
			PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO user_table (user_id, user_name,user_score) VALUES (?,?,?);");
			stmt2.setInt(1, i);
			stmt2.setString(2, sdate);
			stmt2.setInt(3, (int)score);
			stmt2.executeUpdate();
			ResultSet rs2 = stmt.executeQuery("select s.user_id, user_name, user_score"
					+ " from user_table s");
			while (rs2.next()) {
				
				System.out.println(
						rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" + rs2.getInt(3) );
			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	private void otherUpdate(int delta) {
		// TODO Auto-generated method stub
		Random rand = new Random();

		if (dx < -100) {
			dx = fwidth + rand.nextInt(200);

		} else {
			dx -= delta * runspeed;
		}
	}

	private void cactusUpadate(int delta) {
		// TODO Auto-generated method stub
		if (cactusPositionX < -100) {
			cactusPositionX = fwidth;
			if ((int) score % 100 < 25 && runspeed < 0.9) {
				runspeed += 0.05f;
				
			}
		} else {
			cactusPositionX -= delta * runspeed;
		}

	}

	private void groundUpadte(int delta) {
		//// ground moving
		if (gx > -3600) {
			gx -= delta * runspeed;
		} else if (gx == -3600 || gx < -3600) {
			gx = gx2 + 3600;
		}
		if (gx2 > -3600) {
			gx2 -= delta * runspeed;
		} else if (gx2 == -3600 || gx2 < -3600) {
			gx2 = gx + 3600;
		}

	}

	private void TrexUpadate(int delta) {
		//// T.rex jump
		if (keyflag == 1) {
			trex = jumpTrex;
			trexPositionY -= delta *delta * jumpspeed*2;
			if (trexPositionY < 20) {
				keyflag = -1;
			}
		} else if (keyflag == -1) {
			trexPositionY += delta * delta *downspeed*2;
			if (trexPositionY > gy - 130) {
				trex = movingTrex;
				keyflag = 0;
			}
		}

	}

	private void checkhit() {

		c = new Checkbox[5];// T.rex
		c2 = new Checkbox[3];// Cactus
		
		float dx1 = trexPositionX;
		float dy1 = trexPositionY;
		float dx = cactusPositionX;
		float dy = cactusPositionY;
		c[0] = new Checkbox(dx1 + 20 * 3, dy1, 20 * 3, 20 * 3);// head
		c[1] = new Checkbox(dx1 + 5 * 3, dy1 + 22 * 3, 25 * 3, 15 * 3);// body
		c[2] = new Checkbox(dx1 + 30 * 3, dy1 + 20 * 3, 6 * 3, 6 * 3);// hand
		c[3] = new Checkbox(dx1 + 10 * 3, dy1 + 38 * 3, 17 * 3, 9 * 3);// foot
		c[4] = new Checkbox(dx1, dy1 + 15 * 3, 5 * 3, 15 * 3);// tail

		c2[0] = new Checkbox(dx + 5 * 3, dy, 7 * 3, 35 * 3);// body
		c2[1] = new Checkbox(dx, dy + 25, 5 * 3, 15 * 3);// L hand
		c2[2] = new Checkbox(dx + 12 * 3, dy + 15, 5 * 3, 15 * 3);// R hand
		
		

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (c[i].x > c2[j].x) {// check obj1 is on the the right.
					if (c[i].x < c2[j].x + c2[j].w && c[i].y + c[i].h > c2[j].y) {
						hit = true;
						hiting = i;
						hiting2 = j;
						break;
						// time += System.currentTimeMillis();
						// System.out.printf("%09d\n",time/1000);//play game how
						// long
					}
				} else if (c[i].x < c2[j].x) {// check obj1 is on the the left.
					if (c[i].x + c[i].w > c2[j].x && c[i].y + c[i].h > c2[j].y) {
						hit = true;
						hiting = i;
						hiting2 = j;
						break;
						// time += System.currentTimeMillis();
						// System.out.printf("%09d\n",time/1000);//play game how
						// long
					}
				} else {
					hit = false;
				}
			}
		}

	}

	@Override
	public int getID() {

		return 1;
	}

}
