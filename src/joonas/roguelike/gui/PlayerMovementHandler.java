package joonas.roguelike.gui;

import joonas.roguelike.game.World;
import joonas.roguelike.game.entities.Player;

public class PlayerMovementHandler {
	private static final PlayerMovementHandler INSTANCE = new PlayerMovementHandler();
	
	private Player player;
	
	private PlayerMovementHandler() {
		player = World.getActive().getPlayer();
	}
	
	public static PlayerMovementHandler getInstance() {
		return INSTANCE;
	}
	
	public void handleMovement(MovementDirection direction) {
		player.doMovement(direction);
	}
}
