package joonas.roguelike.game;

import joonas.roguelike.game.entities.Armor;
import joonas.roguelike.game.entities.Consumable;
import joonas.roguelike.game.entities.Player;

public class LevelGenerator {
	private static final int SIMPLE_LEVEL_HEIGHT = 30;
	private static final int SIMPLE_LEVEL_WIDTH = 30;
	
	public static Level generateSimpleLevel(World world) {
		Level level = new Level(world, SIMPLE_LEVEL_WIDTH, SIMPLE_LEVEL_HEIGHT);
		
		
		for (int x = 0; x < level.getWidth(); x++) {
			for (int y = 0; y < level.getWidth(); y++) {
				Tile tile;
				if (y == 0 || y == level.getHeight() - 1) {
					tile = Tile.walledTile(x, y);
				} else if (x == 0 || x == level.getWidth() - 1) {
					tile = Tile.walledTile(x, y);
				} else {
					tile = Tile.floorTile(x, y);
				}
				
				level.addTile(tile);
			}
		}
		
		Player player = new Player();
		player.getInventory().addItem(new Consumable());
		level.addEntity(player, 1, 1);
		level.addEntity(new Armor(), 5, 5);
		level.addEntity(new Armor(), 5, 8);
		
		return level;
	}
}
