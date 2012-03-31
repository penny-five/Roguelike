package joonas.roguelike.game.event;

import joonas.roguelike.game.entities.Inventory;

public class InventoryChangedEvent {
	private final Inventory inventory;

	public InventoryChangedEvent(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return inventory;
	}
}
