package clase.labs.MyWorld.snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import clase.labs.MyWorld.Game;
import clase.labs.MyWorld.Input;

public class Player {

	
	private class Vec2 {
		public int x, y;
		public Vec2(int _x, int _y) { x = _x; y = _y; }
	}
	
	private ArrayList<Vec2 >pos;
	private int x, y;
	
	private int size = 1;
	
	private Rectangle box;
	
	
	public Player() {
		Random r = new Random();
		pos = new ArrayList<>();
		x = r.nextInt(Game.WIDTH - 40) + 20;
		y = r.nextInt(Game.HEIGHT - 40) + 20;
		pos.add(new Vec2(x, y));
		
		box = new Rectangle(x, y, 32,32);
	}
	
	public void tick() {
		
		
		
		
		
		Input input = Input.get();
		if (input.isKeyPressed(KeyEvent.VK_A))
			x -= 5;
		if (input.isKeyPressed(KeyEvent.VK_D))
			x += 5;
		if (input.isKeyPressed(KeyEvent.VK_W))
			y -= 5;
		if (input.isKeyPressed(KeyEvent.VK_S))
			y += 5;
		
		box.x = x;
		box.y = y;
		
		pos.add(new Vec2(x, y));
		if (pos.size() > size) pos.remove(0);
		
		
		if (input.isKeyPressed(KeyEvent.VK_SPACE)) {
			size += 1;
			System.out.println("Size is: " + size);
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(0,255,0,255));
		g.fillRect(x, y, 32, 32);
		
		for (int i=0; i < pos.size(); i += 2) {
			Vec2 v = pos.get(i);
			int alpha = (int)(i*(255.0 / pos.size()));
			g.setColor(new Color(0,255,0, alpha));
			g.fillRect(v.x, v.y, 32, 32);
		}
	}
	
	public boolean collides(Point p) {
		return box.intersects(p.getBox());
	}
	
	public void grow() {
		size++;
	}
	
	public boolean isMordido(int offset) {
		// Checar si se mordio cola
		
		for (int i = 0; i < pos.size()-offset; i++) {
			Vec2 v = pos.get(i);
			if (box.intersects(new Rectangle(v.x, v.y, 32, 32)) && size > offset) {
				return true;
			}
		}
		
		return false;
	}
}
