package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button closeBtn, miniBtn;
    @FXML
    private Button stdBtn;

    @FXML
    private Button teaBtn;

    @FXML
    private Button feeBtn;

    @FXML
    private Button userBtn;

    @FXML
    private Button setBtn;

    private MyListener myListener;

    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane rootpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip mini = new Tooltip();
        mini.setText("Minimize");
        miniBtn.setTooltip(mini);
        Tooltip close = new Tooltip();
        close.setText("Close");
        closeBtn.setTooltip(close);
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("/sample/home.fxml"));
//            AnchorPane anchorPane = fxmlLoader.load();
//            root.getChildren().setAll(anchorPane);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void click(ActionEvent actionEvent) {
        if (actionEvent.getSource() == stdBtn) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            loadFXML(fxmlLoader, "stdInfo");
            StdTableController s = fxmlLoader.getController();
            if (s.stdData.isEmpty()) {
                s.service();
            } else
                s.setData();

        } else if (actionEvent.getSource() == teaBtn) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            loadFXML(fxmlLoader, "teaInfo");
            TeaTableController s = fxmlLoader.getController();
            if (s.teaData.isEmpty()) {
                s.service();
            } else
                s.setData();
        }
//        else if (actionEvent.getSource() == feeBtn) {
//                        FXMLLoader fxmlLoader = new FXMLLoader();
//            loadFXML(fxmlLoader,"feeInfo");
//        } else if (actionEvent.getSource() == userBtn) {
//                        FXMLLoader fxmlLoader = new FXMLLoader();
//            loadFXML(fxmlLoader,"userInfo");
//        } else if (actionEvent.getSource() == setBtn) {
//                        FXMLLoader fxmlLoader = new FXMLLoader();
//            loadFXML(fxmlLoader,"setInfo");
//        }
    }

    public void close(ActionEvent event) {
        Stage s = (Stage) rootpane.getScene().getWindow();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.initModality(Modality.APPLICATION_MODAL);
        a.initOwner(s);
        a.getDialogPane().setHeaderText("Are Want to Exit?");

        Optional<ButtonType> res = a.showAndWait();
        if (res.get() == ButtonType.OK)
            System.exit(0);
        else
            a.close();
    }

    public void minimize(ActionEvent event) {
        Stage s = (Stage) rootpane.getScene().getWindow();
        s.setIconified(true);
    }

    public void loadHome(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        loadFXML(fxmlLoader, "home");
    }

    private void loadFXML(FXMLLoader fxmlLoader, String s) {
        try {
            fxmlLoader.setLocation(getClass().getResource("/main/" + s + ".fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            root.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
