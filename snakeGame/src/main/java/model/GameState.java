/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Anita
 */
public enum GameState {
    /** game is still in progress */
    IN_PROGRESS,

    /** game ended and player 1 won */
    PLAYER1WON,

    /** game ended and player 2 won */
    PLAYER2WON,

    /** players collided with each other, resulting in a draw */
    DRAW,
}
