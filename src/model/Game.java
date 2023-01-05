package model;

import java.util.Stack;
import java.util.ArrayList;

public class Game {

	public Plateau plateau;
	public Stack<Tuile> sac;
	public ArrayList<Player> players;
	int currentPlayer = -1;
	Tuile lastTuile;

	public void load() {
		plateau.put(new Coords(0, 0), sac.pop());
		iaLoader();
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Stack<Tuile> getSac() {
		return sac;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public Player nextPlayer() {
		if (players.size() > 0) {
			currentPlayer += 1;
			System.out.println("Nombre de joueurs: " + players.size());
			System.out.println(players.get(currentPlayer % players.size()));
			return players.get(currentPlayer % players.size());
		}
		return null;
	}

	public Player peekPlayer() {
		if (players.size() > 0) {
			return players.get((currentPlayer + 1) % players.size());
		}
		return null;
	}

	public int place(Coords c) {
		int p = -1;
		if (players.size() != 0) {
			if (!sac.empty()) {
				p = plateau.place(c, sac.peek());
				if (p > -1) {
					Player current = nextPlayer();
					current.addPoints(p);
					sac.pop().setPlacer(current);
					System.out.println(current.getName() + " -> " + current.getPoints());
					iaLoader();
				}
			}
		}
		return p;
	}

	public void iaLoader() {
		Player next = peekPlayer();
		if (next.isAi())
			ai();
		//currentPlayer = (((currentPlayer - 1) % players.size()) + players.size()) % players.size();
	}

	public void ai() {
		System.out.println("Ia joue");
		if(sac.empty())
			return;
		for (int ii = 0; ii < 4; ii++) {
			for (int x = plateau.min_x - 1; x <= plateau.max_x + 1; x++) {
				for (int y = plateau.min_y - 1; y <= plateau.max_y + 1; y++) {
					Coords c = new Coords(x, y);
					System.out.println(c);
					if (plateau.isValid(c, sac.peek()) > -1) {
						place(c);
						System.out.println("ok");
						return;
					}
				}
			}
			sac.peek().rotate();
		}
		System.out.println(sac.peek());
		defausser();
	}

	public void defausser() {
		if (!sac.empty()) {
			sac.pop();
			nextPlayer();
			iaLoader();
		}else{
			System.out.println("Yapu");
		}
		lastTuile = null;
	}

	public void rotatePioche() {
		if(!sac.empty())
			sac.peek().rotate();
		else
			System.out.println("yapu");
	}

	public Tuile getLastTuile() {
		return lastTuile;
	}

	public void setLastTuile(Tuile lastTuile) {
		this.lastTuile = lastTuile;
	}
	
}
