package joonas.roguelike;

import javax.swing.SwingUtilities;

import joonas.roguelike.gui.GameWindow;

public class Roguelike {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createGui();
			}
		});

	}

	private static void createGui() {
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
	}

}
