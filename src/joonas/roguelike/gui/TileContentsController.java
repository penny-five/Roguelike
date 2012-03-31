package joonas.roguelike.gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import joonas.roguelike.game.Log;
import joonas.roguelike.game.Tile;
import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Monster;
import joonas.roguelike.game.entities.Property;
import joonas.roguelike.game.event.MonsterLocationChangedEvent;
import joonas.roguelike.game.event.TileContentChangedEvent;
import joonas.roguelike.gui.ContentsList.OnPopUpMenuRequestedListener;

import com.google.common.eventbus.Subscribe;

public class TileContentsController extends Controller implements OnPopUpMenuRequestedListener {
	private final TileContentsList list;
	private final DefaultListModel<Entity> model = new DefaultListModel<>();
	private final Monster player;
	private Tile location;

	public TileContentsController(Monster player, TileContentsList list) {
		this.player = player;
		this.list = list;

		list.setModel(model);
		list.setOnPopUpMenuRequestedListener(this);

		location = player.getLocation();
		updateView();
	}

	@Subscribe
	public void onLocationChanged(MonsterLocationChangedEvent event) {
		if (event.getMonster().equals(player)) {
			location = player.getLocation();
			updateView();
		}
	}

	@Subscribe
	public void onTileContentsChanged(TileContentChangedEvent event) {
		if (event.getTile().equals(player.getLocation())) {
			updateView();
		}
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
	public void onPopUpMenuRequested(Point location, int index) {
		final Entity selectedEntity = player.getLocation().getEntitiesWithProperty(Property.PICKABLE, true).get(index);

		JPopupMenu menu = new JPopupMenu(selectedEntity.getString(Property.NAME));
		menu.setLightWeightPopupEnabled(false);
		JMenuItem item = new JMenuItem("Poimi");
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.pickUpItem(selectedEntity);
				Log.event(player.getString(Property.NAME) + " poimi esineen " + selectedEntity.getString(Property.NAME));
			}
		});

		menu.add(item);

		menu.show(list, location.x, location.y);
	}
}
