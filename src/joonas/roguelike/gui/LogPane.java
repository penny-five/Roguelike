package joonas.roguelike.gui;

import javax.swing.JList;

import joonas.roguelike.game.Log.LogEntry;

public class LogPane extends JList<LogEntry> {
	
	public LogPane() {
		setCellRenderer(new LogListCell());
		setAlignmentX(JList.LEFT_ALIGNMENT);
	}
	
	public void addEntry(LogEntry entry) {
		
	}
}
