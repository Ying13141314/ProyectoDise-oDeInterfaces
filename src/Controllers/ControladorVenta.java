package Controllers;

import DAO.UsuarioDAO;
import Indice.Main;
import Models.AbstractUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ControladorVenta {

    @FXML
    Button buttonVehiculoConcesionario;
    @FXML
    Button buttonFichaCliente;
    @FXML
    Button buttonRegistrarCliente;
    @FXML
    Button buttonPropuestaVenta;
    @FXML
    Pane panel;

    private Main miApp;

    AbstractUsuario miUsuario;

    public ControladorVenta() {
    }

    public void changeScene(ActionEvent e) throws IOException {
        String ruta = "";
        if (e.getSource().equals(buttonRegistrarCliente)) {
            ruta = "/View/VentaAltaCliente.fxml";
        }
        FXMLLoader pane = new FXMLLoader(getClass().getResource(ruta));
        miApp.getPrimaryStage().setScene(new Scene(pane.load(), 1280, 720));

        ControladorVentaAltaCliente co = pane.getController();
        co.setMiApp(miApp);
        co.cargarDesplegables();
    }

    @FXML
    private void shadowPane(MouseEvent e) {
        if (e.getSource() instanceof Pane) {
            Pane panel = (Pane) e.getSource();
            panel.setBackground(new Background(new BackgroundFill(Color.web("#ac914f"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    @FXML
    private void normalPane(MouseEvent e) {
        if (e.getSource() instanceof Pane) {
            Pane panel = (Pane) e.getSource();
            panel.setBackground(new Background(new BackgroundFill(Color.web("#e9c46a"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    @FXML
    private void dragPanel(MouseEvent mouseEvent) {
        panel.setOnMouseDragged(dragEvent -> {
            miApp.getPrimaryStage().setX(dragEvent.getScreenX() - mouseEvent.getSceneX());
            miApp.getPrimaryStage().setY(dragEvent.getScreenY() - mouseEvent.getSceneY());
        });
    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }
}