package code.maman13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public List<Question> questions = new ArrayList<Question>();
    public String absFilePath;

    public FileReader(String filename) throws IOException {
        int rowIndex = 0;
        // getting file path
        String path = new File("./code/maman13").getAbsolutePath();
        File absPathFile = new File(path, filename);
        this.absFilePath = absPathFile.getPath();
    }

    public List<Question> getQuestions() {
        int rowIndex = 0;
        try {

            // reading file
            File myObj = new File(this.absFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (rowIndex % 5 == 0) {
                    Question q = new Question(data);
                    this.questions.add(q);
                } else if (rowIndex % 5 == 1) {
                    Answer answer = new Answer(data, true);
                    this.questions.get(this.questions.size() - 1).addAnswer(answer);
                } else {
                    Answer answer = new Answer(data, false);
                    this.questions.get(this.questions.size() - 1).addAnswer(answer);
                }

                System.out.println(rowIndex);
                System.out.println(data);
                rowIndex++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return this.questions;
    }
}
