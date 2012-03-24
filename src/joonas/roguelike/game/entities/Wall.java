package joonas.roguelike.game.entities;

import java.awt.Color;

import joonas.roguelike.game.Appearance;

public class Wall extends PhysicalEntity {
	public Wall() {
		setAppearance(new Appearance('#', Color.YELLOW));
		set(Property.BLOCKS_PLAYER_MOVEMENT, true);
	}

}
