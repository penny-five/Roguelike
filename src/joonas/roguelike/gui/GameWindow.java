package joonas.roguelike.gui;

import java.awt.HeadlessException;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import joonas.roguelike.resources.Strings;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 554925090376395983L;

	public GameWindow() throws HeadlessException {
		setTitle(Strings.WINDOW_TITLE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		//setLayout(layout);
		
		GameView gameView = new GameView();
		JPanel leftPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		layout.setVerticalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(gameView)
					.addComponent(leftPanel, 200, GroupLayout.DEFAULT_SIZE, 150))
				.addGroup(layout.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(middlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(bottomPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(gameView)
						.addComponent(leftPanel))
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(topPanel, 300, GroupLayout.DEFAULT_SIZE, 300)
						.addComponent(middlePanel, 300, GroupLayout.DEFAULT_SIZE, 300)
						.addComponent(bottomPanel, 300, GroupLayout.DEFAULT_SIZE, 300))
		);

		
		addKeyListener(KeyboardEventProcessor.getInstance());
		
		pack();	
	}
}
