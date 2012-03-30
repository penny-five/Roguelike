package joonas.roguelike.gui;

import javax.swing.DefaultListModel;
import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Inventory;
import joonas.roguelike.game.entities.Inventory.InventoryObserver;

public class InventoryContentsController implements InventoryObserver {
	private InventoryContentsList list;
	private DefaultListModel<Entity> model = new DefaultListModel<Entity>();
	private Inventory inventory;
	
	public InventoryContentsController(Inventory inventory, InventoryContentsList list) {
		this.inventory = inventory;
		this.list = list;
		list.setModel(model);
		
		inventory.addObserver(this);
		updateView();
	}
	
	private void updateView() {
		model.clear();
		for (Entity entity : inventory.getContents()) {
			model.addElement(entity);
		}
	}

	@Override
	public void onInventoryChanged(Inventory inventory) {
		updateView();
	}

}
