package joonas.roguelike.gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import joonas.roguelike.game.entities.Entity;
import joonas.roguelike.game.entities.Property;

public class TileContentsListCell extends JLabel implements ListCellRenderer<Entity> {
	private static final long serialVersionUID = 8886673940785054440L;

	@Override
	public Component getListCellRendererComponent(
			JList<? extends Entity> list, Entity value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setText(value.getString(Property.NAME));
		
		return this;
	}
}
