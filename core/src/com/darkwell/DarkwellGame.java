package com.darkwell;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.darkwell.screens.LoadingScreen;

public class DarkwellGame extends Game {

    public AssetManager assetManager;
    public static final int VIEWPORT_WIDTH  = 960;
    public static final int VIEWPORT_HEIGHT = 540;

    @Override
    public void create() {
        assetManager = new AssetManager();
        setScreen(new LoadingScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        if (assetManager != null) assetManager.dispose();
    }
}
