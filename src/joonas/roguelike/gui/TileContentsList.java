package joonas.roguelike.gui;

import javax.swing.JList;

import joonas.roguelike.game.entities.Entity;

public class TileContentsList extends JList<Entity> {
	private static final long serialVersionUID = 7900313517855772308L;

	public TileContentsList() {
		setCellRenderer(new TileContentsListCell());
		setAlignmentX(JList.LEFT_ALIGNMENT);
	}
}
