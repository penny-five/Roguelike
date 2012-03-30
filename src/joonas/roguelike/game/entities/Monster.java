package joonas.roguelike.game.entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import joonas.roguelike.game.Appearance;
import joonas.roguelike.game.Log;
import joonas.roguelike.game.Tile;
import joonas.roguelike.game.World;
import joonas.roguelike.gui.MovementDirection;

public class Monster extends PhysicalEntity {
	public interface MonsterObserver {
		public void onPropertyChanged(Property property);
		public void onLocationChanged(Tile newLocation);
	}
	
	private final Inventory inventory;
	private final List<MonsterObserver> observers = new ArrayList<MonsterObserver>();
	
	public Monster() {
		inventory = new Inventory(this);
		
		setAppearance(new Appearance('@', Color.WHITE));
		set(Property.UNBREAKABLE, false);
		set(Property.MONSTER, true);
	}
	
	public void addObserver(MonsterObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(MonsterObserver observer) {
		observers.remove(observer);
	}
	
	private void notifyPropertyChanged(Property property) {
		if (observers == null) {
			return;
		}
		
		for (MonsterObserver observer : observers) {
			observer.onPropertyChanged(property);
		}
	}
	
	private void notifyLocationChanged(Tile location) {
		if (observers == null) {
			return;
		}
		
		for (MonsterObserver observer : observers) {
			observer.onLocationChanged(location);
		}
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void doMovement(MovementDirection direction) {
		int xDifference = direction.getXMovement();
		int yDifference = direction.getYMovement();
		boolean moved = moveBy(xDifference, yDifference);
		if (moved) {
			Log.debug(getString(Property.NAME) + " liikkui (" + getLocation().getX() + "," + getLocation().getY() + ")");
			notifyLocationChanged(getLocation());
			World.getActive().requestUpdate();
		}
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
