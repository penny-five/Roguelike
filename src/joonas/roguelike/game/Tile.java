package joonas.roguelike.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Monster;

public class Tile {
	private Appearance appearance;
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Tile() {
		appearance = new Appearance('.', Color.WHITE);
		entities.add(new Monster());
	}
	
	public Appearance getAppearance() {
		return appearance;
	}
	
	/**
	 * 
	 * @return {@link Appearance} that should be used when drawing. This can be effected by entities contained by this {@link Tile}
	 */
	public Appearance getPaintedAppearance() {
		Log.debug("entities size " + entities.size());
		if (!entities.isEmpty()) {
			for (Entity entity: entities) {
				if (entity.isVisible()) {
					return entity.getAppearance();
				}
			}
		}
		
		return appearance;
	}
	
	public boolean isPassable() {
		return true;
	}
}
