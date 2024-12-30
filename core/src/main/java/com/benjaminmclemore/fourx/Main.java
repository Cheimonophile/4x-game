package com.benjaminmclemore.fourx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminmclemore.fourx.screens.StartScreen;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends Game {

  public OrthographicCamera camera;
  public SpriteBatch batch;

  public void create() {

    camera = new OrthographicCamera();
    camera.setToOrtho(false, 800, 480);
    batch = new SpriteBatch();

    this.setScreen(new StartScreen(this));
  }

  public void resize(int width, int height) {
  }

  public void render() {
    super.render();
  }

  public void dispose() {
    batch.dispose();
  }
}
