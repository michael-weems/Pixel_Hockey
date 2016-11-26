package com.se339.pixel_hockey.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.se339.pixel_hockey.PixelHockeyGame;
import com.se339.pixel_hockey.Scenes.Hud;

/**
 * Created by mweem_000 on 11/23/2016.
 */

public class PlayScreen implements Screen{

    private PixelHockeyGame game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;

    public PlayScreen(PixelHockeyGame game){
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(PixelHockeyGame.V_WIDTH, PixelHockeyGame.V_HEIGHT, gamecam);
        hud = new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // clear the screen
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // what will be shown via the camera
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        /*
        // render only what the camera can see
        game.batch.setProjectionMatrix(gamecam.combined);

        // Open the game window
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();
        */
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}