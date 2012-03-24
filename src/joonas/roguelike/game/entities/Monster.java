package joonas.roguelike.game.entities;

import java.awt.Color;

import joonas.roguelike.game.Appearance;

public class Monster extends PhysicalEntity {
	private Appearance appearance;
	public Monster() {
		appearance = new Appearance('@', Color.WHITE);
	}
	
	@Override
	public Appearance getAppearance() {
		return appearance;
	}

}
