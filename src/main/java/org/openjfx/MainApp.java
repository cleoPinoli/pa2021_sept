package org.openjfx;

import Commands.Command;
import CorePackage.BasicParser;
import CorePackage.MyPlane;
import CorePackage.Program;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("org.openjfx/scene.fxml"));
        Parent root = loader.load();
        FXMLController controller = loader.getController();
        MyPlane plane = new MyPlane(1366, 768, controller.getMyPane());//Scene scene = new Scene(group, 1366, 768, Color.AZURE);
        controller.givePlane(plane);


        primaryStage.setTitle("Hello World");





        //new Program(new ArrayList<>(BasicParser.getParser().parseInstructions("/Test.txt"))).run(plane);

        //primaryStage.setScene(plane.getCanvas());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}