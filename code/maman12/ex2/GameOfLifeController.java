package code.maman12.ex2;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class GameOfLifeController {
    int Y_BOUND = 10;
    int X_BOUND = 10; 
    private int matrix[][] = new int[X_BOUND][Y_BOUND];

    @FXML
    private Button button;

    @FXML
    private Canvas canvas;

    @FXML
    void nextGen(ActionEvent event) {
        // shows the next generation
        if (!this.isNotEmptyGrid())
        {
            this.randomizeMatrix();
        }
        else
        {
            this.calculateMatrix();
        }
        this.colorByMatrix();

    }

    public void initialize() 
    {
        //initlize the matrix and the grid
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                matrix[i][j] = 0;
            }
        }
        createGrid();
    }

    private void createGrid() {
        // creates a line grid

        // connects to canvas and clears it
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // GraphicsContext gc = canvas.getGraphicsContext2D()/
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // vertical lines
        gc.setStroke(Color.BLUE);
        int x_jump_value = (int) canvas.getWidth() / X_BOUND;
        int y_jump_value = (int) canvas.getHeight() / Y_BOUND;

        for (int i = 0; i < canvas.getWidth(); i += x_jump_value) {
            gc.strokeLine(i, 0, i, canvas.getHeight() - (canvas.getHeight() % Y_BOUND));
        }

        // horizontal lines
        gc.setStroke(Color.RED);
        for (int i = 0; i < canvas.getHeight(); i += y_jump_value) {
            gc.strokeLine(0, i, canvas.getWidth(), i);
        }
    }

    public Boolean isNotEmptyGrid() 
    {
        // returns True if grid is not empty, false otherwise
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                if (matrix[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void colorByMatrix() {
        // color the grid based on the location matrix
        createGrid();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        int x_jump_value = (int) canvas.getWidth() / X_BOUND;
        int y_jump_value = (int) canvas.getHeight() / Y_BOUND;
        int x, y;
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                if (matrix[i][j] == 1) {
                    x = i * x_jump_value;
                    y = j * y_jump_value;

                    // color the rectangle
                    gc.fillRect(x, y, x_jump_value, y_jump_value);
                }
            }
        }

    }

    private void calculateMatrix()
    {
        // Calculate the next generation of the game

        int [][] tempMatrix = new int [X_BOUND][Y_BOUND];
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

    private int calculateCube(int x, int y){
        // calculate the next generation of a rectangle

        int neighbors;
        neighbors = getNeighborsCount(x, y);
        if (neighbors == 3)
        {
            return 1;
        }
        
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
    // creates a random starting point 

    {
        for (int i = 0; i < X_BOUND; i++) {
            for (int j = 0; j < Y_BOUND; j++) {
                matrix[i][j] = Math.round((float)Math.random());
            }
        }
    }

    private int getNeighborsCount(int x, int y){
        // returns the numbers of living neighbors
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
