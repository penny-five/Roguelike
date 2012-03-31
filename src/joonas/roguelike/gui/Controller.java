package joonas.roguelike.gui;

import joonas.roguelike.game.Log;
import joonas.roguelike.game.event.Event;

public abstract class Controller {
	public Controller() {
		Log.debug("added controller");
		Event.register(this);
	}
}
