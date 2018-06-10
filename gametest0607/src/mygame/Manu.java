package mygame;

import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.text.EditorKit;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Manu extends BasicGameState {

	Image playNow;
	Image exitGame;
	JTextField txt;
	public MP3 mp3;
	public Manu(int state) {
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
		txt = new JTextField();
		txt.setColumns(10);
		
		
	
		
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
		Input input = container.getInput();
		int posX = Mouse.getX();
		int posY = Mouse.getY();

		if ((posX > 100 && posX < 311) && (posY > 209+250 && posY < 260+250)) {
			if (Mouse.isButtonDown(0)) {
				
				musicPlay();
				game.enterState(1);
				
			}
		}
		
		if ((posX > 100 && posX < 311) && (posY > 109+250 && posY < 160+250)) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}

	private void musicPlay() {
		// TODO Auto-generated method stub
		String filename = "resources/audio/1.mp3";
		mp3 = new MP3(filename);
        mp3.setLoop(false);
        mp3.play();
		
	}

	@Override
	public int getID() {

		return 0;
	}

}
