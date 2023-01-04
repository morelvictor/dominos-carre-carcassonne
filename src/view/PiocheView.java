package view;

import java.util.Stack;

import model.*;

public class PiocheView extends TuileView {
    Stack<Tuile> pioche;

    public PiocheView(Stack<Tuile> pioche) {
        super(pioche.empty() ? new TuileDominos(false) : pioche.peek());
        this.pioche = pioche;
        update();
    }

    @Override
    public void update() {
        model = pioche.empty() ? new TuileDominos(false) : pioche.peek();
        super.update();
    }
}
