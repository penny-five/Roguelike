package joonas.roguelike.game.event;

import joonas.roguelike.game.entities.Monster;
import joonas.roguelike.game.entities.Property;

public class MonsterPropertyChangedEvent {
	private final Monster monster;
	private final Property property;

	public MonsterPropertyChangedEvent(Monster monster, Property property) {
		this.monster = monster;
		this.property = property;
	}

	public Monster getMonster() {
		return monster;
	}

	public Property property() {
		return property;
	}
}
