package joonas.roguelike.game.entities;

public class Player extends Monster {
	public Player() {
		set(Property.NAME, "Jorma");
		set(Property.MAX_HITPOINTS, 50);
		set(Property.HITPOINTS, 50);
		set(Property.PLAYER_CONTROLLED, true);
	}
}
