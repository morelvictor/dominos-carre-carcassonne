package view;

import java.awt.*;


import model.Coords;
import model.TuileCarcassonne;

public class TuileCarcassonneView extends TuileView {
    TuileCarcassonne model;


    public TuileCarcassonneView(TuileCarcassonne m) {
        super();
        model = m;
    }

    void setPos(int x, int y){
        model.setPartisan(new Coords(x, y));
    }


    @Override public void paintComponent(Graphics g) {
        g.drawImage(model.getI(), 0, 0, getWidth(), getHeight(), null);
        
        if(model.getPlacer()!= null) g.setColor(model.getPlacer().getColor());
        if(model.getPartisan() != null) {
            int rayon = this.getWidth()/20;
            g.fillOval(model.getPartisan().getX() - rayon, model.getPartisan().getY() - rayon, rayon * 2, rayon * 2);
        }
        
        g.dispose();
        update();
    }

    public TuileCarcassonne getModel() {
        return model;
    }

    public void update(){
        repaint();  
    }
}
