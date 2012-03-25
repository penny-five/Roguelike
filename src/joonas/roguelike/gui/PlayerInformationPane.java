package joonas.roguelike.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.LabelAlignment;

public class PlayerInformationPane extends JPanel {
	private static final long serialVersionUID = -4619529014206399736L;
	
	private DesignGridLayout layout;
	
	public PlayerInformationPane() {
		super();
		layout = new DesignGridLayout(this);
		layout.labelAlignment(LabelAlignment.RIGHT);
	}
	
	public void addPlayerValue(String name, String value) {	
		JLabel nameLabel = new JLabel(name + ":");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		layout.row().grid(nameLabel).add(new JLabel(value));
	}

}
