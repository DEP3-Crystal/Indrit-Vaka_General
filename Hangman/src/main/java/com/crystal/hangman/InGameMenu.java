package com.crystal.hangman;

import com.crystal.hangman.io.InputManager;
import com.crystal.hangman.io.OutputManager;
import com.crystal.hangman.model.GameData;
import com.crystal.hangman.model.GameState;
import com.crystal.hangman.model.User;
import com.crystal.hangman.service.GameService;

import static com.crystal.hangman.io.ConsoleColors.*;

public class InGameMenu {
    private final GameService gameService;
    private final GameData gameData = new GameData();
    private final InputManager inputManager = InputManager.getInstance();
    private final OutputManager outputManager = OutputManager.getInstance();
    private final Menu menu;

    public InGameMenu(GameService gameService, Menu menu) {
        this.gameService = gameService;
        this.menu = menu;
    }

    public void startTheGame(User user) {
        startTheGame(user, true);
    }

    public void startTheGame(User user, boolean firstRun) {

        if (firstRun) {
            outputManager.hr();
            outputManager.showMessage("\t\t\t" + user.getNickName() + " Welcome to Hang Man game!");
        }

        playGame(gameData);
        showGameResults(user, gameData);
        gameEnded(user, gameData);
    }

    private void playGame(GameData gameData) {
        String givenWord = gameService.getNextLevel();
        String definition = gameService.getDefinition(givenWord);
        StringBuilder dashedWord = gameService.getDashedWord(givenWord);

        while (gameData.getGameState() == GameState.IN_PROGRESS) {
            printWord(definition, dashedWord);

            char answer = inputManager.getLetter().toLowerCase().charAt(0);
            if (answer == '0') {
                menu.menu();
            } else if (givenWord.contains(answer + "")) {
                dashedWord = gameService.replaceLetters(givenWord, dashedWord, answer);
                gameData.incrementScore();

                if (gameService.hasWon(givenWord, dashedWord)) {
                    outputManager.winMessage();
                    gameData.won();
                }

            } else {
                outputManager.showErrMessage("The given letter isn't in the word");
                gameData.wrongAnswer();
                if (gameService.hasLose(gameData)) {
                    gameData.lose();
                    outputManager.loseMessage();
                } else {
                    outputManager.showMessage("You have " + TEXT_RED + gameData.getLeftChances() + TEXT_RESET + " chances");
                }
            }
            if (gameService.isUsedLetter(gameData, answer)) {
                outputManager.showMessage("You already have used that letter", TEXT_BLUE);
                outputManager.showMessage("used letters" + gameData.getUsedLetters());

            }
            gameService.addUsedLetter(gameData, answer);
        }
    }

    private void printWord(String definition, StringBuilder inputtedWord) {
        outputManager.hr();
        outputManager.showMessage("Please guess a letter: " + TEXT_BLUE + "0. back to menu");
        outputManager.showMessage(TEXT_BLUE + "Hint: " + TEXT_GREEN + definition);

        outputManager.showMessage(inputtedWord + "", TEXT_BLUE);
    }

    private void showGameResults(User user, GameData gameData) {
        gameService.updateUserData(user, gameData);
        outputManager.showMessage("High score: " + TEXT_BLUE + user.getHighScore());
        outputManager.showMessage("Score: " + TEXT_BLUE + gameData.getScore());
        outputManager.showMessage("Mistakes: " + TEXT_RED + gameData.getMistakes());
    }


    private void gameEnded(User user, GameData gameData) {
        outputManager.showMessage(TEXT_BLUE + "Do you want to play an other game?"
                + TEXT_RED + " Y/N");
        String ans = inputManager.getLetter();
        if (ans.equalsIgnoreCase("y"))
            resetTheGame(user, gameData);
        else if (!ans.equals("n")) {
            outputManager.showErrMessage("wrong answer" + TEXT_RED + " Y/N");
        } else {
            outputManager.showMessage(TEXT_BLUE + "See you! :)");
        }
    }

    private void resetTheGame(User user, GameData gameData) {
        if (gameData.getGameState().equals(GameState.LOSE))
            gameData.resetScore();
        gameData.resetData();
        startTheGame(user);
    }

}