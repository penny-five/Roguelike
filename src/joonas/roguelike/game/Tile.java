package joonas.roguelike.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Property;
import joonas.roguelike.game.entities.Wall;

public class Tile {
	private Appearance appearance;
	private List<Entity> entities = new ArrayList<Entity>();
	private Level level;
	private int x = -1;
	private int y = -1;
	
	private Tile() {
		appearance = new Appearance(' ', Color.WHITE);
	}
	
	public Appearance getAppearance() {
		return appearance;
	}
	
	/**
	 * 
	 * @return {@link Appearance} that should be used when drawing. This can be effected by entities contained by this {@link Tile}
	 */
	public Appearance getPaintedAppearance() {
		if (!entities.isEmpty()) {
			for (Entity entity: entities) {
				if (entity.is(Property.VISIBLE)) {
					return entity.getAppearance();
				}
			}
		}
		
		return appearance;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
		entity.setLocation(this);
	}
	
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
	public boolean monstersCanMoveHere() {
		for (Entity entity : entities) {
			if (entity.is(Property.UNPASSABLE)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static Tile walledTile() {
		Tile tile = new Tile();
		tile.entities.add(new Wall());
		return tile;
	}
	
	public static Tile emptyTile() {
		return new Tile();
	}
	
	public static Tile floorTile() {
		Tile tile = new Tile();
		tile.appearance = new Appearance('.', Color.WHITE);
		return tile;
	}
}
