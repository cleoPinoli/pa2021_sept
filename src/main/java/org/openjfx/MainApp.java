package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");

        Group group = new Group();

        /*MoveTo moveTo = new MoveTo(50, 100);
        HLineTo hlineTo = new HLineTo(70);
        QuadCurveTo quadCurveTo = new QuadCurveTo(120, 360, 100, 0);
        LineTo lineTo = new LineTo(175, 55);
        ArcTo arcTo = new ArcTo();
        arcTo.setX(50);
        arcTo.setY(50);
        arcTo.setRadiusX(50);
        arcTo.setRadiusY(50);

        ClosePath closePath = new ClosePath();

        Path path = new Path(moveTo, hlineTo, quadCurveTo, lineTo, arcTo, closePath);
        path.setFill(Color.LIGHTSALMON);

        group.getChildren().add(path);*/

        Scene scene = new Scene(group, 1366, 768, Color.AZURE);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}