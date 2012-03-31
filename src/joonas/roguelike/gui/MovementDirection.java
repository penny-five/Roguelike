package joonas.roguelike.gui;

public enum MovementDirection {
	SOUTH_WEST('1', -1, 1),
		SOUTH('2', 0, 1),
		SOUTH_EAST('3', 1, 1),
		WEST('4', -1, 0),
		EAST('6', 1, 0),
		NORTH_WEST('7', -1, -1),
		NORTH('8', 0, -1),
		NORTH_EAST('9', 1, -1);

	private final char key;
	private final int xMovement;
	private final int yMovement;

	MovementDirection(char key, int horizontalAdvancement,
			int verticalAdvancement) {
		this.key = key;
		xMovement = horizontalAdvancement;
		yMovement = verticalAdvancement;
	}

	public static MovementDirection forKey(char key) {
		for (MovementDirection direction : MovementDirection.values()) {
			if (direction.key == key) {
				return direction;
			}
		}

		return null;
	}

	public int getXMovement() {
		return xMovement;
	}

	public int getYMovement() {
		return yMovement;
	}
}