package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Door extends GameObject {

	private boolean open;
	
	public Door(float _x, float _y, Level _level) {
		super(_x, _y, _level);
		open = false;
	}

	@Override
	public Rectangle getAABBBox() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	@Override
	public void render(Graphics2D g) {
		if (!isOpen())
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.ORANGE);
		
		
		g.fillRect((int)x, (int)y, 32, 32);
		g.fillArc((int)x, (int)y-16, 32, 32, 0, 180);
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public boolean isOpen() {
		return open;
	}

}
