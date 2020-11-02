package Controllers;

import Indice.Main;
import Models.AbstractUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControladorVentaAltaCliente {

    //VentaAltaCliente.FXML
    @FXML
    Button buttonCancelar;
    @FXML
    Button buttonAceptar;

    private Main miApp;

    AbstractUsuario miUsuario;

    public ControladorVentaAltaCliente() {
    }

    public void changeScene(ActionEvent e) throws IOException {
        String ruta = "";
        if(e.getSource().equals(buttonCancelar)) {
            ruta = "/View/Venta.fxml";

        } else if (e.getSource().equals(buttonAceptar)){
            ruta = "/View/Venta.fxml";
        }
        FXMLLoader pane = new FXMLLoader(getClass().getResource(ruta));
        miApp.getPrimaryStage().setScene(new Scene(pane.load(), 1280, 720));

        ControladorVenta co = pane.getController();
        co.setMiApp(miApp);
    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }

}