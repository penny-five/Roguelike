package joonas.roguelike.game;

import java.util.ArrayList;
import java.util.List;

public class World {
	private static final int LEVEL_COUNT = 5;
	
	private static World activeWorld;
	
	private final List<Level> levels;
	private int currentLevelIndex = 0;
	
	public static World getActive() {
		if (activeWorld == null) {
			activeWorld = new World();
		}
		
		return activeWorld;
	}
	
	public World() {
		levels = new ArrayList<Level>();
		for (int i = 0; i < LEVEL_COUNT; i++) {
			levels.add(LevelGenerator.generateSimpleLevel());
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
}
