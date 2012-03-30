package joonas.roguelike.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Property;
import joonas.roguelike.game.entities.Wall;

public class Tile {
	public interface TileObserver {
		public void onTileContentsChanged();
	}
	
	private List<TileObserver> observers = new ArrayList<Tile.TileObserver>();
	private Appearance appearance;
	private List<Entity> entities = new ArrayList<Entity>();
	private Level level;
	private final int x;
	private final int y;
	
	private Tile(int x, int y) {
		this.x = x;
		this.y = y;
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
			return entities.get(0).getAppearance();
		}
		
		return appearance;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public Entity getEntityAt(int index) {
		return entities.get(index);
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void addObserver(TileObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(TileObserver observer) {
		observers.remove(observer);
	}
	
	private void notifyContentsChanged() {
		for (TileObserver observer : observers) {
			observer.onTileContentsChanged();
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
		entity.setLocation(this);
		Collections.sort(entities, new Comparator<Entity>() {

			@Override
			public int compare(Entity e1, Entity e2) {
				return e2.getBoolean(Property.MONSTER)? 1 : -1;
			}
		});
		
		notifyContentsChanged();
	}
	
	public List<Entity> getEntitiesWithProperty(Property property, Object value) {
		List<Entity> e = new ArrayList<Entity>();
		for (Entity entity : entities) {
			if (entity.get(property).equals(value)) {
				e.add(entity);
			}
		}
		
		return e;
	}
	
	public void removeEntity(Entity entity) {
		entities.remove(entity);
		notifyContentsChanged();
	}
	
	public boolean monstersCanMoveHere() {
		for (Entity entity : entities) {
			if (entity.getBoolean(Property.UNPASSABLE)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static Tile walledTile(int x, int y) {
		Tile tile = new Tile(x, y);
		tile.entities.add(new Wall());
		return tile;
	}
	
	public static Tile emptyTile(int x, int y) {
		return new Tile(x, y);
	}
	
	public static Tile floorTile(int x, int y) {
		Tile tile = new Tile(x, y);
		tile.appearance = new Appearance('.', Color.WHITE);
		return tile;
	}
}
