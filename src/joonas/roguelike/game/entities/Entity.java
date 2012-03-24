package joonas.roguelike.game.entities;

import joonas.roguelike.game.Appearance;

public abstract class Entity {
	public boolean isVisible() {
		return false;
	}
	
	public Appearance getAppearance() {
		return Appearance.INVISIBLE;
	}
}
