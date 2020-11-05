package Controllers.Venta;

import Controllers.AbstractControlador;
import Models.AbstractUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ControladorFichaVehiculo extends AbstractControlador {

    @FXML
    Button buttonCancelar;
    @FXML
    Button buttonAceptar;
    @FXML
    ChoiceBox cbSexo;
    @FXML
    ChoiceBox cbOpciones;
    @FXML
    Pane panel;



    AbstractUsuario miUsuario;

    public ControladorFichaVehiculo() {
    }

    // Para inicial cuando el xml ya esta ejecutando.
    @FXML
    public void initialize(){
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

}
