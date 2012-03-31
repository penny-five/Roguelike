package joonas.roguelike.game.event;

import com.google.common.eventbus.EventBus;

public class Event {
	private static final EventBus bus = new EventBus();

	public static void post(Object object) {
		bus.post(object);
	}

	public static void register(Object object) {
		bus.register(object);
	}

	public static void unregister(Object object) {
		bus.unregister(object);
	}

}
