package joonas.roguelike.game.entities;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	public interface InventoryObserver {
		public void onInventoryChanged(Inventory inventory);
	}
	private List<InventoryObserver> observers = new ArrayList<InventoryObserver>();
	
	private List<Entity> contents = new ArrayList<Entity>();
	private Monster owner;
	
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
	
	public void addObserver(InventoryObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(InventoryObserver observer) {
		observers.remove(observer);
	}
	
	private void notifyInventoryChanged() {
		for (InventoryObserver observer : observers) {
			observer.onInventoryChanged(this);
		}
	}
}
