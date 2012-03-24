package joonas.roguelike.gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import joonas.roguelike.resources.Strings;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 554925090376395983L;

	public GameWindow() throws HeadlessException {
		setTitle(Strings.WINDOW_TITLE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		GameView gameView = new GameView();
		add(gameView);
		
		
		pack();	
	}
}