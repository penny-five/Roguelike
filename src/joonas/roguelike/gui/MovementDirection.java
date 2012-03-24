package joonas.roguelike.gui;

public enum MovementDirection {
	SOUTH_WEST('1'), 
	SOUTH('2'), 
	SOUTH_EAST('3'), 
	WEST('4'), 
	EAST('6'), 
	NORTH_WEST('7'), 
	NORTH('8'), 
	NORTH_EAST('9');
	
	private final char key;

	MovementDirection(char key) {
		this.key = key;
	}
	
	public static MovementDirection forKey(char key) {
		for (MovementDirection direction : MovementDirection.values()) {
			if (direction.key == key) {
				return direction;
			}
		}
		
		return null;
	}
}