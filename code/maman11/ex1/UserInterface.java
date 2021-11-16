package code.maman11.ex1;

import java.util.Scanner;


public class UserInterface {
    private InputValidator input_validator;
    private GameBored game_bored;

    public UserInterface() {
        this.restart_variables();
    }

    private void restart_variables() {
        WordsDb words_db = new WordsDb();
        Word chosen_word = words_db.generate_word();
        this.input_validator = new InputValidator();
        this.game_bored = new GameBored(chosen_word);
    }

    public void play_turn() {
        game_bored.printWord();
        String input = input_validator.read_input();
        game_bored.playTurn(input);
    }

    public boolean play_game() {
        while (!game_bored.done()) {
            this.play_turn();
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
            this.restart_variables();
            this.play_game();
        }
        restart.close();
    }

}
