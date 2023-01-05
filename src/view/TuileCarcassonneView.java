package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.image.BufferedImage;
import model.Tuile;
import model.TuileCarcassonne;

public class TuileCarcassonneView extends TuileView {
    TuileCarcassonne model;

    public TuileCarcassonneView(TuileCarcassonne m) {
        super();
        model = m;
/* 
        BufferedImage img = model.getI(); new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, 100, 100, null);
        g2.dispose();

        ImageIcon icon = new ImageIcon(img);

        JLabel j = new JLabel(icon);
        j.setVisible(true);
        add(j);
*/
    }

    @Override public void paintComponent(Graphics g) {
        //g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(model.getI(), 0, 0, getWidth(), getHeight(), null);
        g.dispose();
    }

    public void update(){}

}
