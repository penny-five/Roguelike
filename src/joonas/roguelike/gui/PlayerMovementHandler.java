package joonas.roguelike.gui;

import joonas.roguelike.game.World;
import joonas.roguelike.game.entities.Monster;
import joonas.roguelike.game.entities.Player;
import joonas.roguelike.game.entities.Property;

public class PlayerMovementHandler {
	private static final PlayerMovementHandler INSTANCE = new PlayerMovementHandler();
	
	private Monster player;
	
	private PlayerMovementHandler() {
		player = World.getActive().getPlayer();
	}
	
	public static PlayerMovementHandler getInstance() {
		return INSTANCE;
	}
	
	public void handleMovement(MovementDirection direction) {
		player.doMovement(direction);
		int currentHitpoints = player.getInt(Property.HITPOINTS);
		player.set(Property.HITPOINTS, currentHitpoints - 1);
	}
}
