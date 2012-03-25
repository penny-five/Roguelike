package joonas.roguelike.game.entities;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Entity> contents = new ArrayList<Entity>();
	private Monster owner;
	
	public Inventory(Monster owner) {
		this.owner = owner;
	}
	
	public void addItem(Entity entity) {
		contents.add(entity);
	}
	
	public void removeItem(Entity entity) {
		contents.remove(entity);
	}
}
