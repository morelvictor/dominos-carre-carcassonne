package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.image.BufferedImage;
import model.SideCarcassonne;
import model.TuileCarcassone;

public class TuileCarcassonneView extends TuileView {
    TuileCarcassone model;
    Graphics2D g2;

    public TuileCarcassonneView(TuileCarcassone m) {
        super();
        model = m;
        model.getI();
        BufferedImage img = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
        g2 = img.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(model.getI(), 0, 0, 100, 100, null);
        

        ImageIcon icon = new ImageIcon(img);
        
        JLabel j = new JLabel(icon);
        j.setVisible(true);
        add(j);
    }

    

    @Override
    public void update() {
        g2.setColor(model.getPlacer().getColor());
        if(((SideCarcassonne) model.getN()).getPartisan()) g2.drawArc(20, 5, 10, 10, 0, 360 ); g2.fillArc(20, 5, 10, 10, 0, 360 );
        if(((SideCarcassonne) model.getS()).getPartisan()) g2.drawArc(20, 85, 10, 10, 0, 360 ); g2.fillArc(20, 85, 10, 10, 0, 360 );
        if(((SideCarcassonne) model.getW()).getPartisan()) g2.drawArc(5, 20, 10, 10, 0, 360 ); g2.fillArc(5, 20, 10, 10, 0, 360 );
        if(((SideCarcassonne) model.getE()).getPartisan()) g2.drawArc(85, 20, 10, 10, 0, 360 ); g2.fillArc(85, 20, 10, 10, 0, 360 );
        System.out.println("update");
    }
}
