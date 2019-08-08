package clase.labs.MyWorld.platform;

import java.awt.Color;
import java.awt.Graphics2D;

import clase.labs.MyWorld.Game;

public class Level {

	private String mapStr;
	private Tile map[][];
	private int gridW, gridH;
	private int tileSize;
	
	private Player player;
	
	public Level() {
		// Definir cantidad de tiles y su tamanio
		tileSize = 32;
		gridW = Game.WIDTH/tileSize;
		gridH = Game.HEIGHT/tileSize;
		
		map = new Tile[gridH][gridW];
		mapStr = "";
		
		createLevel();
	}
	
	private void createLevel() {
		mapStr += "*             *     ";
		mapStr += "*            *      ";
		mapStr += "*           *       ";
		mapStr += "*          *        ";
		mapStr += "*         *         ";
		mapStr += "*        *          ";
		mapStr += "*       *          *";
		mapStr += "* +                *";
		mapStr += "* ***         * *  *";
		mapStr += "*           *** *  *";
		mapStr += "**  *********** ****";
		mapStr += "  *                *";
		mapStr += "   *************---*";
		mapStr += "               *****";
		mapStr += "                    ";
		
		for (int i = 0; i < mapStr.length(); i++) {
			int x = i % gridW;
			int y = i / gridW;
			if (mapStr.charAt(i) == '*')
				map[y][x] = new SolidBlock(x*32, y*32);
			else if (mapStr.charAt(i) == '-')
				map[y][x] = new WaterBlock(x*32, y*32);
			else
				map[y][x] = new AirBlock(x*32, y*32);
			
			if (mapStr.charAt(i) == '+')
				player = new Player(x*32, y*32, this);
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
		player.render(g);
	}
	
	public void tick() {
		player.tick();
	}
	
	public Tile getTile(int j, int i) {
		if (i < 0 || i >= gridH || j < 0 || j >= gridW) return new SolidBlock(0,0);
		return map[i][j];
	}
	
	
}
