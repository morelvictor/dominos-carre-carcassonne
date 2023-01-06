package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.Plateau;
import model.TuileCarcassonne;
import model.TuileDominos;
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
                    if (model.get(coord) instanceof TuileDominos) {
                        tuile = new TuileDominosView((TuileDominos) model.get(coord));
                    } else {
                        tuile = new TuileCarcassonneView((TuileCarcassonne) model.get(coord));
                        tuile.addMouseListener(new PartisanListener((TuileCarcassonneView) tuile, view));
                    }
                } else {
                    if (model.isReachable(coord)) {
                        tuile = new TuileView();
                        if (view != null) {
                            tuile.addMouseListener(new CustomListener(view, new Coords(x, y)));
                        }
                    } else {
                        tuile = new TuileColorView(Color.gray);
                    }
                }
                add(tuile);
            }
        }
        revalidate();
        repaint();
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

    public class PartisanListener implements MouseListener {

        TuileCarcassonneView tuile;
        GameView carc;

        public PartisanListener(TuileCarcassonneView t, GameView g) {
            tuile = t;
            carc = g;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (tuile.getModel() == carc.getGame().getLastTuile()) {
                if(carc.getGame().peekPlayer().getPartisans() > 0){
                    if(tuile.model.getPartisan() == null)
                        carc.getGame().peekPlayer().removePartisan();
                    tuile.setPos((int) (((float) e.getX())*(1000f/((float) tuile.getWidth()))), (int) (((float) e.getY())*(1000f/((float) tuile.getHeight()))));
                    tuile.getModel().setPartisan(new Coords((int) (((float) e.getX())*(1000f/((float) tuile.getWidth()))), (int) (((float) e.getY())*(1000f/((float) tuile.getHeight())))));
                    tuile.repaint();
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }

}
