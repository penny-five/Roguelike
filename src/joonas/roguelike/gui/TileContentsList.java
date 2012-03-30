package joonas.roguelike.gui;

import joonas.roguelike.game.entities.Entity;

public class TileContentsList extends ContentsList<Entity> {
	private static final long serialVersionUID = 7900313517855772308L;

	public TileContentsList() {
		setCellRenderer(new TileContentsListCell());
	}
}
