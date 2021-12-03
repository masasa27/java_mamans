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
    private int matrix[][] = new int[10][10];
    int Y_BOUND = 10;
    int X_BOUND = 10; 

    @FXML
    private Button button;

    @FXML
    private Canvas canvas;

    @FXML
    void nextGen(ActionEvent event) {

        // connects to canvas and clears it
        if (!this.anyColor())
        {
            this.randomizeMatrix();
        }

        else
        {
            this.calculateMatrix();
            this.colorByMatrix();
        }

    }

    public void initialize() {
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                matrix[i][j] = 0;
            }
        }
        createGrid();
    }

    private void createGrid() {
        // connects to canvas and clears it
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // GraphicsContext gc = canvas.getGraphicsContext2D()/
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // vertical lines
        gc.setStroke(Color.BLUE);
        int x_jump_value = (int) canvas.getWidth() / 10;
        int y_jump_value = (int) canvas.getHeight() / 10;

        for (int i = 0; i < canvas.getWidth(); i += x_jump_value) {
            gc.strokeLine(i, 0, i, canvas.getHeight() - (canvas.getHeight() % 10));
        }

        // horizontal lines
        gc.setStroke(Color.RED);
        for (int i = 0; i < canvas.getHeight(); i += y_jump_value) {
            gc.strokeLine(0, i, canvas.getWidth(), i);
        }
    }

    public Boolean anyColor() {
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                if (matrix[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void colorCubeIndex(int x, int y, int color) {
        this.matrix[x][y] = color;
    }

    public void colorByMatrix() {
        createGrid();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int x_jump_value = (int) canvas.getWidth() / 10;
        int y_jump_value = (int) canvas.getHeight() / 10;
        int x, y;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrix[i][j] == 1) {
                    x = i * x_jump_value;
                    y = j * y_jump_value;
                    gc.fillRect(x, y, y + x_jump_value, x + y_jump_value);
                }
            }
        }

    }

    public void calculateMatrix()
    {
        int [][] tempMatrix = new int [10][10];
        // calculating the new matrix
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                tempMatrix[i][j] = calculateCube(i , j);
            }
        }

        // copy old matrix into new matrix
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }

    public int calculateCube(int x, int y){
        int neighbors;
        neighbors = getNeighborsCount(x, y);
        if (neighbors <= 1)
        {
            return 0;
        }
        if ((neighbors >= 2) && (neighbors <= 3))
        {
            return matrix[x][y];
        }
        return 0;

    }

    private void randomizeMatrix()
    {

    }

    public int getNeighborsCount(int x, int y){
        int n = 0;
        if (x - 1 >= 0){
            n += matrix[x - 1][y];
        }

        if (x + 1 < X_BOUND)
        {
            n +=  matrix[x + 1][y];
        }

        if (y - 1 >= 0){
            n += matrix[x][y - 1];
        }

        if (y + 1 < Y_BOUND){
            n += matrix[x][y + 1];
        }

        if ((x + 1 < X_BOUND) && (y + 1 < Y_BOUND))
        {
            n += matrix[x + 1][y + 1];
        }

        if ((x + 1 < X_BOUND) && (y - 1 >= 0))
        {
            n+= matrix[x + 1][y - 1];
        }
        if ((x - 1 >= 0) && (y + 1 < Y_BOUND))
        {
            n+= matrix[x - 1][y + 1];
        }
        if ((x - 1 >= 0) && (y - 1 >= 0))
        {
            n += matrix[x - 1][y - 1];
        }


        return n;
    }
}
