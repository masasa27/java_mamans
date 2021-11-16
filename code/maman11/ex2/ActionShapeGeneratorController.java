package code.maman11.ex2;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ActionShapeGeneratorController {
    private Random randomizer = new Random();
    private final int regions = 5;
    @FXML
    private Button button;

    @FXML
    private Canvas canvas;

    @FXML
    void drawShapes(ActionEvent event) {

        // connects to canvas and clears it
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // draws shapes
        for (int i = 0; i < 10; i++) {
            int shape = randomizer.nextInt(3); // 0,1,2 -> Line, Oval, Rectangle
            gc.setFill(Color.rgb(randomizer.nextInt(256), randomizer.nextInt(256), randomizer.nextInt(256)));

            // x,y starting point without futre out of bounds
            int x1 = randomizer.nextInt((int) canvas.getWidth() - (int) canvas.getWidth() / regions);
            int y1 = randomizer.nextInt((int) canvas.getHeight() - (int) canvas.getHeight() / regions);

            // x2, y2 end point, without leaving the box boundries
            int x2 = randomizer.nextInt((int) canvas.getWidth() / regions);
            int y2 = randomizer.nextInt((int) canvas.getHeight() / regions);
            switch (shape) {
                case 0:
                    int a = randomizer.nextInt(x1 + x2); // line that contained in box
                    int b = randomizer.nextInt(y1 + y2);// line that contained in box
                    gc.strokeLine(x1, y1, a, b);
                    break;
                case 1:
                    gc.fillOval(x1, y1, x2, y2);
                    break;
                case 2:
                    gc.fillRect(x1, y1, x2, y2);

            }

        }

    }
}
