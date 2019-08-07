package clase.labs.MyWorld.snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import clase.labs.MyWorld.Game;

public class Point {

	int x, y;
	Rectangle box;
	
	public Point() {
		Random r = new Random();
		x = r.nextInt(Game.WIDTH - 40) + 20;
		y = r.nextInt(Game.HEIGHT - 40) + 20;
		
		box = new Rectangle(x,y,20,20);
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, 20, 20);
	}
	
	public void tick() {
		
	}
	
	public Rectangle getBox() {
		return box;
	}
}
