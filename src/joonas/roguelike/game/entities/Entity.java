package joonas.roguelike.game.entities;

import java.util.HashMap;
import joonas.roguelike.game.Appearance;
import joonas.roguelike.game.Level;
import joonas.roguelike.game.Tile;

public abstract class Entity {
	private HashMap<Property, Object> properties = new HashMap<Property, Object>();
	private Appearance appearance = Appearance.INVISIBLE;
	private Tile location;
	
	public Appearance getAppearance() {
		return appearance;
	}
	
	public void setLocation(Tile location) {
		this.location = location;
	}
	
	public Tile getLocation() {
		return location;
	}
	
	public Level getLevel() {
		return location.getLevel();
	}
	
	protected void moveBy(int x, int y) {
		location.getLevel().moveEntityBy(this, location, x, y);
	}
	
	protected final void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}
	
	public boolean is(Property property) {
		return (Boolean) properties.get(property);
	}
	
	public void set(Property property, boolean value) {
		properties.put(property, Boolean.valueOf(value));
	}
	
	public int numberOf(Property property) {
		return (Integer) properties.get(property);
	}
	
	public void set(Property property, int value) {
		properties.put(property, Integer.valueOf(value));
	}
}
