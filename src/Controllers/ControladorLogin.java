package Controllers;

import DAO.UsuarioDAO;
import Indice.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;

import javafx.scene.LightBase;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class ControladorLogin {


    public ImageView ivClose;
    public ImageView ivMinimize;
    public Pane panelDrag;
    @FXML
    private Parent panel;
    @FXML
    private Pane panelClose;
    @FXML
    private TextField tfPassw;
    @FXML
    private TextField tfUser;
    @FXML
    private Button buttonTwitter;
    @FXML
    private Button buttonInstagram;
    @FXML
    private Button buttonFacebook;
    @FXML
    private Label lbErrorPasswUser;
    @FXML
    private Pane panelMinimize;

    private Main miApp;
    private Stage primaryStage;


    UsuarioDAO miUsuario = new UsuarioDAO();


    public ControladorLogin() {
    }

    public void setMiApp(Main miApp, Stage primaryStage) {
        this.miApp = miApp;
        this.primaryStage = primaryStage;
    }

    @FXML
    public void comprobarAcceder(ActionEvent e) throws SQLException, IOException {
        if (tfUser.getText().equals("") || tfPassw.getText().equals("")) {
            lbErrorPasswUser.setText("Los campos no pueden estar vacios.");
            cambiarScene();

        } else {
            miUsuario.loguearse(tfPassw.getText(), tfUser.getText());
            lbErrorPasswUser.setText("Logueado correctamente");
        }
    }

    private void cambiarScene() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/View/Mecanico.fxml"));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
    }

    @FXML
    private void dragPanel(MouseEvent e) {
        panel.setOnMouseDragged(dragEvent -> {
            miApp.getPrimaryStage().setX(dragEvent.getScreenX() - e.getSceneX());
            miApp.getPrimaryStage().setY(dragEvent.getScreenY() - e.getSceneY());
        });
    }

    @FXML
    private void minimizePanel(MouseEvent e) {
        if (e.getSource() instanceof Pane) {
            miApp.getPrimaryStage().setIconified(true);
        }
    }

    @FXML
    private void shadowPane(MouseEvent e) {
        if (e.getSource() instanceof Pane) {
            Pane panel = (Pane) e.getSource();
            panel.setBackground(new Background(new BackgroundFill(Color.web("#dcdcdc"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    @FXML
    private void normalPane(MouseEvent e) {
        if (e.getSource() instanceof Pane) {
            Pane panel = (Pane) e.getSource();
            panel.setBackground(new Background(new BackgroundFill(Color.web("#f0f1f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    @FXML
    private void closePanel(MouseEvent e) {
        if (e.getSource() instanceof Pane) {
            Platform.exit();
        }
    }

    @FXML
    private void socialNetworks(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            Button b = (Button) e.getSource();
            if (b.getText().equals("FACEBOOK")) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
                } catch (IOException | URISyntaxException a) {
                    a.printStackTrace();
                }
            } else if (b.getText().equals("FACEBOOK")) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
                } catch (IOException | URISyntaxException a) {
                    a.printStackTrace();
                }
            } else if (b.getText().equals("FACEBOOK")) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
                } catch (IOException | URISyntaxException a) {
                    a.printStackTrace();
                }
            }
        }
    }
}
