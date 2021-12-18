package code.maman13;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Questionary {
    public static void main(String[] args) throws IOException
    {
        

        FileReader reader = new FileReader("questions.txt");
        List<Question> questions = reader.getQuestions();
        System.out.println("hello world");
    }
    
}
