package joonas.roguelike.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import joonas.roguelike.game.Appearance;
import joonas.roguelike.game.Level;
import joonas.roguelike.game.World;


public class GameView extends JPanel {
	private static final int PREFERRED_HEIGHT_IN_TILES = 50;
	private static final int PREFERRED_WIDTH_IN_TILES = 50;
	
	private static final String UNICODE_FULL_BLOCK = "\u2588";
	private static final long serialVersionUID = 4375482311151482280L;

	public GameView() {
		super();
	}

	public GameView(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public GameView(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public GameView(LayoutManager layout) {
		super(layout);
	}
	
	@Override
	public Dimension getPreferredSize() {
		Dimension tileSize = calculateTileSizeFrom(getGraphics());
		return new Dimension(tileSize.width * PREFERRED_WIDTH_IN_TILES, tileSize.height * PREFERRED_HEIGHT_IN_TILES);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawBackground(g);
		
		Dimension tileSize = calculateTileSizeFrom(g);	
		
		Level level = World.getActive().getCurrentLevel();
		
		int horizontalOffset = calculateOffset(getWidth(), tileSize.width, level.getWidth());
		int verticalOffset = calculateOffset(getHeight(), tileSize.height, level.getHeight());
		g.translate(horizontalOffset, verticalOffset);
		
		for (int y = 0; y < level.getHeight(); y++) {
			for (int x = 0; x < level.getWidth(); x++) {
				Appearance appearance = level.getTile(x, y).getPaintedAppearance();
				drawTile(x, y, appearance, tileSize, g);
			}
		}
	}
	
	private void drawBackground(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	private void drawTile(int x, int y, Appearance appearance, Dimension tileSize, Graphics g) {
		g.setColor(appearance.getBackgroundColor());
		int topLeftX = x * tileSize.width;
		int topLeftY = y * tileSize.height;
		int bottomRightX = topLeftX + tileSize.width;
		int bottomRightY = topLeftY + tileSize.height;
		g.drawRect(topLeftX, topLeftY, bottomRightX, bottomRightY);
		g.setColor(appearance.getGraphicColor());
		g.drawString(String.valueOf(appearance.getGraphic()), topLeftX, bottomRightY);
	}
	
	private Dimension calculateTileSizeFrom(Graphics g) {
		Rectangle2D charBounds = g.getFontMetrics().getStringBounds(UNICODE_FULL_BLOCK, g);
		int tileHeight = (int) (charBounds.getHeight() + 0.5);
		int tileWidth = (int) (charBounds.getWidth() + 0.5);
		return new Dimension(tileWidth, tileHeight);
	}
	
	private int calculateOffset(int totalSize, int tileSize, int numOfTiles) {
		int tileAreaSize = numOfTiles * tileSize;
		return (int) ((totalSize - tileAreaSize) * 0.5 + 0.5);
	}
}
