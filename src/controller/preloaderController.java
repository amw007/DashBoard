package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class preloaderController implements Initializable {

    @FXML
    private Label prog;

    public static Label label;
    @FXML
    private ProgressBar progBar;

    public static ProgressBar progressBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label = prog;
        progressBar = progBar;
    }
}
