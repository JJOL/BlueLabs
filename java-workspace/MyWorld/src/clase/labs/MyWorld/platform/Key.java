package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Key extends GameObject {

	public Key(int x, int y, Level level) {
		super(x,y,level);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.CYAN);
		
		int xpoints[] = { (int)x, (int)x+16, (int)x+32, (int)x+16 };
		int ypoints[] = { (int)y+16, (int)y+32, (int)y+16, (int)y };
		Polygon p = new Polygon(xpoints, ypoints, 4);
		g.fillPolygon(p);
		//g.fillRect((int)x, (int)y, 32, 32);
	}
	
	@Override
	public Rectangle getAABBBox() {
		
		return new Rectangle((int)x, (int)y, 32 ,32);
	}
	
	@Override
	public void onCollision(GameObject other) {
		if (other instanceof Player) {
			level.openLevelDoor();
			destroyed = true;
		}
	}

}
