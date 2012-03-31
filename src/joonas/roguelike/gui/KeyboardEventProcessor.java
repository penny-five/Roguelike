package joonas.roguelike.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardEventProcessor implements KeyListener {
	private static final KeyboardEventProcessor INSTANCE = new KeyboardEventProcessor();

	private KeyboardEventProcessor() {

	}

	public static KeyboardEventProcessor getInstance() {
		return INSTANCE;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		if (isDirectionKey(e.getKeyChar())) {
			notifyPlayerMovement(key);
		}
	}

	private static boolean isDirectionKey(char keyChar) {
		return keyChar >= '1' && keyChar <= '9';
	}

	private void notifyPlayerMovement(char key) {
		MovementDirection direction = MovementDirection.forKey(key);
		if (direction != null) {
			PlayerMovementHandler.getInstance().handleMovement(direction);
		}
	}
}
