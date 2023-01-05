package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;


import java.awt.*;
import model.*;
import model.TuileCarcassonne.PartisanListener;

public class TuileView extends UpdatableView {
    Dimension preferredSize = new Dimension(100, 100);
    int x = 0;
    int y = 0;
    UpdatableView t;
    Tuile model;

    public TuileView(Tuile m) {
        model = m;
        resetT();
        add(t);
        }

    public TuileView() {
    }

    public void resetT() {
        if (model instanceof TuileDominos) {
            t = new TuileDominosView((TuileDominos) model);
        } else if (model instanceof TuileCarcassonne) {
            t = new TuileCarcassonneView((TuileCarcassonne) model);
            t.addMouseListener(new PartisanListener());
        }
        
        setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public TuileView(boolean isReachable) {
        add(new TuileDominosView((Boolean) isReachable));
    }

    @Override
    public void setPreferredSize(Dimension d) {
        preferredSize = d;
    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    @Override
    public void update() {
        remove(t);
        resetT();
        add(t);
        revalidate();
        repaint();
        System.out.println(getWidth() + "; " + getHeight());
    }

    
}
