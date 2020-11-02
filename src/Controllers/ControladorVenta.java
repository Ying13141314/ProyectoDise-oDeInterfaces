package Controllers;

import DAO.UsuarioDAO;
import Indice.Main;
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

    UsuarioDAO miUsuario = new UsuarioDAO();


    public ControladorVenta() {
        System.out.println("holaaaaaaaaaa");
    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }
}
