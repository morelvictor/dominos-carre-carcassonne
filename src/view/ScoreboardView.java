package view;

import javax.swing.*;
import java.util.ArrayList;
import model.Player;
import model.Game;
import java.util.Collections;

public class ScoreboardView extends JPanel {
	Game game;
	ArrayList<Player> players;

	public ScoreboardView(ArrayList<Player> p, Game g) {
		super();
		players = new ArrayList<>();
		game = g;
		for (Player pl : p) {
			players.add(pl);
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		update();
	}

	public void update() {
		Collections.sort(players);
		removeAll();
		for (Player p : players) {
			JLabel label = new JLabel(p.getPoints() + " - " + p.getName() + (!game.players.contains(p) ? " (abandonné)" : ""));
			label.setOpaque(true);
			label.setBackground(p.getColor());
			add(label);
		}
		revalidate();
		repaint();
	}
}
