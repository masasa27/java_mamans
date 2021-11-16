package code.maman11.ex1;

import java.util.Scanner;


public class UserInterface {
    private InputValidator input_validator;
    private GameBored game_bored;

    public UserInterface() {
        this.restartVariables();
    }

    private void restartVariables() {
        WordsDb words_db = new WordsDb();
        Word chosen_word = words_db.generateWord();
        this.input_validator = new InputValidator();
        this.game_bored = new GameBored(chosen_word);
    }

    public void playTurn() {
        game_bored.printWord();
        String input = input_validator.readInput();
        game_bored.playTurn(input);
    }

    public boolean playGame() {
        while (!game_bored.done()) {
            this.playTurn();
        }
        System.out.println("You Won!");
        this.restart();
        return true;
    }

    public void restart() {
        Scanner restart = new Scanner(System.in);
        System.out.println("if you want to restart please write 1, any other key will exit");
        String restart_string = restart.nextLine();
        if (restart_string.equals("1")) {
            this.restartVariables();
            this.playGame();
        }
        restart.close();
    }

}
