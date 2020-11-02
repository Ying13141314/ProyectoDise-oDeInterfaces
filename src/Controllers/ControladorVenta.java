package Controllers;

import DAO.UsuarioDAO;
import Indice.Main;
import Models.AbstractUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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
    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }
}