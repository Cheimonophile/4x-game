package com.benjaminmclemore.fourx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends ApplicationAdapter {
  private SpriteBatch spriteBatch;
  private FitViewport viewport;

  private Texture image;

  // drop
  Texture backgroundTexture;
  Texture bucketTexture;
  Texture dropTexture;
  Sound dropSound;
  Music music;
  Sprite bucketSprite; // Declare a new Sprite variable
  Vector2 touchPos;

  @Override
  public void create() {
    spriteBatch = new SpriteBatch();
    viewport = new FitViewport(8, 5);
    image = new Texture("libgdx.png");

    // drop
    backgroundTexture = new Texture("drop/background.png");
    bucketTexture = new Texture("drop/bucket.png");
    dropTexture = new Texture("drop/drop.png");
    dropSound = Gdx.audio.newSound(Gdx.files.internal("drop/drop.mp3"));
    music = Gdx.audio.newMusic(Gdx.files.internal("drop/music.mp3"));
    bucketSprite = new Sprite(bucketTexture); // Initialize the sprite based on the texture
    bucketSprite.setSize(1, 1); // Define the size of the sprite
    touchPos = new Vector2();
  }

  @Override
  public void render() {

    // drop
    input();
    logic();
    draw();
  }

  @Override
  public void resize(int width, int height) {
    viewport.update(width, height, true); // true centers the camera
  }

  @Override
  public void dispose() {
    spriteBatch.dispose();
    image.dispose();
  }

  private void input() {
    float speed = 4f;
    float delta = Gdx.graphics.getDeltaTime(); // retrieve the current delta

    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      bucketSprite.translateX(speed * delta); // Move the bucket right
    } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      bucketSprite.translateX(-speed * delta); // move the bucket left
    }

    if (Gdx.input.isTouched()) { // If the user has clicked or tapped the screen
      touchPos.set(Gdx.input.getX(), Gdx.input.getY()); // Get where the touch happened on screen
      viewport.unproject(touchPos); // Convert the units to the world units of the viewport
      bucketSprite.setCenterX(touchPos.x); // Change the horizontally centered position of the bucket
    }
  }

  private void logic() {

  }

  private void draw() {

    ScreenUtils.clear(Color.BLACK);
    viewport.apply();
    spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
    spriteBatch.begin();

    // store the worldWidth and worldHeight as local variables for brevity
    float worldWidth = viewport.getWorldWidth();
    float worldHeight = viewport.getWorldHeight();

    spriteBatch.draw(backgroundTexture, 0, 0, worldWidth, worldHeight);
    bucketSprite.draw(spriteBatch); // Sprites have their own draw method

    spriteBatch.end();

  }
}
