package com.gab;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {
    public static final int GAME_RETRIES = 100;
    private GuessingGame game;

    // private final GuessingGame game = new GuessingGame();

    @BeforeEach
    void setUp(){
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinning() {
        int randomNum = game.giveRandomNum();
        String message = game.guess(randomNum);
        assertEquals("You got it in 1 try", message);
    }
    @Test
    public void testSimpleLosing() {
        int randomNum = game.giveRandomNum();
        String message = game.guess(-5);
        assertEquals("You did not get it - you are too low", message);
    }

    @Test
    public void testSimpleLosingPositive() {
        int randomNum = game.giveRandomNum();
        String message = game.guess(randomNum + 1);
        assertEquals("You did not get it - you are too high", message);
    }

    // @Test
    @Test
    public void testRdmNumberGen() {
        int[] rdmNumberCount = new int[11];
        for (int counter = 0; counter < GAME_RETRIES; counter++) {
            GuessingGame localgame = new GuessingGame();
            int randomNum = localgame.giveRandomNum();
            rdmNumberCount[randomNum] = 1;
        }

        int sum = 0;
        for (int counter=0; counter<11; counter++){
            sum += rdmNumberCount[counter];
        }
        assertEquals(10, sum);
    }
    @Test
    public void testWrongFourTimes() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("You did not get it and you reached the maximum number of tries (4 tries). Game Over.", message);
    }

    @Test
    public void testWrongThreeTimesandCorrectOneTime() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        int randomNum = game.giveRandomNum();
        String message = game.guess(randomNum);
        assertEquals("You got it in 4 tries", message);
    }
    @Test
    public void testWrongTenTimes() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("You did not get it and you passed the maximum number of tries (4 tries). Game Over.", message);
    }
}
