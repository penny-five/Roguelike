package joonas.roguelike.game.entities;

public enum Property {
	VISIBLE("visible", false),
	BLOCKS_PLAYER_MOVEMENT("blocks_player_movement", false),
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
	
	
}
