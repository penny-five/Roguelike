package joonas.roguelike.game.entities;

import java.awt.Color;

import joonas.roguelike.game.Appearance;

public class Armor extends PhysicalEntity {
	public Armor() {
		set(Property.PICKABLE, true);
		set(Property.WEIGHT, 10);
		setAppearance(new Appearance(';', Color.PINK));
	}
}