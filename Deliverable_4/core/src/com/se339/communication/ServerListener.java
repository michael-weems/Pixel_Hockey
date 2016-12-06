package com.se339.communication;

import com.badlogic.gdx.math.Vector2;
import com.se339.log.Log;
import com.se339.pixel_hockey.PixelHockeyGame;
import com.se339.pixel_hockey.screens.GameScreen;

import java.io.IOException;

/**
 * Created by mweem_000 on 12/5/2016.
 */

public class ServerListener {

    private int port;
    private String host;
    private PixelHockeyGame game;

    private Log log;

    public ServerListener(final PixelHockeyGame game){
        port = 8000;
        host = "192.168.1.107";

        this.game = game;

        log = new Log("ServerListener");

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        String msg = game.getSocket().read();
                        if (msg.equals("startgame")) {
                            game.setScreen(new GameScreen(game));
                        }
                        else if (msg.equals("goal")){
                            callback_GoalScored();
                        }
                        else if (msg.contains("velocity")){
                            // parse velocity out


                            Vector2 v = new Vector2(0f,0f);
                            callback_VelocityChange(v);
                        }

                    } catch (IOException e){
                            log.e("Error reading from socket: " + e);
                    }
                }
            }
        }).start();
    }

    public void callback_GoalScored(){
        game.getGameValues().goalScored();
    }

    public void callback_VelocityChange(Vector2 v){
        game.getGameValues().updateVelocity(v);
    }
}
