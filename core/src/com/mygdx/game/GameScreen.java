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
    private WorldRenderer worldRenderer;
    World world;


    public GameScreen(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        world =new World(pacmanGame);
        worldRenderer = new WorldRenderer(pacmanGame,world);
        pacmanImg = new Texture("pacman.png");
    }



    private void update(float delta) {
        updatePacmanDirection();
        world.update(delta);
    }

    private void updatePacmanDirection() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            world.getPacman().setNextDirection(Pacman.DIRECTION_UP);
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            world.getPacman().setNextDirection(Pacman.DIRECTION_DOWN);
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            world.getPacman().setNextDirection(Pacman.DIRECTION_LEFT);
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            world.getPacman().setNextDirection(Pacman.DIRECTION_RIGHT);
        }else
        {
            world.getPacman().setNextDirection(Pacman.DIRECTION_STILL);
        }
    }




    public  void render (float delta)
    {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    }
}
