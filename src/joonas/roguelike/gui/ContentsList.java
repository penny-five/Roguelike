package joonas.roguelike.gui;

import java.awt.Color;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public abstract class ContentsList<E> extends JList<E> {
	public interface OnPopUpMenuRequestedListener {
		public void onPopUpMenuRequested(Point location, int index);
	}
	
	private static final long serialVersionUID = 7900313517855772308L;
	private OnPopUpMenuRequestedListener listener;
	
	public ContentsList() {
		//setCellRenderer(new TileContentsListCell());
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setSelectionBackground(Color.RED);
		setAlignmentX(JList.LEFT_ALIGNMENT);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopUpMenuForEvent(e);
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopUpMenuForEvent(e);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	public void setOnPopUpMenuRequestedListener(OnPopUpMenuRequestedListener listener) {
		this.listener = listener;
	}
	
	private void showPopUpMenuForEvent(MouseEvent e) {
		int index = locationToIndex(e.getPoint());
		if (index != -1 && listener != null) {
			listener.onPopUpMenuRequested(e.getPoint(), index);
		}
	}
}
