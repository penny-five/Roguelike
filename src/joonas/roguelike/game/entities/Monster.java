package joonas.roguelike.game.entities;

import java.awt.Color;

import joonas.roguelike.game.Appearance;

public class Monster extends PhysicalEntity {
	public Monster() {
		setAppearance(new Appearance('@', Color.WHITE));
	}

}
