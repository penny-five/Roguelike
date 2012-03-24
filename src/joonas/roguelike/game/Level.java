package joonas.roguelike.game;

public class Level {
	private static final int HEIGHT = 20;
	private static final int WIDTH = 20;
	
	private Tile[][] mapTiles;
	public Level() {
		mapTiles = new Tile[HEIGHT][WIDTH];
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				mapTiles[y][x] = new Tile();
			}
		}
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public Tile getTile(int x, int y) {
		assert(x >= 0 && x <= WIDTH);
		assert(y >= 0 && y <= HEIGHT);
		
		return mapTiles[x][y];
	}
}
