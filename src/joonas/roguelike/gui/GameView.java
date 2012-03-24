package joonas.roguelike.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import joonas.roguelike.game.Appearance;
import joonas.roguelike.game.Level;
import joonas.roguelike.game.Tile;
import joonas.roguelike.game.World;


public class GameView extends JPanel {
	private static final long serialVersionUID = 4375482311151482280L;
	private static final int TILE_WIDTH = 20;
	private static final int TILE_HEIGHT = 20;
	


	public GameView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameView(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public GameView(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public GameView(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getHeight(), getWidth());
		
		Level level = World.getActive().getCurrentLevel();
		for (int y = 0; y < level.getHeight(); y++) {
			for (int x = 0; x < level.getWidth(); x++) {
				Appearance tileAppearance = level.getTile(x, y).getPaintedAppearance();
				g.setColor(tileAppearance.getBackgroundColor());
				int topLeftX = x * TILE_WIDTH;
				int topLeftY = y * TILE_HEIGHT;
				int bottomRightX = topLeftX + TILE_WIDTH;
				int bottemRightY = topLeftY + TILE_HEIGHT;
				g.drawRect(topLeftX, topLeftY, bottomRightX, bottemRightY);
				g.setColor(tileAppearance.getGraphicColor());
				g.drawString(String.valueOf(tileAppearance.getGraphic()), topLeftX, topLeftY);
			}
		}
	}
}
