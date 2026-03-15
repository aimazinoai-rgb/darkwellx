package com.darkwell.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.darkwell.DarkwellGame;

public class LoadingScreen implements Screen {

    private final DarkwellGame game;
    private SpriteBatch batch;
    private BitmapFont font;

    public LoadingScreen(DarkwellGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font  = new BitmapFont();
        font.setColor(0.788f, 0.659f, 0.298f, 1f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.102f, 0.039f, 0.180f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.assetManager.update();
        batch.begin();
        font.draw(batch, "DARKWELL", 40, Gdx.graphics.getHeight() / 2f + 40);
        font.draw(batch, "Yukleniyor... " + (int)(game.assetManager.getProgress() * 100) + "%",
            40, Gdx.graphics.getHeight() / 2f);
        batch.end();
        if (game.assetManager.isFinished()) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }

    @Override public void resize(int w, int h) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
