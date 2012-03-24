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
