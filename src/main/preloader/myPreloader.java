package main.preloader;

import controller.preloaderController;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class myPreloader extends Preloader {
    private Stage stage;
    private Scene scene;

    @Override
    public void init() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("preloader.fxml")));
        scene=new Scene(root);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        if (info instanceof ProgressNotification){
            preloaderController.label.setText("Loading "+((ProgressNotification) info).getProgress()*100+"%");
            preloaderController.progressBar.setProgress(((ProgressNotification)info).getProgress());
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        StateChangeNotification.Type type=info.getType();
        switch (type){
            case BEFORE_START:
                System.out.println("Before_start");
                stage.hide();
                break;
        }
    }
}
