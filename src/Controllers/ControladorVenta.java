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

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }

    public void changeScene(ActionEvent e) throws IOException {
        String ruta = "";
        if (e.getSource().equals(buttonRegistrarCliente)) {
            ruta = "/View/VentaAltaCliente.fxml";
            // } else if (e.getSource().equals(buttonCancelar)){
            //ruta = "/View/Venta.fxml";
            // }
            FXMLLoader pane = new FXMLLoader(getClass().getResource(ruta));
        }
    }
}