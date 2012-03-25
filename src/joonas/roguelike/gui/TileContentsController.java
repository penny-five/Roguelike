package joonas.roguelike.gui;

import javax.swing.DefaultListModel;
import joonas.roguelike.game.Tile;
import joonas.roguelike.game.Tile.TileObserver;
import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Monster;
import joonas.roguelike.game.entities.Monster.MonsterObserver;
import joonas.roguelike.game.entities.Property;

public class TileContentsController implements MonsterObserver, TileObserver {
	private TileContentsList list;
	private DefaultListModel<Entity> model = new DefaultListModel<Entity>();
	private Entity player;
	private Tile location;
	
	public TileContentsController(Monster player, TileContentsList list) {
		this.player = player;
		this.list = list;
		list.setModel(model);
		
		player.addObserver(this);
		location = player.getLocation();
		location.addObserver(this);
		updateView();
	}
	
	@Override
	public void onPropertyChanged(Property property) {
		updateView();
	}
	
	private void updateView() {
		model.clear();
		for (Entity entity : location.getEntities()) {
			if (!entity.equals(player)) {
				model.addElement(entity);
			}
		}
	}

	@Override
	public void onLocationChanged(Tile newLocation) {
		if (location != null) {
			location.removeObserver(this);
		}
		location = newLocation;
		location.addObserver(this);
		updateView();
	}

	@Override
	public void onTileContentsChanged() {
		updateView();
	}

}
