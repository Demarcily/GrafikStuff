import javax.swing.*;
import java.awt.*;

public class GrafikTask extends Canvas {
  public GrafikTask() {
    JFrame frame = new JFrame("Something");
    this.setSize(800, 600);
    frame.add(this);
    frame.pack();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void paint (Graphics g) {
    drawHouse(g, 100, 100);
    drawHouse(g, 200, 200);
    drawMan(g, 100, 200);
    drawTree2(g, 200, 200);
  }

  public void drawHouse(Graphics g, int x, int y) {
    g.setColor(new Color(156, 64, 42));
    g.fillRect(20+x, 50+y, 200, 150);

    g.setColor(new Color(127, 13, 13));
    int [] xs = {0+x, 120+x, 240+x};
    int [] ys = {50+y, 0+y, 50+y};
    g.fillPolygon(xs, ys, 3);

    /* Outlines */
    g.setColor(Color.black);
    g.drawRect(20+x, 50+y, 200, 150);
    g.drawPolygon(xs, ys , 3);

  }

  public void drawMan(Graphics g, int x, int y) {

  }

  public void drawTree2(Graphics g, int x, int y) {

  }


  public static void main (String[]args) {
    GrafikTask Task = new GrafikTask();
  }

}
