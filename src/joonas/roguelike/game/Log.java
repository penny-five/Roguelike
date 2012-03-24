package joonas.roguelike.game;

import java.util.ArrayList;
import java.util.List;

public class Log {
	private static final List<String> messages = new ArrayList<String>();
	
	public static void debug(String text) {
		messages.add(text);
		print(text);
	}
	
	public static void event(String text) {
		messages.add(text);
		print(text);
	}
	
	private static void print(String text) {
		System.out.println(text);
	}
}
