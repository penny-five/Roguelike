package joonas.roguelike.game.entities;

public abstract class PhysicalEntity extends Entity {
	public PhysicalEntity() {
		set(Property.PHYSICAL, true);
		set(Property.VISIBLE, true);
	}
}
