package clase.labs.MyWorld.platform;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x, y;
	
	protected Level level;
	
	protected boolean destroyed;
	
	public GameObject(float _x, float _y, Level _level) {
		x = _x;
		y = _y;
		level = _level;
		
		destroyed = false;
	}
	
	public void tick() {}
	public void render(Graphics2D g) {}

	public void onCollision(GameObject other) {}
	
	public abstract Rectangle getAABBBox();
	
	public boolean hasCollision(GameObject other) {
		return getAABBBox().intersects(other.getAABBBox());
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
}
