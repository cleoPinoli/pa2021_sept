package org.openjfx;

import CorePackage.MyPlane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("org.openjfx/scene.fxml"));
        Parent root = loader.load();
        FXMLController controller = loader.getController();
        MyPlane plane = new MyPlane(1366, 768, controller.getPane());
        controller.givePlane(plane);


        primaryStage.setTitle("Hello World");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}