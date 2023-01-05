package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import model.Player;

public class PlayerSelector extends JPanel {
	ArrayList<Player> players;

	JTextField textField = new JTextField();
	JButton addPlayerButton = new JButton("Ajouter");
	JPanel listView = new JPanel();

	public PlayerSelector() {

		players = new ArrayList<>();
		players.add(new Player("Victor"));
		listView.setLayout(new BoxLayout(listView, BoxLayout.Y_AXIS));

		addPlayerButton.addActionListener((ActionEvent e) -> {
			if (!textField.getText().equalsIgnoreCase("")) {
				Player n = new Player(textField.getText());
				textField.setText("");
				players.add(n);
				update();
			}
		});

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		add(textField);
		add(addPlayerButton);
		add(listView);
		update();
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void update() {
		listView.removeAll();
		for (Player p : players) {
			listView.add(new PlayerRow(p));
		}
		listView.revalidate();
		listView.repaint();
	}

	public class PlayerRow extends JPanel {
		JButton remove = new JButton("Remove");
		JCheckBox ai = new JCheckBox("ia");
		Player player;

		public PlayerRow(Player p) {
			player = p;

			remove.addActionListener((ActionEvent e) -> {
				players.remove(p);
				PlayerSelector.this.update();
			});

			ai.addActionListener((ActionEvent e) -> {
				player.setAi(ai.isSelected());
			});

			setLayout(new FlowLayout());

			add(remove);
			add(ai);
			add(new JLabel(player.getName()));
		}
	}
}
