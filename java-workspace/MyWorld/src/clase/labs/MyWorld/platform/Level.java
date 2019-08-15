package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import clase.labs.MyWorld.Game;

public class Level {

	private String mapStr;
	private Tile map[][];
	private int gridW, gridH;
	private int tileSize;
	
	private Player player;
	private Door door;
	
	private List<GameObject> objects;
	
	PlatformGame game;
	
	public Level(PlatformGame _game) {
		game = _game;
		
		// Definir cantidad de tiles y su tamanio
		tileSize = 32;
		gridW = Game.WIDTH/tileSize;
		gridH = Game.HEIGHT/tileSize;
		
		map = new Tile[gridH][gridW];
		
		objects = new ArrayList<>();
		
		loadMap();
		createLevel();
	}
	
	private void loadMap() {
		mapStr = "";
		mapStr += "*             *     ";
		mapStr += "*            *      ";
		mapStr += "*           *       ";
		mapStr += "*          *        ";
		mapStr += "*         *         ";
		mapStr += "*       d*          ";
		mapStr += "*       *          *";
		mapStr += "* +                *";
		mapStr += "* *..         * *  *";
		mapStr += "*        e  ***.*  *";
		mapStr += "**  ****...**** ****";
		mapStr += "  *               k*";
		mapStr += "   *************---*";
		mapStr += "               *****";
		mapStr += "                    ";
	}
	
	
	private void createLevel() {
		for (int i = 0; i < mapStr.length(); i++) {
			int x = i % gridW;
			int y = i / gridW;
			
			char id = mapStr.charAt(i);
			
			// Place Tile
			Tile tile;
			switch (id) {
			case '*':
				tile = new SolidBlock(x*32, y*32);
				break;
			case '-':
				tile = new WaterBlock(x*32, y*32);
				break;
			case '.':
				tile = new SemiSolidBlock(x*32, y*32);
				break;
			default:
				tile = new AirBlock(x*32, y*32);
			}
			
			map[y][x] = tile;
			
			// Place GameObject
			switch (id) {
			case 'k':
				objects.add(new Key(x*32, y*32, this));
				break;
			case '+':
				player = new Player(x*32, y*32, this);
				objects.add(player);
				break;
			case 'd':
				door = new Door(x*32,y*32,this);
				objects.add(door);
				break;
			case 'e':
				objects.add(new Enemy(x*32, y*32, this));
				break;
			}
		}
		
	}
	
	public void renderMap(Graphics2D g) {
		for (int i=0; i < gridH; i++) {
			for (int j=0; j < gridW; j++) {
				g.setColor(Color.BLACK);
				g.drawRect(j*32, i*32, 32, 32);
				if (map[i][j] != null)
					map[i][j].render(g);
			}
		}
	}
	
	public void render(Graphics2D g) {
		renderMap(g);
		
		for (GameObject obj : objects)
			obj.render(g);
	}
	
	public void tick() {
		
		
		
		// Update Objects
		for (GameObject obj : objects)
			obj.tick();
		
		// Handle Collisions
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i+1; j < objects.size(); j++) {
				GameObject objA = objects.get(i),
						   objB = objects.get(j);
				if (objA.hasCollision(objB)) {
					objA.onCollision(objB);
					objB.onCollision(objA);
				}
			}
		}
		
		// Remove Destroyed Objects
		Iterator<GameObject> itr = objects.iterator();
		while (itr.hasNext()) {
			GameObject obj = itr.next();
			if (obj.isDestroyed())
				itr.remove();
		}
		
	}
	
	public Tile getTile(int j, int i) {
		if (i < 0 || i >= gridH || j < 0 || j >= gridW) return new SolidBlock(0,0);
		return map[i][j];
	}
	
	public void setTile(int j, int i) {
		if (i < 0 || i >= gridH || j < 0 || j >= gridW) {
			System.out.println("Error at setTile(): i,j index out of bounds!");
			return;
		}
		
		
	}
	
	
	public void openLevelDoor() {
		door.setOpen(true);
	}
	
	public void gameOver() {
		game.gameOver();
	}
	
}
