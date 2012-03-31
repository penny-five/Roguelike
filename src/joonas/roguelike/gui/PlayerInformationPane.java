package joonas.roguelike.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.LabelAlignment;

public class PlayerInformationPane extends JPanel {
	private static final long serialVersionUID = -4619529014206399736L;

	private final DesignGridLayout layout;
	private final JLabel nameLabel;
	private final JLabel hitpointsLabel;

	public PlayerInformationPane() {
		super();
		layout = new DesignGridLayout(this);
		layout.labelAlignment(LabelAlignment.RIGHT);

		nameLabel = new JLabel();
		hitpointsLabel = new JLabel();

		layout.row().grid(new JLabel("Nimi :")).add(nameLabel);
		layout.row().grid(new JLabel("Osumapisteet")).add(hitpointsLabel);

	}

	public void addPlayerValue(String name, String value) {
		JLabel nameLabel = new JLabel(name + ":");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		layout.row().grid(nameLabel).add(new JLabel(value));
	}

	@Override
	public void setName(String name) {
		nameLabel.setText(name);
	}

	public void setHitpoints(int current, int max) {
		hitpointsLabel.setText(current + " / " + max);
	}

}
