package joonas.roguelike.gui;

import joonas.roguelike.game.entities.Monster.MonsterObserver;
import joonas.roguelike.game.entities.Player;
import joonas.roguelike.game.entities.Property;

public class PlayerInformationController implements MonsterObserver {
	private PlayerInformationPane pane;
	private Player player;
	
	public PlayerInformationController(Player player, PlayerInformationPane pane) {
		this.player = player;
		this.pane = pane;
		
		player.addObserver(this);
		updateView();
	}
	
	@Override
	public void onPropertyChanged(Property property) {
		updateView();
	}
	
	private void updateView() {
		pane.setName(player.string(Property.NAME));
		pane.setHitpoints(player.numberOf(Property.HITPOINTS), player.numberOf(Property.MAX_HITPOINTS));
	}

}
