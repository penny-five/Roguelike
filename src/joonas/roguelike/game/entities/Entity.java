package joonas.roguelike.game.entities;

import java.util.Map;

import joonas.roguelike.game.Appearance;
import joonas.roguelike.game.Level;
import joonas.roguelike.game.Tile;

public abstract class Entity {
	private final Map<Property, Object> properties = Property.defaultValueMap();
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

	protected boolean moveBy(int x, int y) {
		return location.getLevel().moveEntityBy(this, location, x, y);
	}

	protected final void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	public boolean getBoolean(Property property) {
		return (Boolean) properties.get(property);
	}

	public int getInt(Property property) {
		return (Integer) properties.get(property);
	}

	public String getString(Property property) {
		return (String) properties.get(property);
	}

	public Object get(Property property) {
		return properties.get(property);
	}

	public void set(Property property, boolean value) {
		properties.put(property, Boolean.valueOf(value));
	}

	public void set(Property property, int value) {
		properties.put(property, Integer.valueOf(value));
	}

	public void set(Property property, String value) {
		properties.put(property, value);
	}
}
