package joonas.roguelike.game;

import java.util.ArrayList;
import java.util.List;

import joonas.roguelike.game.entities.Monster;

public class World {
	public interface WorldObserver {
		public void onWorldUpdated();
	}

	private static final int LEVEL_COUNT = 5;

	private static World activeWorld;

	private final List<WorldObserver> observers = new ArrayList<>();

	private final List<Level> levels;
	private final int currentLevelIndex = 0;

	public static World getActive() {
		if (activeWorld == null) {
			activeWorld = new World();
		}

		return activeWorld;
	}

	public World() {
		levels = new ArrayList<>();
		for (int i = 0; i < LEVEL_COUNT; i++) {
			levels.add(LevelGenerator.generateSimpleLevel(this));
		}
	}

	public int getLevelCount() {
		return levels.size();
	}

	public Level getLevel(int index) {
		return levels.get(index);
	}

	public Level getCurrentLevel() {
		return levels.get(currentLevelIndex);
	}

	public int getCurrentLevelIndex() {
		return currentLevelIndex;
	}

	public Monster getPlayer() {
		return levels.get(currentLevelIndex).getPlayer();
	}

	public void requestUpdate() {
		for (WorldObserver observer : observers) {
			observer.onWorldUpdated();
		}
	}

	public void addObserver(WorldObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(WorldObserver observer) {
		observers.remove(observer);
	}
}
