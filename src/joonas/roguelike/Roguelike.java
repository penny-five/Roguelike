package joonas.roguelike;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import joonas.roguelike.gui.GameView;
import joonas.roguelike.gui.GameWindow;
import joonas.roguelike.resources.Strings;


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
