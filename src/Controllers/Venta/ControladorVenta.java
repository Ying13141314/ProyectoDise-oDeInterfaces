package Controllers.Venta;

import Controllers.AbstractControlador;
import Models.AbstractUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ControladorVenta extends AbstractControlador {

    @FXML
    Button buttonVehiculoConcesionario;
    @FXML
    Button buttonFichaCliente;
    @FXML
    Button buttonRegistrarCliente;
    @FXML
    Button buttonPropuestaVenta;

    AbstractUsuario miUsuario;

    public ControladorVenta() {
    }

    public void changeScene(ActionEvent e) throws IOException {
        String ruta = "";
        if (e.getSource().equals(buttonRegistrarCliente)) {
            ruta = "/View/VentaAltaCliente.fxml";

        } else if (e.getSource().equals(buttonFichaCliente)){
            ruta = "/View/FichaCliente.fxml";
        } else if (e.getSource().equals(buttonPropuestaVenta)){
            ruta = "/View/VentaVehiculo.fxml";
        }
        FXMLLoader pane = new FXMLLoader(getClass().getResource(ruta));
        miApp.getPrimaryStage().setScene(new Scene(pane.load(), 1280, 720));

        AbstractControlador co = pane.getController();
        co.setMiApp(miApp);
        //co.cargarDesplegables();

    }


}