package gui.label;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import gui.IConfigGUI;

public class TitleLabel extends JLabel {

	private static final long serialVersionUID = 7250284598859781593L;

	/**
	 * Constructor of the title label
	 */
	public TitleLabel(String title) {
		super(title);
		this.setOpaque(false);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setMinimumSize(new Dimension(IConfigGUI.TITLE_WIDTH, IConfigGUI.TITLE_HEIGHT));
		this.setMaximumSize(new Dimension(IConfigGUI.TITLE_WIDTH, IConfigGUI.TITLE_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.TITLE_WIDTH, IConfigGUI.TITLE_HEIGHT));
		this.setBackground(IConfigGUI.TITLE_BACKGROUND_COLOR);
		this.setBorder(new MatteBorder(0, 0, 3, 0, IConfigGUI.BLACK_BORDER_COLOR));
		this.setFont(new Font(IConfigGUI.FONT_LOBSTER, 1, IConfigGUI.HUGE_FONT_SIZE * 2));
		
		int nbPictures = 16;
		int wp = (int) (Math.random() * nbPictures) + 1;
		
		this.setForeground(IConfigGUI.TITLE_COLORS[wp - 1]);
		this.setIcon(new ImageIcon("resources/wallpaper/wp" + wp + "_cropped_resized.jpg"));
		this.setIconTextGap(- IConfigGUI.TITLE_WIDTH * 5 / 6);
	}
	
	/**
	 * Changes the title
	 * @param title
	 */
	public void setTitle(String title) {
		this.setText(title);
	}
}
