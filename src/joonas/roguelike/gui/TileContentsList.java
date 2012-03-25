package joonas.roguelike.gui;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import joonas.roguelike.game.entities.Entity;

public class TileContentsList extends JList<Entity> {
	private static final long serialVersionUID = 7900313517855772308L;

	public TileContentsList() {
		setCellRenderer(new TileContentsListCell());
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setSelectionBackground(Color.RED);
		setAlignmentX(JList.LEFT_ALIGNMENT);
	}
}
