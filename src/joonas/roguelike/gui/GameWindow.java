package joonas.roguelike.gui;

import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import joonas.roguelike.game.World;
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
		
		GameView gameView = new GameView();
		
		LogList logPane = new LogList();
		new LogController(logPane);
		
		JScrollPane scrollPane = new JScrollPane(logPane);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		leftPanel.setBorder(new TitledBorder("Kapteenin loki"));
		leftPanel.add(scrollPane);
		
		PlayerInformationPane informationPane = new PlayerInformationPane();
		new PlayerInformationController(World.getActive().getPlayer(), informationPane);
		
		TileContentsList tileContentsList = new TileContentsList();
		new TileContentsController(World.getActive().getPlayer(), tileContentsList);
		JScrollPane tileContentsListScrollPane = new JScrollPane(tileContentsList);
		
		JPanel tileContentsListWrapper = new JPanel();
		tileContentsListWrapper.setLayout(new BoxLayout(tileContentsListWrapper, BoxLayout.PAGE_AXIS));
		tileContentsListWrapper.add(tileContentsListScrollPane);
		tileContentsListWrapper.setBorder(new TitledBorder("Maassa"));
		
		JPanel centerPanel = new JPanel();
		layout.setVerticalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(gameView)
					.addComponent(leftPanel, 150, GroupLayout.DEFAULT_SIZE, 150))
				.addGroup(layout.createSequentialGroup()
					.addComponent(informationPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(centerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tileContentsListWrapper, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150))
		);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
					.addComponent(gameView)
					.addComponent(leftPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
					.addComponent(informationPane, 300, GroupLayout.DEFAULT_SIZE, 300)
					.addComponent(centerPanel, 300, GroupLayout.DEFAULT_SIZE, 300)
					.addComponent(tileContentsListWrapper, 300, GroupLayout.DEFAULT_SIZE, 300))
		);

		addKeyListener(KeyboardEventProcessor.getInstance());
		
		pack();	
		
		gameView.requestFocus();
	}
}
