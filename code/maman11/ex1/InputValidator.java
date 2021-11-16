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
        int validInputErrorCode = validateInput(input); // error code
        while (validInputErrorCode != 0) {
            if (validInputErrorCode == 1) {
                System.out.println("you have entered an invalid length input, please try again");
            }
            else if (validInputErrorCode == 2)
            {
                System.out.println("you have entered a used letter, please pick again");
            }
            input = this.dataReader.nextLine();
            validInputErrorCode = validateInput(input);
        }
        return input;
    }

    public int validateInput(String c) {
        if (c.length() > 1) {
            return 1;
        }

        if (this.usedLetters.contains(c)) {
            return 2;
        }
        this.usedLetters += c;
        return 0;
    }
}
