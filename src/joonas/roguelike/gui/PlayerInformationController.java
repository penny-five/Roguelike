package joonas.roguelike.gui;

import joonas.roguelike.game.Tile;
import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Monster;
import joonas.roguelike.game.entities.Monster.MonsterObserver;
import joonas.roguelike.game.entities.Property;

public class PlayerInformationController implements MonsterObserver {
	private PlayerInformationPane pane;
	private Entity player;
	
	public PlayerInformationController(Monster player, PlayerInformationPane pane) {
		this.player = player;
		this.pane = pane;
		
		player.addObserver(this);
		updateView();
	}
	
	@Override
	public void onPropertyChanged(Property property) {
		updateView();
	}
	
	@Override
	public void onLocationChanged(Tile newLocation) {}
	
	private void updateView() {
		pane.setName(player.getString(Property.NAME));
		pane.setHitpoints(player.getInt(Property.HITPOINTS), player.getInt(Property.MAX_HITPOINTS));
	}



}
