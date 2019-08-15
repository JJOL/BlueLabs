package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import clase.labs.MyWorld.Game;

public class PlatformGame {
	
	Level level;
	boolean gameOver;

	public PlatformGame() {
		// TODO Auto-generated constructor stub
		gameOver = false;
	}
	
	public void init() {
		level = new Level(this);
		
	}

	public void tick() {
		if (!gameOver)
		level.tick();
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		level.render(g);
		
		
		if (gameOver) {
			Font font = new Font("Helvetica", Font.BOLD, 48);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("GAME OVER", Game.WIDTH/2-128, Game.HEIGHT/2);
		}
	}
	
	public void gameOver() {
		gameOver = true;
	}
	
}
