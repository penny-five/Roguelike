package joonas.roguelike.game;

public class Level {
	private final int height;
	private final int width;
	
	private Tile[][] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		
		fillWithEmptyTiles();
	}
	
	public Level() {
		this.height = 20;
		this.width = 20;
		
		fillWithEmptyTiles();
	}
	
	private void fillWithEmptyTiles() {
		tiles = new Tile[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[y][x] = Tile.emptyTile();
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setTile(Tile tile, int x, int y) {
		tiles[y][x] = tile;
	}
	
	public Tile getTile(int x, int y) {
		assert(x >= 0 && x <= width);
		assert(y >= 0 && y <= height);
		
		return tiles[y][x];
	}
}
