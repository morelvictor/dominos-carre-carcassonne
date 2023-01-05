package view;

import java.util.Stack;

import model.*;

public class PiocheView extends TuileView {
    Stack<Tuile> pioche;
    TuileView tuile; 

    public PiocheView(Stack<Tuile> pioche) {
        //super(pioche.empty() ? new TuileDominos(false) : pioche.peek());
        this.pioche = pioche;
        
        /*if(!pioche.empty()){
            if(pioche.peek() instanceof TuileDominos)
                tuile = new TuileDominosView((TuileDominos) pioche.peek());
            else
                tuile = new TuileCarcassonneView((TuileCarcassonne) pioche.peek());
        }
        if(tuile != null)
            add(tuile);
            */
        update();
    }

    public void update() {
        removeAll();
        if(!pioche.empty()){
            if(pioche.peek() instanceof TuileDominos)
                tuile = new TuileDominosView((TuileDominos) pioche.peek());
            else
                tuile = new TuileCarcassonneView((TuileCarcassonne) pioche.peek());
        }
        if(tuile != null)
            add(tuile);
        revalidate();
        repaint();
        /*
        if(tuile !=  null){
        model = pioche.empty() ? new TuileDominos(false) : pioche.peek();
        if(tuile instanceof TuileCarcassonneView)
            ((TuileCarcassonneView) tuile).update();
        else
            ((TuileDominosView) tuile).update();
        }
        */
    }
}
