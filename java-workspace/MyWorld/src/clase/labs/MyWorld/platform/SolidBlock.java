package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;

import clase.labs.MyWorld.CachedSprite;

public class SolidBlock extends Tile {

	private int w, h;
	
	private CachedSprite blockSprite;
	
	public SolidBlock(int x, int y, CachedSprite sprite) {
		super(x, y);
		w = 32;
		h = 32;
		
		blockSprite = sprite;
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, w, h);
	
		
		g.drawImage(blockSprite.get(0), x, y, 32, 32, null);
	}
	
	@Override
	public boolean isSolid(int vx, int vy) {
		return true; 
	}
}
