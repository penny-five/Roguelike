package joonas.roguelike.game.entities;

import java.awt.Color;

import joonas.roguelike.game.Appearance;
import joonas.roguelike.game.World;
import joonas.roguelike.game.event.Event;
import joonas.roguelike.game.event.MonsterLocationChangedEvent;
import joonas.roguelike.game.event.MonsterPropertyChangedEvent;
import joonas.roguelike.gui.MovementDirection;

public class Monster extends PhysicalEntity {
	private final Inventory inventory;

	public Monster() {
		inventory = new Inventory(this);

		setAppearance(new Appearance('@', Color.WHITE));
		set(Property.UNBREAKABLE, false);
		set(Property.MONSTER, true);
	}

	private void notifyLocationChanged() {
		Event.post(new MonsterLocationChangedEvent(this));
	}

	private void notifyPropertyChanged(Property property) {
		Event.post(new MonsterPropertyChangedEvent(this, property));
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void doMovement(MovementDirection direction) {
		int xDifference = direction.getXMovement();
		int yDifference = direction.getYMovement();
		boolean moved = moveBy(xDifference, yDifference);
		if (moved) {
			notifyLocationChanged();
			World.getActive().requestUpdate();
		}
	}

	public void pickUpItem(Entity item) {
		getLocation().removeEntity(item);
		getInventory().addItem(item);
	}

	@Override
	public void set(Property property, boolean value) {
		super.set(property, value);
		notifyPropertyChanged(property);
	}

	@Override
	public void set(Property property, int value) {
		super.set(property, value);
		notifyPropertyChanged(property);
	}

	@Override
	public void set(Property property, String value) {
		super.set(property, value);
		notifyPropertyChanged(property);
	}

}
