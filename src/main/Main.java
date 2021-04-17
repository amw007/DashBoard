package main;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.preloader.myPreloader;
import sun.misc.Launcher;

import java.util.Objects;

public class Main extends Application {
    private double xOffset,yOffset;
    private int c = 50000;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("favicon.ico"))));
        primaryStage.setTitle("My DashBoard");
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset=event.getSceneX();
                yOffset=event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX()-xOffset);
                primaryStage.setY(event.getScreenY()-yOffset);
            }
        });
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @Override
    public void init() throws Exception {
        for (int i = 0; i < c; i++) {
            int p = i/c;
            LauncherImpl.notifyPreloader(this,new Preloader.ProgressNotification(p));
        }
    }

    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, myPreloader.class,args);
//        launch(args);
    }
}
