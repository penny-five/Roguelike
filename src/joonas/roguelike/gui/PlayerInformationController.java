package joonas.roguelike.gui;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Monster;
import joonas.roguelike.game.entities.Property;
import joonas.roguelike.game.event.MonsterLocationChangedEvent;
import joonas.roguelike.game.event.MonsterPropertyChangedEvent;

import com.google.common.eventbus.Subscribe;

public class PlayerInformationController extends Controller {
	private final PlayerInformationPane pane;
	private final Entity player;

	public PlayerInformationController(Monster player, PlayerInformationPane pane) {
		this.player = player;
		this.pane = pane;

		updateView();
	}

	@Subscribe
	public void onPropertyChanged(MonsterPropertyChangedEvent event) {
		if (event.getMonster().equals(player)) {
			updateView();
		}
	}

	@Subscribe
	public void onLocationChanged(MonsterLocationChangedEvent event) {
		if (event.getMonster().equals(player)) {
			updateView();
		}
	}

	private void updateView() {
		pane.setName(player.getString(Property.NAME));
		pane.setHitpoints(player.getInt(Property.HITPOINTS), player.getInt(Property.MAX_HITPOINTS));
	}

}
