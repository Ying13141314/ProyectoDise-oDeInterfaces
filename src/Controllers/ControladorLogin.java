package Controllers;

import DAO.UsuarioDAO;
import Indice.Main;
import Models.AbstractUsuario;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Collections;

public class ControladorLogin {

    @FXML
    private Parent panel;
    @FXML
    private PasswordField tfPassw;
    @FXML
    private TextField tfUser;
    @FXML
    private Label lbErrorPasswUser;

    private Main miApp;

    UsuarioDAO miUsuario = new UsuarioDAO();


    public ControladorLogin() {
    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }

    @FXML
    public void comprobarAcceder(ActionEvent e) throws SQLException, IOException {
        lbErrorPasswUser.setWrapText(true);
        if (tfUser.getText().equals("") || tfPassw.getText().equals("")) {
            lbErrorPasswUser.setText("Los campos no pueden estar vacios.");

        } else {
            AbstractUsuario au = miUsuario.loguearse(tfPassw.getText(), tfUser.getText());
            if (au == null) {
                setRed(tfUser);
                setRed(tfPassw);
                lbErrorPasswUser.setText("Información incorrecta. Tu contraseña y/o información de registro están equivocadas.");
            } else {
                miApp.setMiUsuario(au);
                removeRed(tfUser);
                removeRed(tfPassw);
                miApp.cambiarScene();
            }
        }
    }

    private void setRed(TextField tf) {
        ObservableList<String> styleClass = tf.getStyleClass();

        if(!styleClass.contains("tferror")) {
            styleClass.add("tferror");
        }
    }

    private void removeRed(TextField tf) {
        ObservableList<String> styleClass = tf.getStyleClass();
        styleClass.removeAll(Collections.singleton("tferror"));
    }

    @FXML
    private void dragPanel(MouseEvent mouseEvent) {
        panel.setOnMouseDragged(dragEvent -> {
            miApp.getPrimaryStage().setX(dragEvent.getScreenX() - mouseEvent.getSceneX());
            miApp.getPrimaryStage().setY(dragEvent.getScreenY() - mouseEvent.getSceneY());
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
            panel.setBackground(Background.EMPTY);
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
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));
                } catch (IOException | URISyntaxException a) {
                    a.printStackTrace();
                }
            } else if (b.getText().equals("GOOGLE")) {
                try {
                    Desktop.getDesktop().browse(new URI("https://google.com/"));
                } catch (IOException | URISyntaxException a) {
                    a.printStackTrace();
                }
            } else if (b.getText().equals("TWITTER")) {
                try {
                    Desktop.getDesktop().browse(new URI("https://twitter.com/"));
                } catch (IOException | URISyntaxException a) {
                    a.printStackTrace();
                }
            }
        }
    }
}
