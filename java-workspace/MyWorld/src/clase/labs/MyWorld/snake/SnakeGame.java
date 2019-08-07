package clase.labs.MyWorld.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import clase.labs.MyWorld.Game;
import clase.labs.MyWorld.Input;

public class SnakeGame {
	Player player;
	Point point;
	int count;
	boolean gameOver;
	
	public SnakeGame() {
		
	}
	
	public void init() {
		// Condiciones de Inicio
		gameOver = false;
		count = 0;
		player= new Player();
		point = new Point();
	}
	
	public void tick() {
		
		// Cuando pierda, puede reinciar dando presionando en space
		if (Input.get().isKeyPressed(KeyEvent.VK_SPACE) && gameOver) {
			init();
		}
		
		if (gameOver) return;
			
		player.tick();
		
		if (player.collides(point)) {
			point = new Point();
			count ++;
			player.grow();
		}
		
		if (player.isMordido(20)) {
			// Game Over
			gameOver = true;
		}
		
	}
	
	public void render(Graphics2D g) {
		player.render(g);
		point.render(g);
		
		g.setColor(Color.WHITE);
		g.drawString("Points: " + count, 20, 20);
		
		if (gameOver) {
			Font font = new Font("Helvetica", Font.BOLD, 48);
			g.setFont(font);
			g.setColor(Color.YELLOW);
			g.drawString("GAME OVER", Game.WIDTH/2-128, Game.HEIGHT/2);
		}
	}
}
