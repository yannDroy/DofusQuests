package gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import database.DatabaseLoad;
import domain.Achievement;
import domain.ApplicationData;
import domain.Player;

/**
 * Choice panel with players checkboxes
 * @author yann
 *
 */
public class ChoicePanel extends JPanel {

	private static final long serialVersionUID = -5845995315955848331L;

	/**
	 * Choice panel constructor
	 * @param achievement the achievement to edit
	 */
	public ChoicePanel(Achievement achievement, final Map<Integer, Integer> checks) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ApplicationData data = ApplicationData.getInstance();
		Map<Integer, Player> players = data.getPlayers();
		List<Integer> who = DatabaseLoad.getWhoAchieved(achievement.getId());
		
		final List<JCheckBox> boxes = new ArrayList<JCheckBox>();
		
		for(final Map.Entry<Integer, Player> player : players.entrySet()){
			final JCheckBox box = new JCheckBox(player.getValue().getName());
			
			if(who.contains(player.getValue().getId())){
				box.setSelected(true);
				checks.put(player.getValue().getId(), 1);
			}else{
				checks.put(player.getValue().getId(), -1);
			}
			
			box.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(box.isSelected())
						checks.put(player.getValue().getId(), 1);
					else
						checks.put(player.getValue().getId(), 0);
				}
			});
			
			this.add(box);
			
			boxes.add(box);
		}
		
		final JToggleButton all = new JToggleButton("Tout sélectionner");
		
		all.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(all.isSelected()){
					all.setText("Tout désélectionner");
					for(JCheckBox b : boxes)
						b.setSelected(true);
					for(Map.Entry<Integer, Integer> check : checks.entrySet())
						checks.put(check.getKey(), 1);
				}else{
					all.setText("Tout sélectionner");
					for(JCheckBox b : boxes)
						b.setSelected(false);
					for(Map.Entry<Integer, Integer> check : checks.entrySet())
						checks.put(check.getKey(), 0);
				}
			}
		});
		
		if(!checks.containsValue(0) && !checks.containsValue(-1))
			all.doClick();
		
		this.add(all);
	}
}
