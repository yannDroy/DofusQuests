package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import domain.Achievement;
import gui.IConfigGUI;
import gui.panel.RightPanel;
import gui.panel.SuccessesScrollPane;

/**
 * Main window of the software
 * @author yann
 *
 */
public class GUIWindow extends JFrame implements IConfigGUI {

	private static final long serialVersionUID = 6589105754362849568L;

	/** Window instance */
	private static GUIWindow instance = new GUIWindow();
	
	/** Tree panel */
	private SuccessesScrollPane successesScrollPane;
	
	/** Details panel */
	private RightPanel rightPanel;
	
	/**
	 * Window constructor
	 */
	private GUIWindow() {
		initPanels();
		initWindow();
	}
	
	/**
	 * Initializes the window
	 */
	private void initWindow() {
		this.setTitle("Succès Dofus");
		this.setName("Succès Dofus");
		
	    this.setMinimumSize(new Dimension(IConfigGUI.WIDTH, IConfigGUI.HEIGHT));
	    this.setMaximumSize(new Dimension(IConfigGUI.WIDTH, IConfigGUI.HEIGHT));
	    this.setPreferredSize(new Dimension(IConfigGUI.WIDTH, IConfigGUI.HEIGHT));
	    this.setLocation(IConfigGUI.POSITION_X, IConfigGUI.POSITION_Y);
	    this.setResizable(false);
	    this.setVisible(true);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/favicon.png"));
	    
	    Container container = this.getContentPane();
	    container.add(successesScrollPane, BorderLayout.WEST);
	    container.add(rightPanel, BorderLayout.EAST);
	    
	    this.pack();
	}
	
	private void initPanels() {
		successesScrollPane = new SuccessesScrollPane();
		rightPanel = new RightPanel();
	}
	
	/**
	 * Getter for the window instance
	 * @return the window instance
	 */
	public static GUIWindow getInstance() {
		return instance;
	}

	/**
	 * Getter for the right panel
	 * @return the right panel
	 */
	public RightPanel getRightPanel() {
		return rightPanel;
	}
	
	/**
	 * Clears the challenges panel
	 */
	public void clearChallenges() {
		//TODO ameliorer
		getRightPanel().getChallengesScrollPane().getChallengesPanel().clearPanel();
		getRightPanel().getChallengesScrollPane().setViewport(true);
	}
	
	/**
	 * Updates the challenges panel
	 * @param subsuccess the opened subsuccess
	 */
	public void updateChallenges(Achievement subsuccess, boolean scroll) {
		//TODO ameliorer
		getRightPanel().getChallengesScrollPane().getChallengesPanel().buildPanel(subsuccess);
		getRightPanel().getChallengesScrollPane().setViewport(scroll);
	}
	
	public void clearSearch() {
		//TODO ameliorer
		getRightPanel().getSearchPanel().getSearchField().clearSearch();
	}
}
