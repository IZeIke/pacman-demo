package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/6/2016.
 */
public class GameScreen extends ScreenAdapter {
    private PacmanGame pacmanGame;
    private Texture pacmanImg;
    private Pacman pacman;


    public GameScreen(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;

        pacmanImg = new Texture("pacman.png");
        pacman = new Pacman(100, 100);
    }



    private void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pacman.move(Pacman.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pacman.move(Pacman.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pacman.move(Pacman.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pacman.move(Pacman.DIRECTION_RIGHT);
        }
    }




    public  void render (float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update();
        SpriteBatch batch = pacmanGame.batch;
        batch.begin();
        Vector2 pos = pacman.getPosition();
        batch.draw(pacmanImg, pos.x, pos.y);
        batch.end();

    }
}
