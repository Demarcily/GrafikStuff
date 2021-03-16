import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;

public class GrafikSimpel extends Canvas {
  public GrafikSimpel() {
    JFrame frame = new JFrame("Something");
    this.setSize(800, 600);
    frame.add(this);
    frame.pack();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void paint (Graphics g) {
    g.setColor(Color.black);
    g.fillRect(200,400,200,50);
    g.setColor(new Color(255, 127, 8));
    g.drawOval(200, 200, 50, 50);
    drawTree(g, 100, 200);
  }

  public void drawTree(Graphics g, int x, int y) {
    g.setColor(new Color(0, 128, 0));
    int[] xs = {0+x, 10+x , 20+x};
    int[] ys = {30+y, 0+y, 30+y};
    g.fillPolygon(xs, ys, 3);

    g.setColor(new Color(165, 42, 42 ));
    g.fillRect(7+x, 30+y, 6, 10);
  }

  public static void main(String[] args) {
    GrafikSimpel painting = new GrafikSimpel();
  }



}
