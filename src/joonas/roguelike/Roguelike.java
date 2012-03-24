package joonas.roguelike;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import joonas.roguelike.gui.GameView;
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
		JFrame frame = new JFrame(Strings.WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JMenuBar menubar = new JMenuBar();
		menubar.add(new JMenu("muna"));
		
		frame.add(menubar);
		
		GameView gameView = new GameView();
		
		frame.add(gameView);
		
		
		frame.pack();	
		frame.setVisible(true);
	}

}
