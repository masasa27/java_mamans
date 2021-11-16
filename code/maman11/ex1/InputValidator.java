package code.maman11.ex1;

import java.util.Scanner;

public class InputValidator {
    private String usedLetters;
    private final Scanner dataReader;

    public InputValidator() {
        this.usedLetters = "";
        this.dataReader = new Scanner(System.in);
    }

    public String readInput() {
        System.out.println("enter character");
        String input = this.dataReader.nextLine();
        while (!validateInput(input)) {
            System.out.println("you have entered an invalid input, please try again");
            input = this.dataReader.nextLine();
        }
        return input;
    }

    public Boolean validateInput(String c) {
        if (c.length() > 1) {
            return false;
        }

        if (this.usedLetters.contains(c)) {
            return false;
        }
        this.usedLetters += c;
        return true;
    }
}
