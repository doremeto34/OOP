package hust.soict.hedspi.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	Color penColor = Color.BLACK;
	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void penSelect(ActionEvent event) {
    	penColor = Color.BLACK;
    }
    
    @FXML
    void eraserSelect(ActionEvent event) {
    	penColor = Color.WHITE;
    }
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(),event.getY(),4,penColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }

}
