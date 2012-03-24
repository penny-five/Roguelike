package joonas.roguelike.game;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Player;

public class Level {
	private final int height;
	private final int width;
	private final World world;
	
	private Tile[][] tiles;
	private Player player;
	
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
	
	public Player getPlayer() {
		return player;
	}
	
	public void addPlayer(Player player, int x, int y) {
		this.player = player;
		
		tiles[x][y].addEntity(player);
	}
	
	public void setTile(Tile tile, int x, int y) {
		tiles[y][x] = tile;
		tile.setPosition(x, y);
		tile.setLevel(this);
	}
	
	public void moveEntityBy(Entity entity, Tile from, int xMovement, int yMovement) {
		int targetX = from.getX() + xMovement;
		int targetY = from.getY() + yMovement;
		Tile target = tiles[targetY][targetX];
		if (target.monstersCanMoveHere()) {
			from.removeEntity(entity);
			target.addEntity(entity);
			Log.debug("moved to x " + targetX + " y  " + targetY);
		}
		world.requestUpdate();
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
