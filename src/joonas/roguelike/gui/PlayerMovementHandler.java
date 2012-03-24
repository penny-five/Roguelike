package joonas.roguelike.gui;

import joonas.roguelike.game.Log;

public class PlayerMovementHandler {
	private static final PlayerMovementHandler INSTANCE = new PlayerMovementHandler();
	
	private PlayerMovementHandler() {
		
	}
	
	public static PlayerMovementHandler getInstance() {
		return INSTANCE;
	}
	
	public void handleMovement(MovementDirection direction) {
		Log.debug("should handle movement to " + direction.name());
	}
}
