package org.openjfx;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;

import Commands.CmdClearPlane;
import Commands.Command;
import CorePackage.BasicParser;
import CorePackage.MyPlane;
import CorePackage.Program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {

    private Program myProgram;
    private MyPlane plane;
    @FXML
    private ScrollPane myPane;

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem resetButton;

    @FXML
    private MenuItem loadButton;

    @FXML
    private MenuItem exportButton;

    @FXML
    private MenuItem runNextButton;

    @FXML
    private MenuItem runProgramButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}


    @FXML
    private void handleResetAction (ActionEvent event) {
        CmdClearPlane cmdClear = new CmdClearPlane();
        cmdClear.execute(plane);
        myProgram.resetProgram();
    }

    @FXML
    private void handleLoadAction(ActionEvent event) {
        System.out.println("Executed");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        //Node node = (Node) event.getSource();
        File file = fileChooser.showOpenDialog(menuBar.getScene().getWindow());
         myProgram = new Program(new ArrayList<>(BasicParser.getParser().parseInstructions("/Test.txt"))); //TODO add a "parse" button?
    }

    @FXML
    private void handleExportAction (ActionEvent event) {

    }

    @FXML
    private void handleRunNextAction (ActionEvent event) {
            myProgram.runNextInstruction(plane);
    }

    @FXML
    private void handleRunProgramButton (ActionEvent event) {
        myProgram.runFrom(plane);
    }



    public ScrollPane getMyPane() {
        return myPane;
    }

    public void givePlane (MyPlane plane) {
        this.plane = plane;
    }
}
