package code.maman11.ex1;
import java.util.Scanner;

public class InputValidator {
    private String _used_letters;
    private Scanner _data_reader;

    public InputValidator(){
        this._used_letters = "";
        this._data_reader = new Scanner(System.in);
    }

    public String read_input()
    {
        System.out.println("enter character");
        String input = this._data_reader.nextLine();
        while (!validate_input(input))
        {
            System.out.println("you have entered an invalid input, please try again");
            input = this._data_reader.nextLine();
        }
        return input;
    }

    public Boolean validate_input(String c){
        if (c.length() > 1)
        {
            return false;
        }

        if (this._used_letters.contains(c))
        {  
            return false;
        }
        this._used_letters += c;
        return true;
    }
}
