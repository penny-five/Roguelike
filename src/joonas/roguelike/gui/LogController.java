package joonas.roguelike.gui;

import javax.swing.DefaultListModel;

import joonas.roguelike.game.Log;
import joonas.roguelike.game.Log.LogEntry;
import joonas.roguelike.game.Log.LogObserver;

public class LogController implements LogObserver {
	private final DefaultListModel<LogEntry> model = new DefaultListModel<>();
	private final LogList pane;

	public LogController(LogList pane) {
		this.pane = pane;
		pane.setModel(model);
		Log.addObserver(this);
	}

	@Override
	public void onLogEntryAdded(LogEntry entry) {
		model.addElement(entry);
		pane.ensureIndexIsVisible(model.getSize() - 1);
	}
}
