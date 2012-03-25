package joonas.roguelike.game;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Monster;
import joonas.roguelike.game.entities.Player;
import joonas.roguelike.game.entities.Property;

public class Level {
	private final int height;
	private final int width;
	private final World world;
	
	private Tile[][] tiles;
	private Monster player;
	
	public Level(World world, int width, int height) {
		this.world = world;
		this.width = width;
		this.height = height;
		
		fillWithEmptyTiles();
	}
	
	public Level(World world) {
		this.world = world;
		this.height = 20;
		this.width = 20;
		
		fillWithEmptyTiles();
	}
	
	private void fillWithEmptyTiles() {
		tiles = new Tile[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[y][x] = Tile.emptyTile(x, y);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Monster getPlayer() {
		return player;
	}
	
	public void addPlayer(Player player, int x, int y) {
		this.player = player;
		
		tiles[x][y].addEntity(player);
	}
	
	public void addEntity(Entity entity, int x, int y) {
		if (entity.getBoolean(Property.PLAYER_CONTROLLED)) {
			player = (Monster) entity;
		}
		tiles[x][y].addEntity(entity);
	}
	
	public void addTile(Tile tile) {
		tiles[tile.getY()][tile.getX()] = tile;
		tile.setLevel(this);
	}
	
	public boolean moveEntityBy(Entity entity, Tile from, int xMovement, int yMovement) {
		int targetX = from.getX() + xMovement;
		int targetY = from.getY() + yMovement;
		Tile target = tiles[targetY][targetX];
		if (target.monstersCanMoveHere()) {
			from.removeEntity(entity);
			target.addEntity(entity);
			return true;
		}

		return false;
	}
	
	public Tile getTile(int x, int y) {
		assert(x >= 0 && x <= width);
		assert(y >= 0 && y <= height);
		
		return tiles[y][x];
	}
	
	public boolean canMoveTo(int x, int y) {
		return tiles[x][y].monstersCanMoveHere();
	}
}
