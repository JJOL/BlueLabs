package clase.labs.MyWorld.platform;

public class Vec2 {

	public float x, y;
	
	public Vec2() {
		x = 0f;
		y = 0f;
	}
	
	public Vec2(float a) {
		x = a;
		y = a;
	}
	
	public Vec2(float _x, float _y) {
		x = _x;
		y = _y;
	}
	
	public int iX() {
		return (int)x;
	}
	
	public int iY() {
		return (int)y;
	}
	
	public Vec2 add(Vec2 other) {
		return new Vec2(x + other.x, y + other.y);
	}
	
	public float getMag() {
		return (float)Math.sqrt(x*x + y*y);
	}
	
	public Vec2 setMag(float mag) {
		return normalized().scaled(mag);
	}
	
	public Vec2 normalized() {
		float mag = getMag();
		return new Vec2(x / mag, y / mag);
	}
	
	public Vec2 scaled(float a) {
		return new Vec2(x * a, y * a);
	}
	
}
