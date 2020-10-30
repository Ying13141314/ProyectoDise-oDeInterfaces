package Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControladorLogin {


    @FXML
    private Pane panelMinimize,panelClose,panel;
    private Node buttonAcceder,buttonInstagram,buttonTwitter,buttonFacebook;
    private Stage primaryStage;
    private Scene scene;

    public ControladorLogin(Stage primaryStage){
       this.primaryStage = primaryStage;
        scene = primaryStage.getScene();
        panel = (Pane) scene.lookup("#panelDrag");
        panelMinimize = (Pane) scene.lookup("#panelMinimize");
        panelClose = (Pane) scene.lookup("#panelClose");
        buttonAcceder = scene.lookup("#buttonAcceder");
        buttonFacebook = scene.lookup("#buttonFacebook");
        buttonInstagram = scene.lookup("#buttonInstagram");
        buttonTwitter = scene.lookup("#buttonTwitter");
    }

    @FXML
    public void arrastrarMenu(){
        panel.setOnMousePressed(pressEvent -> {
            panel.setOnMouseDragged(dragEvent -> {
                primaryStage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                primaryStage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
    }

    @FXML
    public void minimizePanel() {
        panelMinimize.setOnMouseEntered(entered -> {
            panelMinimize.setBackground(new Background(new BackgroundFill(Color.web("#dcdcdc"), CornerRadii.EMPTY, Insets.EMPTY)));
        });
        panelMinimize.setOnMouseExited(exited -> {
            panelMinimize.setBackground(new Background(new BackgroundFill(Color.web("#f0f1f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        });
        panelMinimize.setOnMouseClicked(minimize -> {
            primaryStage.setIconified(true);
        });
    }

    @FXML
    public void closePanel() {
        panelClose.setOnMouseEntered(entered -> {
            panelClose.setBackground(new Background(new BackgroundFill(Color.web("#dcdcdc"), CornerRadii.EMPTY, Insets.EMPTY)));
        });
        panelClose.setOnMouseExited(exited -> {
            panelClose.setBackground(new Background(new BackgroundFill(Color.web("#f0f1f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        });
        panelClose.setOnMouseClicked(close -> {
            Platform.exit();
        });
    }

    @FXML
    public void socialNetworks(){
        buttonFacebook.setOnMouseClicked(close -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        buttonInstagram.setOnMouseClicked(close -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        buttonTwitter.setOnMouseClicked(close -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }


}
