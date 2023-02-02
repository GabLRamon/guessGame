package com.gab;

import java.util.Random;


public class GuessingGame {

    private final int randomNum = new Random().nextInt(10) + 1;
    private int counter = 0;

    public int giveRandomNum() {
        return randomNum;
    };

    public String guess(int guessedNumber) {
        counter++;
        String Winningmsg = String.format("You got it in %d try", counter);
        String tries = counter == 1 ? "try" : "tries";
        String response = null;
        String highOrLow = null;
        if (counter > 1) {
            Winningmsg = String.format("You got it in %d %s", counter, tries);
        }
        if (counter == 4 && guessedNumber != giveRandomNum()) {
            response = "You did not get it and you reached the maximum number of tries (4 tries). Game Over.";
        } else if (counter > 4) {
            response ="You did not get it and you passed the maximum number of tries (4 tries). Game Over.";
        } else {
            if (guessedNumber < giveRandomNum()) {
                highOrLow = "too low";
            } else {
                highOrLow = "too high";
            }
            String Losingmsg = String.format("You did not get it - you are %s", highOrLow);
           response = guessedNumber == giveRandomNum() ? Winningmsg : Losingmsg;
        }
        return response;
    }

    public static void main(String[] args) {


        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue = true;
        do {
            String input = System.console().readLine("Enter a Number: ");
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);
            if ("q".equals(input)) {
                return;
            }
            if (output.contains("You got it")) {
                loopShouldContinue = false;
            } else if (output.contains("over")) {
                loopShouldContinue = false;
            }

        } while (loopShouldContinue);
    }
    }