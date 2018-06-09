package mygame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Manu extends BasicGameState {

	Image playNow;
	Image exitGame;

	public Manu(int state) {

	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Welcome to Bucky Land!", 100, 50);
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
				
				game.enterState(1);
				
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
