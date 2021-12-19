package code.maman13.ex1;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class MultipleChoiceGame extends Application {
    private int correct = 0;
    private int rowIndex = 0;

    @Override
    public void start(Stage primaryStage) throws IOException {

        FileReader reader = new FileReader("code/maman13/ex1/questions.txt");
        List<Question> questions = reader.getQuestions();

        Question q = questions.get(rowIndex);
        Label labelFirst = new Label(q.question);
        Label labelResponse = new Label();

        Button button = new Button("Submit");
        Button nextQuestion = new Button("Next Question");
        Button restartGame = new Button("Restart Game");
        RadioButton radio1, radio2, radio3, radio4;
        radio1 = new RadioButton();
        radio2 = new RadioButton();
        radio3 = new RadioButton();
        radio4 = new RadioButton();

        VBox layout = new VBox(5);

        layout.getChildren().addAll(labelFirst, radio1, radio2, radio3, radio4, button, nextQuestion, labelResponse,
                restartGame);

        Scene scene1 = new Scene(layout, 400, 250);
        primaryStage.setScene(scene1);

        primaryStage.show();

        restartGame.setOnAction(e -> {
            rowIndex = 0;
            correct = 0;
            this.runQuestions(questions, rowIndex, radio1, radio2, radio3, radio4, labelFirst, button, labelResponse,
                    primaryStage, nextQuestion);
        });

        this.runQuestions(questions, rowIndex, radio1, radio2, radio3, radio4, labelFirst, button, labelResponse,
                primaryStage, nextQuestion);

    }

    public void runQuestions(List<Question> questions, int rowIndex, RadioButton radio1, RadioButton radio2,
            RadioButton radio3, RadioButton radio4, Label labelFirst, Button button, Label labelResponse,
            Stage primaryStage, Button nextQuestion) {
        /// this functions displays a question, and if user choose answer correctly,
        /// displays the next question

        // this questions remains
        if (rowIndex < questions.size()) {

            // displaying the question
            String title = String.format("Test Question %d", rowIndex);
            primaryStage.setTitle(title);

            Question q = questions.get(rowIndex);
            // randomize order
            Answer[] answers = q.getAnswers();

            radio1.setText(answers[0].answer);
            radio2.setText(answers[1].answer);
            radio3.setText(answers[2].answer);
            radio4.setText(answers[3].answer);
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

            nextQuestion.setOnAction(e -> {
                this.runQuestions(questions, rowIndex + 1, radio1, radio2, radio3, radio4, labelFirst, button,
                        labelResponse, primaryStage, nextQuestion);
            });
            // answer test
            button.setOnAction(e -> {
                if ((radio1.isSelected()) && (this.checkCorrectAnswer(radio1.getText(), q.answer))) {
                    labelResponse.setText("Correct answer");
                    button.setDisable(true);
                    correct += 1;
                }

                else if ((radio2.isSelected()) && (this.checkCorrectAnswer(radio2.getText(), q.answer))) {
                    labelResponse.setText("Correct answer");
                    button.setDisable(true);
                    correct += 1;
                }

                else if ((radio3.isSelected()) && (this.checkCorrectAnswer(radio3.getText(), q.answer))) {
                    labelResponse.setText("Correct answer");
                    button.setDisable(true);
                    correct += 1;
                }

                else if ((radio4.isSelected()) && (this.checkCorrectAnswer(radio4.getText(), q.answer))) {
                    labelResponse.setText("Correct answer");
                    button.setDisable(true);
                    correct += 1;
                }

                else {
                    labelResponse.setText("Wrong answer");
                    button.setDisable(true);
                }
            });
            // finished all!
        } else {
            button.setDisable(true);
            labelResponse.setText("Youve made it!, you scored " + (((float)(correct) / (rowIndex))) * 100 + "%");
        }

    }


    public boolean checkCorrectAnswer(String answer, Answer[] ar) {
        // checking if answer is corrected
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
