package gui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.label.AchievementLabel;

/**
 * Achievement mouse listener
 * @author yann
 *
 */
public class AchievementMouseListener implements MouseListener {

	/** Given achievement label */
	private AchievementLabel label;

	/**
	 * Constructor of the achievement mouse listener
	 */
	public AchievementMouseListener(AchievementLabel label) {
		this.label = label;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//label.setMouseClickedColor();
		label.setMouseHoverColor(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		label.setMouseHoverColor(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setMouseHoverColor(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		label.setMousePressedColor();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		label.setMouseHoverColor(true);
	}

	/**
	 * Getter for the given achievement label
	 * @return
	 */
	public AchievementLabel getLabel() {
		return label;
	}
}
