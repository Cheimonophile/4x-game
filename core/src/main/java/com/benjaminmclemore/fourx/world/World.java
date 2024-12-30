package com.benjaminmclemore.fourx.world;

public class World {

  private int width;
  private int height;
  private int[][] plots;

  public World(int width, int height) {
    this.width = width;
    this.height = height;
    this.plots = new int[width][height];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

}
