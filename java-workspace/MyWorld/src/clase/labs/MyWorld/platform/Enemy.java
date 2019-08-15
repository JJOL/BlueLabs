package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy extends GameObject {

	
	int dis = 64;
	int dir = 1;
	
	int xstart;
	
	public Enemy(float _x, float _y, Level _level) {
		super(_x, _y, _level);
		// TODO Auto-generated constructor stub
		
		xstart = (int)x;
	}

	@Override
	public Rectangle getAABBBox() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, 32,32);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		super.tick();
		x += 3*dir;
		
		if (Math.abs(x - xstart) > dis) {
			dir *= -1;
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE);
		g.fillOval((int)x, (int)y, 32, 32);
		super.render(g);
	}
	
	@Override
	public void onCollision(GameObject other) {
		// TODO Auto-generated method stub
		super.onCollision(other);
	}

	
}
