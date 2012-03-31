package joonas.roguelike.game;

import java.awt.Color;

public class Appearance {
	private static final Color COLOR_TRANSPARENT = new Color(Color.TRANSLUCENT);
	public static final Appearance INVISIBLE = new Appearance(' ', COLOR_TRANSPARENT, COLOR_TRANSPARENT);
	private final char graphic;
	private final Color color;
	private final Color backgroundColor;

	public Appearance(char graphic, Color color) {
		this.graphic = graphic;
		this.color = color;
		backgroundColor = COLOR_TRANSPARENT;
	}

	public Appearance(char graphic, Color color, Color backgroundColor) {
		this.graphic = graphic;
		this.color = color;
		this.backgroundColor = backgroundColor;
	}

	public char getGraphic() {
		return graphic;
	}

	public Color getGraphicColor() {
		return color;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}
}
