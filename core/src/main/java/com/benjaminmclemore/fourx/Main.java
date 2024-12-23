package com.benjaminmclemore.fourx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

        spriteBatch.draw(backgroundTexture, 0, 0, worldWidth, worldHeight); // draw the background
        spriteBatch.draw(bucketTexture, 0, 0, 1, 1); // draw the bucket

        spriteBatch.end();

    }
}
