package javaGame.src.main;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import javaGame.src.entity.Player;

public class GamePanel extends JPanel implements Runnable {

  // screen settings
  final byte originalTileSize = 16; // 16x16 tile
  final byte scale = 3;

  public final byte tileSize = originalTileSize * scale; // 40*40 tile
  final byte maxScreenCol = 16;
  final byte maxScreenRow = 12;
  final int screenWidth = tileSize * maxScreenCol; // 768px
  final int screenHeight = tileSize * maxScreenRow; // 576px

  // FPS
  int FPS = 60;

  KeyHandler keyH = new KeyHandler();
  Thread gameThread;
  Player player = new Player(this, keyH);

  // set players pos
  int playerX = 100;
  int playerY = 100;
  int playerSpeed = 4;

  public GamePanel() {

    this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true); // rendering performance
    this.addKeyListener(keyH);
    this.setFocusable(true);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {

    // * this is a SLEEP counter for game time management
    // double drawInterval = 1000000000 / FPS; // 0.016666 seconds
    // double nextDrawTime = System.nanoTime() + drawInterval; //
    // while (gameThread != null) {
    // long currentTime = System.nanoTime();
    // update();
    // repaint();
    // try {
    // double remainingTime = nextDrawTime - System.nanoTime();
    // remainingTime /= 1000000;
    // if (remainingTime < 0) {
    // remainingTime = 0;
    // }
    // Thread.sleep((long) remainingTime);
    // nextDrawTime += drawInterval;
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }

    double drawInterval = 1000000000 / FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawCount = 0;

    while (gameThread != null) {
      currentTime = System.nanoTime();

      delta += (currentTime - lastTime) / drawInterval;
      timer += (currentTime - lastTime);
      lastTime = currentTime;

      lastTime = currentTime;

      if (delta >= 1) {
        update();
        repaint();
        delta--;
        drawCount++;
      }

      if (timer >= 1000000000) {
        System.out.println("FPS: " + drawCount);
        drawCount = 0;
        timer = 0;
      }
    }
  }

  public void update() {
    player.update();
  }

  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    player.draw(g2);

    g2.dispose();
  }
}
