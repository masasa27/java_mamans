package code.maman13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    public FileReader(String filename) throws IOException {
        int rowIndex = 0;
        try {
            // TODO: abspath and not heartcoded path

            // getting file path
            String path = new File("./code/maman13").getAbsolutePath();
            File absPathFile = new File(path, filename);
            String absPath = absPathFile.getPath();

            // reading file
            File myObj = new File(absPath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                if  (rowIndex % 5 == 0)
                {
                    Question q = new Question(data);
                }
                else if (rowIndex % 5 == 1)
                {
                    Answer answer = new Answer(data, true);
                }
                else
                {
                    Answer answer = new Answer(data, false);
                }

                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        
    }

}
