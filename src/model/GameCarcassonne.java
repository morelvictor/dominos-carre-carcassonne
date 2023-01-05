package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import model.SideCarcassonne.Sike;

public class GameCarcassonne extends Game {

    public GameCarcassonne() {

        sac = new Stack<>();
        sac.push(new TuileCarcassonne(Sike.CHEMIN, Sike.CHEMIN, Sike.CHEMIN, Sike.CHEMIN, false));
        for (int i = 0; i < 3; i++) {
            sac.push(new TuileCarcassonne(Sike.PRE, Sike.CHEMIN, Sike.CHEMIN, Sike.CHEMIN, false));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.PRE, Sike.PRE, Sike.PRE, false));
            sac.push(new TuileCarcassonne(Sike.PRE, Sike.PRE, Sike.PRE, Sike.PRE, false));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.CHEMIN, Sike.PRE, Sike.CHEMIN, false));
        }
        sac.push(new TuileCarcassonne(Sike.VILLE, Sike.PRE, Sike.PRE, Sike.PRE, false));
        sac.push(new TuileCarcassonne(Sike.PRE, Sike.PRE, Sike.CHEMIN, Sike.CHEMIN, false));
        for (int i = 0; i < 8; i++) {
            sac.push(new TuileCarcassonne(Sike.PRE, Sike.PRE, Sike.CHEMIN, Sike.CHEMIN, false));
            sac.push(new TuileCarcassonne(Sike.CHEMIN, Sike.PRE, Sike.CHEMIN, Sike.PRE, false));
        }
        for (int i = 0; i < 3; i++) {
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.CHEMIN, Sike.CHEMIN, Sike.PRE, false));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.CHEMIN, Sike.CHEMIN, Sike.VILLE, false));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.CHEMIN, Sike.CHEMIN, Sike.CHEMIN, false));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.VILLE, Sike.PRE, Sike.VILLE, false));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.PRE, Sike.PRE, Sike.VILLE, false));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.PRE, Sike.CHEMIN, Sike.CHEMIN, false));
            sac.push(new TuileCarcassonne(Sike.PRE, Sike.VILLE, Sike.PRE, Sike.VILLE, false));
        }
        for (int i = 0; i < 2; i++) {
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.CHEMIN, Sike.CHEMIN, Sike.VILLE, true));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.VILLE, Sike.PRE, Sike.PRE, false));
            sac.push(new TuileCarcassonne(Sike.PRE, Sike.PRE, Sike.CHEMIN, Sike.PRE, false));
            sac.push(new TuileCarcassonne(Sike.PRE, Sike.VILLE, Sike.PRE, Sike.VILLE, true));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.VILLE, Sike.CHEMIN, Sike.VILLE, true));
            sac.push(new TuileCarcassonne(Sike.VILLE, Sike.PRE, Sike.PRE, Sike.VILLE, true));
        }
        sac.push(new TuileCarcassonne(Sike.VILLE, Sike.PRE, Sike.VILLE, Sike.PRE, false));
        sac.push(new TuileCarcassonne(Sike.VILLE, Sike.VILLE, Sike.CHEMIN, Sike.VILLE, false));
        sac.push(new TuileCarcassonne(Sike.VILLE, Sike.VILLE, Sike.PRE, Sike.VILLE, true));
        sac.push(new TuileCarcassonne(Sike.VILLE, Sike.VILLE, Sike.VILLE, Sike.VILLE, true));

        Collections.shuffle(sac);
        players = new ArrayList<>();
        players.add(new Player("Victor"));
        plateau = new Plateau(sac.pop());
    }

    public GameCarcassonne(ArrayList<Player> players) {
        this();
        this.players = players;
    }
}
