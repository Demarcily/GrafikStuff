import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Grafik extends Canvas implements Runnable {
  private int width = 800;
  private int height = 600;

  private int houseX, houseY;
  private int houseVX, houseVY;
  private int TreeX, TreeY;


  private Thread thread;
  int fps = 30;
  private boolean isRunning;

  private BufferStrategy bs;
  //private BufferedImage image;

  public Grafik() {
    JFrame frame = new JFrame("Stg");
    this.setSize(800, 600);
    frame.add(this);
    frame.pack();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    isRunning = false;

    houseX = 300;
    houseY = 150;
    houseVX = 1;
    houseVY = 1;
    TreeX = 100;
    TreeY = 100;
  }

  public void update() {
    houseX += houseVX;
    if (houseX > (width-240)) {
      houseVX = -1;
    }
    if (houseX < 0) {
      houseVX = 1;
    }
  }


  public void draw () {
    bs = getBufferStrategy();
    if (bs == null) {
      createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0,0, width, height);
    update();
    drawHouse(g, houseX, houseY);
    drawTree(g, TreeX, TreeY);
    g.dispose();
    bs.show();

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
    Grafik painting = new Grafik();
    painting.start();
  }

  public synchronized void start() {
    thread = new Thread(this);
    isRunning = true;
    thread.start();
  }

  public synchronized void stop() {
   isRunning = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    double deltaT = 1.0/fps;
    long lastTime = System.currentTimeMillis();

    while (isRunning) {
      long now = System.currentTimeMillis();
      if (now-lastTime > deltaT) {
        update();
        draw();
        lastTime = now;
      }
    }
    stop();
  }




}
