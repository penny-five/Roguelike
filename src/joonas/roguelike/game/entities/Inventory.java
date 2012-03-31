package joonas.roguelike.game.entities;

import java.util.ArrayList;
import java.util.List;

import joonas.roguelike.game.event.Event;
import joonas.roguelike.game.event.InventoryChangedEvent;

public class Inventory {
	private final List<Entity> contents = new ArrayList<>();
	private final Monster owner;

	public Inventory(Monster owner) {
		this.owner = owner;
	}

	public void addItem(Entity entity) {
		contents.add(entity);
		notifyInventoryChanged();
	}

	public void removeItem(Entity entity) {
		contents.remove(entity);
		notifyInventoryChanged();
	}

	public List<Entity> getContents() {
		return contents;
	}

	private void notifyInventoryChanged() {
		Event.post(new InventoryChangedEvent(this));
	}
}
