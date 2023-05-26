package javaGame.src.entity;

import javaGame.src.main.GamePanel;
import javaGame.src.main.KeyHandler;

import java.awt.*;

public class Player extends Entity {

  private GamePanel gp;
  private KeyHandler keyH;

  public Player(GamePanel gp, KeyHandler keyH) {
    super(100, 100, 4); // Invoke the Entity superclass constructor with initial values

    this.gp = gp;
    this.keyH = keyH;

    setDefaultValues();
  }

  public void setDefaultValues() {
    x = 100;
    y = 100;
    speed = 4;
  }

  public void update() {
    int xSpeed = 0, ySpeed = 0;
    if (keyH.upPressed) {
      ySpeed -= speed;
    }
    if (keyH.downPressed) {
      ySpeed += speed;
    }
    if (keyH.leftPressed) {
      xSpeed -= speed;
    }
    if (keyH.rightPressed) {
      xSpeed += speed;
    }

    // Check if up and down are both pressed, don't move in the y-direction
    if (keyH.upPressed && keyH.downPressed) {
      ySpeed = 0;
    }

    // Check if left and right are both pressed, don't move in the x-direction
    if (keyH.leftPressed && keyH.rightPressed) {
      xSpeed = 0;
    }

    x += xSpeed;
    y += ySpeed;
  }

  public void draw(Graphics2D g2) {
    g2.setColor(Color.white);
    g2.fillRect(x, y, gp.tileSize, gp.tileSize);
  }
}
