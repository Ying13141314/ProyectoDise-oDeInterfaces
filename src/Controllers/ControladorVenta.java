package Controllers;

import DAO.UsuarioDAO;
import Indice.Main;
import Models.AbstractUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
        this.miUsuario = miApp.getMiUsuario();
        System.out.println(miUsuario.toString());
    }

    public void changeScene(){

    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }
}
