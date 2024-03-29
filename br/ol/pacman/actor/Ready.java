/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ol.pacman.actor;

import br.ol.pacman.PacmanActor;
import br.ol.pacman.PacmanGame;
import br.ol.pacman.PacmanGame.State;

/**
 * Ready class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 */
public class Ready extends PacmanActor {

    public Ready(PacmanGame game) {
        super(game);
    }

    @Override
    public void init() {
        x = 11 * 8;
        y = 20 * 8;
        loadFrames("/res/ready.png");
    }

    @Override
    public void updateReady() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    game.restoreCurrentFoodCount();
                    //game.sounds.get("start").play();
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    if (System.currentTimeMillis() - waitTime < 2000) { // || game.sounds.get("start").isPlaying()) {
                        break yield;
                    }
                    game.setState(State.READY2);
                    break yield;
            }
        }
    }
    
    @Override
    public void updateReady2() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    game.broadcastMessage("showAll");
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    if (System.currentTimeMillis() - waitTime < 2000) { // || game.sounds.get("start").isPlaying()) {
                        break yield;
                    }
                    game.setState(State.PLAYING);
                    break yield;
            }
        }
    }

    // broadcast messages

    @Override
    public void stateChanged() {
        visible = false;
        if (game.getState() == PacmanGame.State.READY 
                || game.getState() == PacmanGame.State.READY2) {
            
            visible = true;
            instructionPointer = 0;
        }
    }
    
}
