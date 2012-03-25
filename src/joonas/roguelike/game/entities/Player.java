package joonas.roguelike.game.entities;

import joonas.roguelike.gui.MovementDirection;

public class Player extends Monster {
	public Player() {
		set(Property.NAME, "Jorma");
		set(Property.MAX_HITPOINTS, 50);
		set(Property.HITPOINTS, 50);
	}
	
	public void doMovement(MovementDirection direction) {
		int xDifference = direction.getXMovement();
		int yDifference = direction.getYMovement();
		moveBy(xDifference, yDifference);
	}
}
