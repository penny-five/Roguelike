package joonas.roguelike.game.entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import joonas.roguelike.game.Appearance;

public class Monster extends PhysicalEntity {
	public interface MonsterObserver {
		public void onPropertyChanged(Property property);
	}
	
	private final List<MonsterObserver> observers = new ArrayList<MonsterObserver>();
	
	public Monster() {
		setAppearance(new Appearance('@', Color.WHITE));
		set(Property.UNBREAKABLE, false);
	}
	
	public void addObserver(MonsterObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(MonsterObserver observer) {
		observers.remove(observer);
	}
	
	private void notifyObservers(Property property) {
//		for (MonsterObserver observer : observers) {
//			observer.onPropertyChanged(property);
//		}
	}
	
	@Override
	public void set(Property property, boolean value) {
		super.set(property, value);
		notifyObservers(property);
	}
	
	@Override
	public void set(Property property, int value) {
		super.set(property, value);
		notifyObservers(property);
	}
	
	@Override
	public void set(Property property, String value) {
		super.set(property, value);
		notifyObservers(property);
	}

}
