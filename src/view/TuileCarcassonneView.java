package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import model.*;

public class TuileCarcassonneView extends TuileView {
    TuileCarcassonne model;
    Graphics2D g2;

    public TuileCarcassonneView(TuileCarcassonne m) {
        super();
        model = m;
        model.getI();
        BufferedImage img = new BufferedImage(100,200,BufferedImage.TYPE_INT_ARGB);
        g2 = img.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(model.getI(), 0, 0, 100, 200, null);
        

        ImageIcon icon = new ImageIcon(img);
        
        JLabel j = new JLabel(icon);
        j.setVisible(true);
        add(j);
        update();
    }

    public class PartisanListener implements MouseListener {
        TuileCarcassonne tuile;
        TuileCarcassonneView tuileV;

        public PartisanListener() {
            tuile = TuileCarcassonneView.this.model;
            tuileV = TuileCarcassonneView.this;
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            
            if(e.getX()<tuileV.getWidth()*3/5 && e.getX()>tuileV.getWidth()*2/5 && e.getY()<tuileV.getHeight()*2/5){ 
                ((SideCarcassonne)tuile.getN()).setPartisan(true);
                ((SideCarcassonne)tuile.getW()).setPartisan(false); 
                ((SideCarcassonne)tuile.getS()).setPartisan(false);
                ((SideCarcassonne)tuile.getE()).setPartisan(false); 
                System.out.println("Nord");
            }
            else if(e.getX()<tuileV.getWidth()*3/5 && e.getX()>tuileV.getWidth()*2/5 && e.getY()>tuileV.getHeight()*3/5){
                ((SideCarcassonne) tuile.getS()).setPartisan(true); System.out.println("Sud");
                ((SideCarcassonne)tuile.getW()).setPartisan(false); 
                ((SideCarcassonne)tuile.getN()).setPartisan(false);
                ((SideCarcassonne)tuile.getE()).setPartisan(false); 
            }
            else if(e.getX()<tuileV.getWidth()*2/5 && e.getY()>tuileV.getHeight()*2/5 && e.getY()<tuileV.getHeight()*3/5){ 
                ((SideCarcassonne) tuile.getW()).setPartisan(true); System.out.println("Ouest");
                ((SideCarcassonne)tuile.getN()).setPartisan(false); 
                ((SideCarcassonne)tuile.getS()).setPartisan(false);
                ((SideCarcassonne)tuile.getE()).setPartisan(false); }

            else if(e.getX()>tuileV.getWidth()*3/5 && e.getY()>tuileV.getHeight()*2/5 && e.getY()>tuileV.getHeight()*3/5){
                 ((SideCarcassonne) tuile.getE()).setPartisan(true); System.out.println("Est");
                 ((SideCarcassonne)tuile.getW()).setPartisan(false); 
                 ((SideCarcassonne)tuile.getS()).setPartisan(false);
                 ((SideCarcassonne)tuile.getN()).setPartisan(false); 
            }
            
            System.out.println(e.getX() + "; " + e.getY());
            tuileV.update();

        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
        
    }
    

    @Override
    public void update() {
        if(model.getPlacer() != null) g2.setColor(model.getPlacer().getColor());
        if(((SideCarcassonne) model.getN()).getPartisan()) g2.drawArc(20, 5, 10, 10, 0, 360 ); g2.fillArc(20, 5, 10, 10, 0, 360 );
        if(((SideCarcassonne) model.getS()).getPartisan()) g2.drawArc(20, 85, 10, 10, 0, 360 ); g2.fillArc(20, 85, 10, 10, 0, 360 );
        if(((SideCarcassonne) model.getW()).getPartisan()) g2.drawArc(5, 20, 10, 10, 0, 360 ); g2.fillArc(5, 20, 10, 10, 0, 360 );
        if(((SideCarcassonne) model.getE()).getPartisan()) g2.drawArc(85, 20, 10, 10, 0, 360 ); g2.fillArc(85, 20, 10, 10, 0, 360 );
        System.out.println("update");
    }
}
