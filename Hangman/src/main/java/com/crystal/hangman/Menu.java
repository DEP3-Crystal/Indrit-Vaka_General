package com.crystal.hangman;

import com.crystal.hangman.io.InputManager;
import com.crystal.hangman.io.OutputManager;
import com.crystal.hangman.model.User;
import com.crystal.hangman.service.GameService;
import com.crystal.hangman.service.UserService;

import java.util.Map;

import static com.crystal.hangman.io.ConsoleColors.*;

public class Menu {

    private final UserService userService;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final InGameMenu inGameMenu;
    public Menu(UserService userService, InputManager inputManager, OutputManager outputManager, GameService gameService) {
        this.userService = userService;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.inGameMenu = new InGameMenu(gameService, this);
    }


    public void menu() {

        int inputtedNumber = showMenu();
        switch (inputtedNumber) {
            case 1 : {
                singUp();
                break;
            }
            case 2 : {
                logIn();
                break;
            }
            case 3 : {
                outputManager.showGameRules();
                break;
            }
            case 4 : {
                showGameStats();
                break;
            }
            case 0 : {
                exitGame();
                break;
            }
            default : {
                outputManager.showErrMessage("Not valid option");
                menu();
                break;
            }
        }
    }

    public int showMenu() {
        outputManager.hr();
        outputManager.showMessage("Welcome to Hangman Game!\n" +
                "Please press:\n" +
                "    1. to start a new the game (Sing-up)\n" +
                "    2. to Login (Load previous game)\n" +
                "    3. to view the game rules\n" +
                "    4. game stats\n" +
                "    0. to Exit the game");
        outputManager.hr();
        return inputManager.getInt();
    }

    private void showGameStats() {
        outputManager.showMessage("NickName: \t\tTotalScore", TEXT_BLUE);
        Map<String, User> users = userService.getAllUsers();
        printUsers(users);
        outputManager.hr();
        outputManager.showMessage("any key to go back to Menu", TEXT_BLUE);
        inputManager.getString();
        menu();
    }

    private void printUsers(Map<String, User> users) {
        users.values().forEach(user -> outputManager.showMessage(TEXT_GREEN + user.getNickName() + "\t\t\t" + TEXT_GREEN + user.getHighScore()));
    }

    private void exitGame() {
        System.exit(0);
    }

    private void logIn() {
        outputManager.showMessage("Please provide your nickName");
        String nickName = inputManager.getWordString();

        if (!userService.doesUserExist(nickName)) {
            outputManager.showErrMessage("wrong nickName, there doesn't exist a user with that nickname");
            outputManager.showMessage("1. Try again");
            outputManager.showMessage("2. SingUp");
            int ans = inputManager.getInt();
            switch (ans) {
                case 1: {
                    logIn();
                    return;
                }
                case 2: {
                    singUp();
                    break;
                }
                default : {
                    outputManager.showErrMessage("Not valid option");
                    logIn();
                    return;
                }
            }
        }

        User user = userService.getUserByNickName(nickName).orElseThrow(); // we know for sure that user exist
        outputManager.showMessage("Please type you password:");
        if (isValidPassword(user)) {
            startTheGame(user);
        }
    }

    private boolean isValidPassword(User user) {
        String password = inputManager.getString();
        while (!userService.doesPasswordMatches(password, user)) {
            outputManager.showErrMessage("Wrong password!");
            outputManager.showMessage("Try again" + TEXT_RED + "Y/N");
            String ans = inputManager.getLetter();

            if (!ans.equalsIgnoreCase("y")) {
                menu();
                return false;
            }
            password = inputManager.getString();
        }
        return true;
    }

    private void singUp() {
        outputManager.showMessage("Please provide a nickName");
        String nickName = inputManager.getWordString();
        while (userService.doesUserExist(nickName)) {
            outputManager.showErrMessage("This nickname is taken. Please chose other one or: " + TEXT_BLUE + "0. to go back");
            nickName = inputManager.getWordString();
            if (nickName.equals("0")) {
                menu();
                return;
            }
        }
        outputManager.showMessage("Please provide a password");
        String password = inputManager.getPassword();
        User user = userService.createUser(nickName, password);
        userService.addUser(user);
        userService.saveUserData(user);
        startTheGame(user);
    }

    private void startTheGame(User user) {
        inGameMenu.startTheGame(user);
    }

}
