package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;

public class WaterBlock extends Tile{

	public WaterBlock(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}

}
