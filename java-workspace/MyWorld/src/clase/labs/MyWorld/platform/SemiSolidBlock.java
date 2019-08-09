package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;

public class SemiSolidBlock extends Tile {

private int w, h;
	
	public SemiSolidBlock(int x, int y) {
		super(x, y);
		w = 32;
		h = 32;
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, w, h);
	}
	
	@Override
	public boolean isSolid(int vx, int vy) {
		return vy > 0;
	}
	
}
