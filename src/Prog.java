/*
 * This is my program for a simple drawing interface
 * After comparing online forums, the interface on canvas can be improved
 */


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Prog extends Application {

	public static void main(String[] args) throws IOException {
		Application.launch(args);
	}

	public void start(final Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		ColorPicker cp = new ColorPicker(Color.BLUE);
		Slider slider = new Slider(1, 10, 4);
		Label labelBar = new Label();
		labelBar.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));
		root.setOnMouseDragged(e -> draw(e, root, cp, slider));
		HBox hb = new HBox();
		hb.getChildren().addAll(cp, slider, labelBar);
		root.setBottom(hb);

		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();

	}

	public void draw(MouseEvent e, BorderPane root, ColorPicker cp, Slider slider) {
		Double size = slider.getValue();
		Color color = cp.getValue();
		double getX = e.getX();
		double getY = e.getY();
		Circle dot = new Circle(getX, getY, size, color);
		root.getChildren().add(dot);
	}

}