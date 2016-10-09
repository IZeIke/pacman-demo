package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/7/2016.
 */
public class WorldRenderer {
    private PacmanGame pacmanGame;
    private Texture pacmanImg;
    private World world;
    private MazeRenderer mazeRenderer;
    SpriteBatch batch;
    public static final int BLOCK_SIZE = 40;

    public WorldRenderer(PacmanGame pacmanGame, World world) {
        this.pacmanGame = pacmanGame;
        batch = pacmanGame.batch;
        this.world = world;
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
        pacmanImg = new Texture("pacman.png");
    }

    public void render(float delta) {
        mazeRenderer.render();
        Vector2 pos = world.getPacman().getPosition();
        batch.begin();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        batch.end();
    }
}

