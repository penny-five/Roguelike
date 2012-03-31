package joonas.roguelike.game.event;

import joonas.roguelike.game.Tile;

public class TileContentChangedEvent {
	private final Tile tile;

	public TileContentChangedEvent(Tile tile) {
		this.tile = tile;
	}

	public Tile getTile() {
		return tile;
	}
}
