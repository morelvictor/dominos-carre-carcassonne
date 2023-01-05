package view;

import javax.swing.*;

import java.awt.*;
import model.*;

public class TuileView extends JPanel {
    Dimension preferredSize = new Dimension(100, 100);
    Tuile model;

    public TuileView(Tuile m) {
        model = m;
    }

    public TuileView() {
    }

    @Override
    public void setPreferredSize(Dimension d) {
        preferredSize = d;
    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

}
