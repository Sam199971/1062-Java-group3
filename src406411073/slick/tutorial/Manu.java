package slick.tutorial;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Manu extends BasicGameState {

	Image playNow;
	Image exitGame;
	Image background;
	TrueTypeFont ttf;
	public Manu(int state) {

	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
		background = new Image("res/T-rex.jpg");
		Font font = new Font("Verdana", Font.BOLD, 30);
		ttf = new TrueTypeFont(font, true);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		background.draw(0,0,850,600);
		
		
		ttf.drawString(100, 50, "Welcome to T-rex", org.newdawn.slick.Color.black);
		playNow.draw(100, 100);
		exitGame.draw(100, 200);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();

		if ((posX > 100 && posX < 311) && (posY > 209+250 && posY < 260+250)) {
			if (Mouse.isButtonDown(0)) {
				
				game.enterState(0);
				
			}
		}
		
		if ((posX > 100 && posX < 311) && (posY > 109+250 && posY < 160+250)) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}

	@Override
	public int getID() {

		return 0;
	}

}
