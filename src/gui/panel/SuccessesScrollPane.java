package gui.panel;

import java.awt.Dimension;
import javax.swing.JScrollPane;

import gui.IConfigGUI;

/**
 * Represents the successes list and sub-lists
 * @author yann
 *
 */
public class SuccessesScrollPane extends JScrollPane {
	
	private static final long serialVersionUID = -3936072590563661944L;
	
	/** Panel for sucesses list and sub-lists */
	private SuccessesPanel panel;
	
	/**
	 * Constructor of the tree panel
	 */
	public SuccessesScrollPane() {
		this.setPreferredSize(new Dimension(IConfigGUI.TREE_PANEL_WIDTH, IConfigGUI.TREE_PANEL_HEIGHT));
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.getVerticalScrollBar().setUnitIncrement(15);
		this.setViewportBorder(null);
		this.setBorder(null);
		
		panel = new SuccessesPanel();
		
		this.setViewportView(panel);
	}
}
