import Controllers.ControladorLogin;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main extends Application {


    Parent root;
    Scene scene;
    Pane panel;
    Pane panelMinimize;
    Pane panelClose;
    Node buttonAcceder;
    Node buttonFacebook;
    Node buttonGoogle;
    Node buttonTwitter;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("View/Login.fxml"));
        primaryStage.setTitle("Yicar");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        primaryStage.setResizable(false);


        ControladorLogin co = new ControladorLogin(primaryStage);
        co.arrastrarMenu();
        co.minimizePanel();
        co.closePanel();
        co.socialNetworks();


    }




    public static void main(String[] args) {
        launch(args);
    }

}
