package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;

import clase.labs.MyWorld.Game;

public class PlatformGame {
	
	Level level;
	
	public PlatformGame() {
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		level = new Level();
		
	}

	public void tick() {
		level.tick();
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		level.render(g);
	}
	
}
