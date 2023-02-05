package javaGame.src.main;

import java.awt.event.*;

public class KeyHandler implements KeyListener {
  public boolean upPressed, downPressed, leftPressed, rightPressed;

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();

    // move up
    if (code == KeyEvent.VK_W) {
      upPressed = true;
    }

    // move up & left
    if (code == KeyEvent.VK_W && code == KeyEvent.VK_A) {
      upPressed = true;
      leftPressed = true;
      System.out.println("up and left");
    }

    // move down
    if (code == KeyEvent.VK_S) {
      downPressed = true;
    }

    // move left
    if (code == KeyEvent.VK_A) {
      leftPressed = true;
    }

    // move right
    if (code == KeyEvent.VK_D) {
      rightPressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();

    if (code == KeyEvent.VK_W) {
      upPressed = false;
    }

    // move up & left
    if (code == KeyEvent.VK_W && code == KeyEvent.VK_A) {
      upPressed = false;
      leftPressed = false;
      System.out.println("up and left");
    }

    if (code == KeyEvent.VK_S) {
      downPressed = false;
    }

    if (code == KeyEvent.VK_A) {
      leftPressed = false;
    }

    if (code == KeyEvent.VK_D) {
      rightPressed = false;
    }
  }

}
