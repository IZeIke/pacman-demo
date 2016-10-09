package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/7/2016.
 */
public class Pacman {
    private Vector2 position;
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 5;
    private int currentDirection;
    private int nextDirection;
    private Maze maze;

    public Pacman(int x, int y,Maze maze) {
        position = new Vector2(x,y);
        currentDirection=DIRECTION_STILL;
        nextDirection=DIRECTION_STILL;
        this.maze = maze;
    }

    private boolean canMoveInDirection(int dir) {
        int newRow = 0;
        int newCol = 0;
        if(dir == 1) {
            newRow = getRow()-1;
            newCol = getColumn();
        }else
        if(dir == 2)
        {
            newRow = getRow();
            newCol = getColumn()+1;
        }else
        if(dir == 3)
        {
            newRow = getRow()+1;
            newCol = getColumn();
        }else
        if(dir == 4)
        {
            newRow = getRow();
            newCol = getColumn()-1;
        }
        if(dir == 0)
        {
            return false;
        }
        if(maze.hasWallAt(newRow,newCol)) {
            return false;
        }else
        {
            return true;
        }
    }

    public void move(int dir) {

        position.x += SPEED * DIR_DIFF[dir][0];
        position.y += SPEED * DIR_DIFF[dir][1];
    }

    public boolean isAtCenter() {
        int blockSize = WorldRenderer.BLOCK_SIZE;

        return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y - blockSize/2) % blockSize) == 0);
    }

    public void update() {
        if(isAtCenter()) {
            if(canMoveInDirection(nextDirection)) {
                currentDirection = nextDirection;
            } else {
                currentDirection = DIRECTION_STILL;
            }
        }
        position.x += SPEED * DIR_DIFF[currentDirection][0];
        position.y += SPEED * DIR_DIFF[currentDirection][1];
    }

    private static final int [][] DIR_DIFF = new int [][] {
            {0,0},
            {0,-1},
            {1,0},
            {0,1},
            {-1,0}
    };

    public Vector2 getPosition() {
        return position;
    }

    public void setNextDirection(int dir) {
        nextDirection = dir;
    }

    private int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE;
    }

    private int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE;
    }
}
