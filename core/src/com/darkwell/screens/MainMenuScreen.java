package com.darkwell.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.darkwell.DarkwellGame;

public class MainMenuScreen implements Screen {

    private final DarkwellGame game;
    private SpriteBatch batch;
    private BitmapFont titleFont;
    private BitmapFont menuFont;
    private float centerX, centerY;

    public MainMenuScreen(DarkwellGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch     = new SpriteBatch();
        titleFont = new BitmapFont();
        menuFont  = new BitmapFont();
        titleFont.getData().setScale(3f);
        titleFont.setColor(0.788f, 0.659f, 0.298f, 1f);
        menuFont.getData().setScale(1.8f);
        menuFont.setColor(0.95f, 0.90f, 0.78f, 1f);
        centerX = Gdx.graphics.getWidth()  / 2f;
        centerY = Gdx.graphics.getHeight() / 2f;
        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetector.GestureAdapter() {
            @Override
            public boolean tap(float x, float y, int count, int button) {
                float ty = Gdx.graphics.getHeight() - y;
                if (ty > centerY) {
                    game.setScreen(new GameScreen(game));
                    dispose();
                }
                return true;
            }
        }));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.102f, 0.039f, 0.180f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        titleFont.draw(batch, "DARKWELL", centerX - 130, centerY + 100);
        menuFont.setColor(0.788f, 0.659f, 0.298f, 1f);
        menuFont.draw(batch, "[ OYNA ]", centerX - 70, centerY + 20);
        menuFont.setColor(0.7f, 0.7f, 0.7f, 1f);
        menuFont.draw(batch, "[ CIKIS ]", centerX - 70, centerY - 40);
        batch.end();
    }

    @Override public void resize(int w, int h) { centerX = w/2f; centerY = h/2f; }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        titleFont.dispose();
        menuFont.dispose();
    }
}
