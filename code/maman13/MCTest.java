package code.maman13;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;
import java.util.*;

public class MCTest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        int rowIndex = 0;

        FileReader reader = new FileReader("questions.txt");
        List<Question> questions = reader.getQuestions();

        Question q = questions.get(rowIndex);
        Label labelFirst = new Label(q.question);
        Label labelResponse = new Label();

        Button button = new Button("Submit");
        RadioButton radio1, radio2, radio3, radio4;
        radio1 = new RadioButton();
        radio2 = new RadioButton();
        radio3 = new RadioButton();
        radio4 = new RadioButton();

        VBox layout = new VBox(5);

        layout.getChildren().addAll(labelFirst, radio1, radio2, radio3, radio4, button, labelResponse);

        Scene scene1 = new Scene(layout, 400, 250);
        primaryStage.setScene(scene1);

        primaryStage.show();

        this.changeQuestion(questions, rowIndex, radio1, radio2, radio3, radio4, labelFirst, button, labelResponse,
                primaryStage);

    }

    public void changeQuestion(List<Question> questions, int rowIndex, RadioButton radio1, RadioButton radio2,
            RadioButton radio3, RadioButton radio4, Label labelFirst, Button button, Label labelResponse,
            Stage primaryStage) {

        if (rowIndex < questions.size()) {

            String title = String.format("Test Question %d", rowIndex);
            primaryStage.setTitle(title);

            Question q = questions.get(rowIndex);
            // randomize order
            this.shuffleArray(q.answer);

            radio1.setText(q.answer[0].answer);
            radio2.setText(q.answer[1].answer);
            radio3.setText(q.answer[2].answer);
            radio4.setText(q.answer[3].answer);
            labelFirst.setText(q.question);

            ToggleGroup question = new ToggleGroup();

            radio1.setToggleGroup(question);
            radio2.setToggleGroup(question);
            radio3.setToggleGroup(question);
            radio4.setToggleGroup(question);

            radio1.setOnAction(e -> button.setDisable(false));
            radio2.setOnAction(e -> button.setDisable(false));
            radio3.setOnAction(e -> button.setDisable(false));
            radio4.setOnAction(e -> button.setDisable(false));

            button.setOnAction(e -> {
                if ((radio1.isSelected()) && (this.checkCorrectAnswer(radio1.getText(), q.answer)))
                {
                    labelResponse.setText("Correct answer");
                    button.setDisable(false);
                    this.changeQuestion(questions, rowIndex + 1, radio1, radio2, radio3, radio4, labelFirst, button,
                            labelResponse, primaryStage);
                }

                else if ((radio2.isSelected()) && (this.checkCorrectAnswer(radio2.getText(), q.answer)))
                {
                    labelResponse.setText("Correct answer");
                    button.setDisable(false);
                    this.changeQuestion(questions, rowIndex + 1, radio1, radio2, radio3, radio4, labelFirst, button,
                            labelResponse, primaryStage);
                }

                else if ((radio3.isSelected()) && (this.checkCorrectAnswer(radio3.getText(), q.answer)))
                {
                    labelResponse.setText("Correct answer");
                    button.setDisable(false);
                    this.changeQuestion(questions, rowIndex + 1, radio1, radio2, radio3, radio4, labelFirst, button,
                            labelResponse, primaryStage);
                }

                else if ((radio4.isSelected()) && (this.checkCorrectAnswer(radio4.getText(), q.answer)))
                {
                    labelResponse.setText("Correct answer");
                    button.setDisable(false);
                    this.changeQuestion(questions, rowIndex + 1, radio1, radio2, radio3, radio4, labelFirst, button,
                            labelResponse, primaryStage);
                }


                else {
                    labelResponse.setText("Wrong answer");
                    button.setDisable(true);
                }
            });
        } else {
            labelResponse.setText("Youve made it!");
            primaryStage.close();
        }

    }

    public void shuffleArray(Answer[] ar) {
        Random random = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            Answer a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public boolean checkCorrectAnswer(String answer, Answer[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if ((ar[i].answer == answer) && (ar[i].correct))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
