package com.mygdx.game;

/**
 * Created by harit on 10/7/2016.
 */
public class World {
    private Pacman pacman;
    private PacmanGame pacmanGame;
    private Maze maze;

    World(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        maze = new Maze();
        pacman = new Pacman(100,100);
    }

    Pacman getPacman() {
        return pacman;
    }

    Maze getMaze()
    {
        return maze;
    }


}
