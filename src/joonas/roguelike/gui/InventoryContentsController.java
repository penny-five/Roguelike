package joonas.roguelike.gui;

import javax.swing.DefaultListModel;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Inventory;
import joonas.roguelike.game.event.InventoryChangedEvent;

import com.google.common.eventbus.Subscribe;

public class InventoryContentsController extends Controller {
	private final InventoryContentsList list;
	private final DefaultListModel<Entity> model = new DefaultListModel<>();
	private final Inventory inventory;

	public InventoryContentsController(Inventory inventory, InventoryContentsList list) {
		this.inventory = inventory;
		this.list = list;
		list.setModel(model);

		updateView();
	}

	private void updateView() {
		model.clear();
		for (Entity entity : inventory.getContents()) {
			model.addElement(entity);
		}
	}

	@Subscribe
	public void onInventoryChanged(InventoryChangedEvent event) {
		if (event.getInventory().equals(inventory)) {
			updateView();
		}
	}

}
