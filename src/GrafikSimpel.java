import javax.swing.*;
import java.awt.*;

public class GrafikSimpel extends Canvas {
  private int width = 800;
  private int height = 600;

  private int houseX, houseY;
  private int houseVX, houseVY;

  public GrafikSimpel() {
    JFrame frame = new JFrame("Something");
    this.setSize(800, 600);
    frame.add(this);
    frame.pack();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    houseX = 300;
    houseY = 150;
    houseVX = 1;
    houseVY = 1;
  }

  public void update() {
    houseX += houseVX;
    if (houseX > width) {
      houseVX = -1;
    }
    if (houseX < 0) {
      houseVX = 1;
    }
  }


  public void paint (Graphics g) {
    update();
    drawHouse(g, houseX, houseY);
    drawTree(g, 100, 200);

    repaint();
  }

  public void drawTree(Graphics g, int x, int y) {
    g.setColor(new Color(0, 128, 0));
    int[] xs = {0+x, 10+x , 20+x};
    int[] ys = {30+y, 0+y, 30+y};
    g.fillPolygon(xs, ys, 3);

    g.setColor(new Color(165, 42, 42 ));
    g.fillRect(7+x, 30+y, 6, 10);

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
  public static void main(String[] args) {
    GrafikSimpel painting = new GrafikSimpel();
  }



}
