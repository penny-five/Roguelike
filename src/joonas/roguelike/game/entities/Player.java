package joonas.roguelike.game.entities;

import joonas.roguelike.gui.MovementDirection;

public class Player extends Monster {
	public Player() {
		
	}
	
	public void doMovement(MovementDirection direction) {
		int xDifference = direction.getXMovement();
		int yDifference = direction.getYMovement();
		moveBy(xDifference, yDifference);
	}
}
