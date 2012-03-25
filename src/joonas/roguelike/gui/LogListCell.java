package joonas.roguelike.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import joonas.roguelike.game.Log.LogEntry;

public class LogListCell extends JLabel implements ListCellRenderer<LogEntry> {
	private static final long serialVersionUID = 8886673940785054440L;

	@Override
	public Component getListCellRendererComponent(
			JList<? extends LogEntry> list, LogEntry value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setText(value.getText());
		switch (value.getType()) {
		case DEBUG:
			setForeground(Color.GREEN);
			break;
		case EVENT: 
			setForeground(Color.BLACK);
		default:
			setForeground(Color.GRAY);
		}
		
		return this;
	}

}
