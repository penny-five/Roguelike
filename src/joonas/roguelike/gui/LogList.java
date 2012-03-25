package joonas.roguelike.gui;

import javax.swing.JList;

import joonas.roguelike.game.Log.LogEntry;

public class LogList extends JList<LogEntry> {
	private static final long serialVersionUID = -8015917914571530531L;

	public LogList() {
		setCellRenderer(new LogListCell());
		setAlignmentX(JList.LEFT_ALIGNMENT);
	}
}
