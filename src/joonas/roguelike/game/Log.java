package joonas.roguelike.game;

import java.util.ArrayList;
import java.util.List;

public class Log {
	public interface LogObserver {
		public void onLogEntryAdded(LogEntry entry);
	}
	
	public static class LogEntry {
		private final String text;
		private final LogEntryType type;
		
		private LogEntry(String text, LogEntryType type) {
			this.text = text;
			this.type = type;
		}
		
		public String getText() {
			return text;
		}
		
		public LogEntryType getType() {
			return type;
		}
	}
	
	public enum LogEntryType { DEBUG, EVENT };
	
	private static final List<LogEntry> messages = new ArrayList<LogEntry>();
	private static final List<LogObserver> observers = new ArrayList<Log.LogObserver>();
	
	public static void addObserver(LogObserver observer) {
		observers.add(observer);
	}
	
	public static void removeObserver(LogObserver observer) {
		observers.remove(observer);
	}
	
	public static void debug(String text) {
		messages.add(new LogEntry(text, LogEntryType.DEBUG));
		notifyObservers();
	}
	
	public static void event(String text) {
		messages.add(new LogEntry(text, LogEntryType.EVENT));
		notifyObservers();
	}
	
	
	private static void notifyObservers() {
		for (LogObserver observer : observers) {
			observer.onLogEntryAdded(messages.get(messages.size() - 1));
		}
	}
	
	
}
