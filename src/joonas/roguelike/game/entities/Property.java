package joonas.roguelike.game.entities;

import java.util.HashMap;
import java.util.Map;

public enum Property {
	HITPOINTS("hitpoints", 1),
	MAX_HITPOINTS("max_hitpoints", 50),
	NAME("name", "unknown"),
	UNBREAKABLE("unbreakable", true),
	VISIBLE("visible", false),
	UNPASSABLE("unpassable", false),
	PHYSICAL("physical", false);
	
	public enum PropertyType { INTEGER, BOOLEAN };
	
	private final String identifier;
	private final Object defaultValue;
	private final PropertyType type;
	
	private Property(String identifier, Object defaultValue) {
		this.identifier = identifier;
		this.defaultValue = defaultValue;
		if (defaultValue instanceof Boolean) {
			type = PropertyType.BOOLEAN;
		} else {
			type = PropertyType.INTEGER;
		}
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public PropertyType getType() {
		return type;
	}
	
	public static Map<Property, Object> defaultValueMap() {
		Map<Property, Object> m = new HashMap<Property, Object>();
		for (Property property : values()) {
			m.put(property, property.defaultValue);
		}
		return m;
		
	}
	
	
}
