package joonas.roguelike.game;

public class LevelGenerator {
	private static final int SIMPLE_LEVEL_HEIGHT = 30;
	private static final int SIMPLE_LEVEL_WIDTH = 30;
	
	public static Level generateSimpleLevel() {
		Level level = new Level(SIMPLE_LEVEL_WIDTH, SIMPLE_LEVEL_HEIGHT);
		
		
		for (int x = 0; x < level.getWidth(); x++) {
			for (int y = 0; y < level.getWidth(); y++) {
				Tile tile;
				if (y == 0 || y == level.getHeight() - 1) {
					tile = Tile.walledTile();
				} else if (x == 0 || x == level.getWidth() - 1) {
					tile = Tile.walledTile();
				} else {
					tile = Tile.floorTile();
				}
				
				level.setTile(tile, x, y);
			}
		}
		
		return level;
	}
}
