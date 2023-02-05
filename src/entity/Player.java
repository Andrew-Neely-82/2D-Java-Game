package javaGame.src.entity;

import javaGame.src.main.GamePanel;
import javaGame.src.main.KeyHandler;

import java.awt.*;

public class Player extends Entity {

  GamePanel gp;
  KeyHandler keyH;

  public Player(GamePanel gp, KeyHandler keyH) {

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
    if (keyH.upPressed == true) {
      ySpeed -= speed;
    }
    if (keyH.downPressed == true) {
      ySpeed += speed;
    }
    if (keyH.leftPressed == true) {
      xSpeed -= speed;
    }
    if (keyH.rightPressed == true) {
      xSpeed += speed;
    }

    //check if up and down are both pressed, don't move in the y-direction
    if (keyH.upPressed == true && keyH.downPressed == true) {
      ySpeed = 0;
    }

    //check if left and right are both pressed, don't move in the x-direction
    if (keyH.leftPressed == true && keyH.rightPressed == true) {
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