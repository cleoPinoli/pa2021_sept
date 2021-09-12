package org.openjfx;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Commands.CmdClearPlane;
import CorePackage.BasicParser;
import CorePackage.MyPlane;
import CorePackage.Program;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

public class FXMLController implements Initializable {

    private Program myProgram;
    private MyPlane plane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Pane canvas;

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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(menuBar.getScene().getWindow());
         myProgram = new Program(new ArrayList<>(BasicParser.getParser().parseInstructions(file.getPath()))); //TODO add a "parse" button?
    }

    @FXML
    private void handleExportAction (ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        File file = fileChooser.showSaveDialog(null);

        if(file != null){
            try {
                WritableImage image = new WritableImage(plane.getWidth(), plane.getHeight());
                plane.getCanvas().snapshot(new SnapshotParameters(), image);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(image, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }

    @FXML
    private void handleRunNextAction (ActionEvent event) {
            myProgram.runNextInstruction(plane);
    }

    @FXML
    private void handleRunProgramButton (ActionEvent event) {
        myProgram.runFrom(plane);
    }



    public Pane getPane() {
        return canvas;
    }

    public void givePlane (MyPlane plane) {
        this.plane = plane;
    }
}
