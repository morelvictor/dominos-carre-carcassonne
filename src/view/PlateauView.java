package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.Plateau;
import model.TuileCarcassone;
import model.Coords;

public class PlateauView extends JPanel {
    Plateau model;
    GameView view;

    public PlateauView(GameView v, Plateau model) {
        super();
        this.model = model;
        this.view = v;
        update();
    }

    public void update() {
        removeAll();
        setLayout(new GridLayout(Math.abs(model.max_y + 1 - (model.min_y - 1)) + 1,
                Math.abs(model.max_x + 1 - (model.min_x - 1)) + 1));
        for (int y = model.min_y - 1; y <= model.max_y + 1; y++) {
            for (int x = model.min_x - 1; x <= model.max_x + 1; x++) {
                Coords coord = new Coords(x, y);
                TuileView tuile;
                if (!model.isFree(coord)) {
                    
                    tuile = new TuileView(model.get(coord));
                    
                    if(model.get(coord) instanceof TuileCarcassone){
                        tuile.addMouseListener(new PartisanListener(view, new Coords(x, y), (TuileCarcassone) model.get(coord), tuile));
                       
                    }
                } else {
                    if (model.isReachable(coord)) {
                        tuile = new TuileView(true);
                        if (view != null) {
                            tuile.addMouseListener(new CustomListener(view, new Coords(x, y)));
                        }
                    } else
                        tuile = new TuileView(false);
                }
                tuile.x = x;
                tuile.y = y;
                add(tuile);
            }
        }
        revalidate();
        repaint();
    }

    public class PartisanListener implements MouseListener {
        GameView dominos;
        Coords coord;
        TuileCarcassone tuile;
        TuileView tuileV;

        public PartisanListener(GameView g, Coords c, TuileCarcassone t, TuileView tv) {
            dominos = g;
            coord = c;
            tuile = t;
            tuileV = tv;
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            
            
            if(tuile.getTab()[tuile.getPos() % tuile.getTab().length] != null){
                tuile.getTab()[tuile.getPos() % tuile.getTab().length].setPartisan(false);
            }

            tuile.setPos(tuile.getPos() + 1);
            
            if(tuile.getTab()[tuile.getPos() % tuile.getTab().length] != null){
                tuile.getTab()[tuile.getPos() % tuile.getTab().length].setPartisan(true);
            }
            
            if(tuileV instanceof TuileCarcassonneView)  ((TuileCarcassonneView) tuileV).update();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    public class CustomListener implements MouseListener {
        GameView dominos;
        Coords coord;

        public CustomListener(GameView g, Coords c) {
            dominos = g;
            coord = c;
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            dominos.place(coord);
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }
}
