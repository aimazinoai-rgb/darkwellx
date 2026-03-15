package com.darkwell.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.darkwell.DarkwellGame;

public class GameScreen implements Screen {

    private final DarkwellGame game;
    private SpriteBatch batch;
    private BitmapFont font;
    private float playerX, playerY;

    public GameScreen(DarkwellGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch   = new SpriteBatch();
        font    = new BitmapFont();
        font.setColor(0.788f, 0.659f, 0.298f, 1f);
        playerX = DarkwellGame.VIEWPORT_WIDTH  / 2f;
        playerY = DarkwellGame.VIEWPORT_HEIGHT / 2f;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.102f, 0.039f, 0.180f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isTouched()) {
            playerX = Gdx.input.getX();
            playerY = Gdx.graphics.getHeight() - Gdx.input.getY();
        }
        batch.begin();
        font.draw(batch, "DARKWELL - FAZ 1", 20, Gdx.graphics.getHeight() - 20);
        font.draw(batch, "Buyucu aktif", 20, Gdx.graphics.getHeight() - 50);
        font.draw(batch, "Konum: " + (int)playerX + ", " + (int)playerY, 20, Gdx.graphics.getHeight() - 80);
        font.draw(batch, "Ekrana dokun = hareket et", 20, 40);
        batch.end();
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
