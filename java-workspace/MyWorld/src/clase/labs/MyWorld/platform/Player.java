package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import clase.labs.MyWorld.Input;

public class Player {
	
	private Level level; 

	private int w, h;
	
	private float x, y;
	private float vx, vy;
	private float grav;
	
	private boolean canJump;
	
	
	public Player(int x, int y, Level level) {
		w = 32;
		h = 32;
	    this.x = x;
	    this.y = y;
	    vx = 0;
	    vy = 0;
	    grav = 0.2f;
	    canJump = true;
	    
	    this.level = level;
	}
	
	public void tick() {
		
		if (Input.get().isKeyPressed(KeyEvent.VK_SPACE) && canJump) {
			System.out.println("Jump!");
			canJump = false;
			vy = -6;
		}
		
		vx = 0;
		if (Input.get().isKeyPressed(KeyEvent.VK_A)) {
			vx -= 5;
		}
		
		if (Input.get().isKeyPressed(KeyEvent.VK_D)) {
			vx += 5;
		}
		
		move((int)vx, (int)vy);

		int tx = (int)((x) / 32);
		int ty = (int)((y+16+5) / 32);
		if (level.getTile(tx, ty).isSolid(0, 5)) {
			canJump = true;
		}
		
		vy += grav;
		if (vy > 7) vy = 7;
	}
	
	public void move(int vx, int vy) {
		
		int ox = w/2;
		int oy = h/2;
		
		int xsign = (vx < 0) ? -1 : 1;
		int ysign = (vy < 0) ? -1 : 1;
		
		int padd = 3;
		
		if (vx != 0) {
			int newx = (int)((x+vx) + (ox*xsign));
			if (!level.getTile(newx/32, (int)((y-oy+padd)/32)).isSolid(vx, 0) &&
				!level.getTile(newx/32, (int)((y+oy-padd)/32)).isSolid(vx, 0))
				x += vx;
			else {
				// Move Until Hit
				//System.out.println("0^0:" + (int)Math.pow(0, -3));
				//int boff = (int)Math.pow(0, xsign+1);
				//x = ((newx/32)+boff)*32+ox*xsign*-1;
				x = (xsign ==  -1) ?  ((newx/32)+1)*32+ox: 
								   	  ((newx/32)+0)*32-ox;
				
			}
		}
		
		if (vy != 0) {
			int newy = (int)((y+vy) + (oy*ysign));
			if (!level.getTile((int)((x-ox+padd)/32), newy/32).isSolid(0, vy) &&
				!level.getTile((int)((x+ox-padd)/32), newy/32).isSolid(0, vy))
				y += vy;
			else {
				// Move Until Hit
				y = ysign ==  -1 ?  ((newy/32)+1)*32+oy: 
									((newy/32)+0)*32-oy;
			}
				
		}
		/*
		if (vx != 0 && vy != 0) {
			move(vx, 0);
			move(0, vy);
			return;
		}
		
		int ox = 0, oy = 0;
		if (vx > 0)      ox = 16;
		else if (vx < 0) ox = -16;
		else if (vy > 0) oy = 16;
		else if (vy < 0) oy = -16;
		
		int tx = (int)((x+ox+vx) / 32);
		int ty = (int)((y+oy+vy) / 32);
		Tile block = level.getTile(tx, ty); 
		if (block == null || !block.isSolid()) {
			x += vx;
			y += vy;
		} else {
			if (vx > 0)      x = tx*32-16;
			else if (vx < 0) x = tx*32+32+16;
			else if (vy > 0) y = ty*32-16;
			else if (vy > 0) y = ty*32+32+16;
			
		}
		*/
	}
	
	
	
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect((int)x-16, (int)y-16, w, h);
	}
}
