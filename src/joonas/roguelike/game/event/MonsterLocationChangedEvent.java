package joonas.roguelike.game.event;

import joonas.roguelike.game.entities.Monster;

public class MonsterLocationChangedEvent {
	private final Monster monster;

	public MonsterLocationChangedEvent(Monster monster) {
		this.monster = monster;
	}

	public Monster getMonster() {
		return monster;
	}
}
