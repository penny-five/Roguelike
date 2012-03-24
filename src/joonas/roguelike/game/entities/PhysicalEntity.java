package joonas.roguelike.game.entities;

import joonas.roguelike.game.Appearance;

public abstract class PhysicalEntity extends Entity {
	public abstract Appearance getAppearance();
	
	public PhysicalEntity() {
		set(Property.PHYSICAL, true);
		set(Property.VISIBLE, true);
	}	
}
