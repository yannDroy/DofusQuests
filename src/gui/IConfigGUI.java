package gui;

import java.awt.Color;

public interface IConfigGUI {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;
	
	public static final int POSITION_X = 50;
	public static final int POSITION_Y = 50;
	
	public static final int TREE_PANEL_WIDTH = WIDTH / 3;
	public static final int TREE_PANEL_HEIGHT = HEIGHT;
	
	public static final int RIGHT_PANEL_WIDTH = 2 * WIDTH / 3;
	public static final int RIGHT_PANEL_HEIGHT = HEIGHT;
	
	public static final int SUCCESS_WIDTH = TREE_PANEL_WIDTH;
	public static final int SUCCESS_HEIGHT = HEIGHT / 18;
	
	public static final int SUBSUCCESS_WIDTH = TREE_PANEL_WIDTH;
	public static final int SUBSUCCESS_HEIGHT = HEIGHT / 20;
	
	public static final int CHALLENGE_WIDTH = RIGHT_PANEL_WIDTH;
	public static final int CHALLENGE_HEIGHT = HEIGHT / 9;
	
	public static final int QUEST_WIDTH = RIGHT_PANEL_WIDTH;
	public static final int QUEST_HEIGHT = HEIGHT / 18;
	
	public static final int SUBQUEST_WIDTH = RIGHT_PANEL_WIDTH;
	public static final int SUBQUEST_HEIGHT = HEIGHT / 22;
	
	public static final int TITLE_WIDTH = RIGHT_PANEL_WIDTH;
	public static final int TITLE_HEIGHT = HEIGHT / 4;
	
	public static final int SEARCH_PANEL_WIDTH = RIGHT_PANEL_WIDTH;
	public static final int SEARCH_PANEL_HEIGHT = HEIGHT / 16;
	
	public static final int CHALLENGES_PANEL_WIDTH = RIGHT_PANEL_WIDTH;
	public static final int CHALLENGES_PANEL_HEIGHT = RIGHT_PANEL_HEIGHT - TITLE_HEIGHT - SEARCH_PANEL_HEIGHT;
	
	public static final int SEARCHBAR_WIDTH = SEARCH_PANEL_WIDTH / 3;
	public static final int SEARCHBAR_HEIGHT = SEARCH_PANEL_HEIGHT / 2;
	
	public static final Color SEARCHBAR_BACKGROUND_COLOR = new Color(50, 110, 75);
	public static final Color SEARCHBAR_FONT_COLOR = new Color(0, 255, 0);
	public static final Color SEARCHLABEL_FONT_COLOR = new Color(250, 230, 80);
	
	public static final Color TITLE_BACKGROUND_COLOR = new Color(70, 70, 70);
	public static final Color[] TITLE_COLORS = {
			new Color(255, 45, 75), // 1
			new Color(255, 100, 0),  // 2
			new Color(255, 45, 75),  // 3
			new Color(20, 180, 140), // 4
			new Color(20, 180, 140), // 5
			new Color(20, 180, 140), // 6
			new Color(20, 180, 140), // 7
			new Color(255, 45, 75),  // 8
			new Color(255, 45, 75),  // 9
			new Color(255, 45, 75),  // 10
			new Color(20, 180, 140), // 11
			new Color(255, 45, 75),  // 12
			new Color(255, 45, 75),  // 13
			new Color(240, 220, 80), // 14
			new Color(240, 220, 80), // 15
			new Color(20, 180, 140), // 16
			new Color(20, 180, 140), // 17
			new Color(255, 45, 75), // 18
			new Color(255, 45, 75), // 19
			new Color(20, 180, 140), // 20
			new Color(255, 45, 75), // 21
			new Color(240, 220, 80), // 22
			new Color(255, 45, 75), // 23
			new Color(255, 45, 75), // 24
			new Color(20, 180, 140), // 25
			new Color(20, 180, 140), // 26
			new Color(20, 180, 140), // 27
	};
	
	public static final Color BACKGROUND_COLOR_WINDOW = new Color(100, 100, 100);
	public static final Color BACKGROUND_COLOR_TREE_PANEL = new Color(40, 40, 40);
	public static final Color BACKGROUND_COLOR_RIGHT_PANEL = new Color(100, 100, 100);
	public static final Color BACKGROUND_COLOR_CHALLENGE_PANEL = new Color(50, 50, 50);
	public static final Color BACKGROUND_COLOR_SEARCH_PANEL = new Color(60, 120, 85);

	public static final Color SUCCESS_BACKGROUND_COLOR = new Color(100, 60, 25);
	public static final Color SUCCESS_BACKGROUND_CLICK_COLOR = new Color(220, 150, 70);
	public static final Color SUCCESS_BACKGROUND_OPEN_COLOR = new Color(110, 110, 110);
	public static final Color SUCCESS_BACKGROUND_HOVER_COLOR = new Color(180, 120, 50);
	public static final Color SUCCESS_FONT_COLOR = new Color(240, 240, 240);
	public static final Color SUCCESS_FONT_CLICK_COLOR = new Color(250, 250, 0);
	public static final Color SUCCESS_FONT_OPEN_COLOR = new Color(250, 250, 0);
	public static final Color SUCCESS_FONT_HOVER_COLOR = new Color(240, 240, 240);
	
	public static final Color SUBSUCCESS_BACKGROUND_COLOR = new Color(90, 90, 90);
	public static final Color SUBSUCCESS_BACKGROUND_CLICK_COLOR = new Color(150, 150, 150);
	public static final Color SUBSUCCESS_BACKGROUND_OPEN_COLOR = new Color(120, 120, 120);
	public static final Color SUBSUCCESS_BACKGROUND_HOVER_COLOR = new Color(130, 130, 130);
	public static final Color SUBSUCCESS_BACKGROUND_FINISHED_COLOR = new Color(30, 160, 60);
	public static final Color SUBSUCCESS_FONT_COLOR = new Color(220, 220, 220);
	public static final Color SUBSUCCESS_FONT_CLICK_COLOR = new Color(220, 220, 220);
	public static final Color SUBSUCCESS_FONT_OPEN_COLOR = new Color(240, 240, 0);
	public static final Color SUBSUCCESS_FONT_HOVER_COLOR = new Color(220, 220, 220);
	public static final Color SUBSUCCESS_FONT_FINISHED_COLOR = new Color(220, 220, 220);
	
	public static final Color CHALLENGE_BACKGROUND_COLOR = new Color(170, 130, 80);
	public static final Color CHALLENGE_BACKGROUND_CLICK_COLOR = new Color(200, 190, 180);
	public static final Color CHALLENGE_BACKGROUND_OPEN_COLOR = new Color(120, 120, 120);
	public static final Color CHALLENGE_BACKGROUND_HOVER_COLOR = new Color(210, 160, 90);
	public static final Color CHALLENGE_BACKGROUND_FINISHED_COLOR = new Color(30, 160, 60);
	public static final Color CHALLENGE_FONT_COLOR = new Color(10, 10, 100);
	public static final Color CHALLENGE_FONT_CLICK_COLOR = new Color(10, 10, 100);
	public static final Color CHALLENGE_FONT_OPEN_COLOR = new Color(0, 100, 250);
	public static final Color CHALLENGE_FONT_HOVER_COLOR = new Color(10, 10, 100);
	public static final Color CHALLENGE_FONT_FINISHED_COLOR = new Color(10, 10, 100);
	
	public static final Color QUEST_BACKGROUND_COLOR = new Color(140, 140, 140);
	public static final Color QUEST_BACKGROUND_CLICK_COLOR = new Color(210, 210, 210);
	public static final Color QUEST_BACKGROUND_OPEN_COLOR = new Color(160, 160, 160);
	public static final Color QUEST_BACKGROUND_HOVER_COLOR = new Color(180, 180, 180);
	public static final Color QUEST_BACKGROUND_FINISHED_COLOR = new Color(30, 160, 60);
	public static final Color QUEST_FONT_COLOR = new Color(10, 10, 80);
	public static final Color QUEST_FONT_CLICK_COLOR = new Color(10, 10, 80);
	public static final Color QUEST_FONT_OPEN_COLOR = new Color(250, 45, 75);
	public static final Color QUEST_FONT_HOVER_COLOR = new Color(10, 10, 80);
	public static final Color QUEST_FONT_FINISHED_COLOR = new Color(10, 10, 80);
	
	public static final Color SUBQUEST_BACKGROUND_COLOR = new Color(80, 80, 80);
	public static final Color SUBQUEST_BACKGROUND_CLICK_COLOR = new Color(140, 140, 140);
	public static final Color SUBQUEST_BACKGROUND_HOVER_COLOR = new Color(110, 110, 110);
	public static final Color SUBQUEST_BACKGROUND_FINISHED_COLOR = new Color(30, 160, 60);
	public static final Color SUBQUEST_FONT_COLOR = new Color(10, 10, 50);
	public static final Color SUBQUEST_FONT_CLICK_COLOR = new Color(10, 10, 50);
	public static final Color SUBQUEST_FONT_HOVER_COLOR = new Color(10, 10, 50);
	public static final Color SUBQUEST_FONT_FINISHED_COLOR = new Color(10, 10, 50);
	
	public static final Color BLACK_BORDER_COLOR = new Color(40, 40, 40);
	public static final Color GREY_BORDER_COLOR = new Color(50, 50, 50);
	
	public static final String FONT_VERDANA = "Verdana";
	public static final String FONT_FREE_SERIF = "FreeSerif";
	public static final String FONT_ARTEMISIA = "GFS Artemisia";
	public static final String FONT_THEOKRITOS = "GFS Theokritos";
	public static final String FONT_LOBSTER = "Lobster Two";
	public static final String FONT_GYRECHORUS = "TeXGyreChorus";
	
	public static final int LITTLE_FONT_SIZE = 17;
	public static final int MIDDLE_FONT_SIZE = 20;
	public static final int BIG_FONT_SIZE = 22;
	public static final int HUGE_FONT_SIZE = 40;
}
