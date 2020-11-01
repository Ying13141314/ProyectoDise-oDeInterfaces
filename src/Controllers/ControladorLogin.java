package Controllers;

import DAO.UsuarioDAO;
import Indice.Main;
import Models.AbstractUsuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



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




    UsuarioDAO miUsuario = new UsuarioDAO();


    public ControladorLogin(){
    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }

    @FXML
    private void initialize(){
        arrastrarMenu();
        minimizePanel();
        closePanel();
    }

    @FXML
    public void comprobarAcceder(ActionEvent evento) throws SQLException {

        if (tfUser.getText().equals("") || tfPassw.getText().equals("")){
            lbErrorPasswUser.setText("Contraseña o usuario no puede ser vacio");
            return;
        }
        AbstractUsuario usuario = miUsuario.loguearse(tfPassw.getText(),tfUser.getText());
        if (usuario==null){
            lbErrorPasswUser.setText("Contraseña o usuario incorrecta");
        }else {
            lbErrorPasswUser.setText("Logueado correctamente");
            miApp.setMiUsuario(usuario);

        }
    }
    
    @FXML
    private void arrastrarMenu(){
        panel.setOnMousePressed(pressEvent -> {
            panel.setOnMouseDragged(dragEvent -> {
                miApp.getPrimaryStage().setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                miApp.getPrimaryStage().setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
    }

    @FXML
    private void minimizePanel() {
        panelMinimize.setOnMouseEntered(entered -> {
            panelMinimize.setBackground(new Background(new BackgroundFill(Color.web("#dcdcdc"), CornerRadii.EMPTY, Insets.EMPTY)));
        });
        panelMinimize.setOnMouseExited(exited -> {
            panelMinimize.setBackground(new Background(new BackgroundFill(Color.web("#f0f1f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        });
        panelMinimize.setOnMouseClicked(minimize -> {
            miApp.getPrimaryStage().setIconified(true);
        });
    }

    @FXML
    private void closePanel() {
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
    private void socialNetworks(){
        buttonFacebook.setOnMouseClicked(close -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
        buttonInstagram.setOnMouseClicked(close -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
        buttonTwitter.setOnMouseClicked(close -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/3dsandcias/"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }
}
