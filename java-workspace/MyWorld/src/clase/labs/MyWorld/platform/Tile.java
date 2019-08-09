package clase.labs.MyWorld.platform;

import java.awt.Graphics2D;

public abstract class Tile {

	protected int x, y;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isSolid(int vx, int vy) {
		return false;
	}
	
	public void render(Graphics2D g) {
		
	}
}
