package joonas.roguelike.game.entities;

import joonas.roguelike.game.Appearance;

public abstract class PhysicalEntity extends Entity {
	public abstract Appearance getAppearance();
	
	@Override
	public boolean isVisible() {
		return true;
	}
}
