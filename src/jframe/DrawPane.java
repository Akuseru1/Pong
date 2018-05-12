package jframe;

import java.awt.Graphics;
import javax.swing.JPanel;

class DrawPane extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        g.drawOval(40, 40, 60, 60);
        g.drawRect(200, 100, 200, 100);
    }
}
