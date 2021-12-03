package code.maman12.ex2;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class GameOfLifeController {
    private Random randomizer = new Random();
    private final int regions = 5;
    @FXML
    private Button button;

    @FXML
    private Canvas canvas;

    @FXML
    void nextGen(ActionEvent event) {

        // connects to canvas and clears it
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

      
    }
}
