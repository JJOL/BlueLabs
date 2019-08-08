package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;

public class SolidBlock extends Tile {

	private int w, h;
	
	public SolidBlock(int x, int y) {
		super(x, y);
		w = 32;
		h = 32;
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, w, h);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
