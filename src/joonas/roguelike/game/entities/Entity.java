package joonas.roguelike.game.entities;

import java.util.HashMap;
import joonas.roguelike.game.Appearance;

public abstract class Entity {
	private HashMap<Property, Object> properties = new HashMap<Property, Object>();
	
	public Appearance getAppearance() {
		return Appearance.INVISIBLE;
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
