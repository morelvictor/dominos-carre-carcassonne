package view;

import java.awt.Color;
import java.util.Stack;

import model.*;

public class PiocheView extends TuileView {
    Stack<Tuile> pioche;
    TuileView tuile; 

    public PiocheView(Stack<Tuile> pioche) {
        this.pioche = pioche;
        update();
    }

    public void update() {
        removeAll();
        if(!pioche.empty()){
            if(pioche.peek() instanceof TuileDominos)
                tuile = new TuileDominosView((TuileDominos) pioche.peek());
            else
                tuile = new TuileCarcassonneView((TuileCarcassonne) pioche.peek());
        }else{
            tuile = new TuileColorView(Color.gray);
        }
        if(tuile != null)
            add(tuile);
        revalidate();
        repaint();
    }
}
