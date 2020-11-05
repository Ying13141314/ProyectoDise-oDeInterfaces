package Controllers.Venta;

import Controllers.AbstractControlador;
import DAO.ClientesDAO;
import DAO.VehiculoDAO;
import Models.Cliente;
import Models.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class ControladorVentaVehiculo extends AbstractControlador {

    @FXML
    TextField tfMarca;
    @FXML
    TextField tfModelo;
    @FXML
    TextField tfNumeroPuertas;
    @FXML
    DatePicker dpFechaEntrada;
    @FXML
    TextField tfPrecio;
    @FXML
    Button buttonCancelar;
    @FXML
    Button buttonAceptar;

    public void changeScene(ActionEvent e) throws IOException, SQLException {
        String ruta = "";
        if(e.getSource().equals(buttonCancelar)) {
            ruta = "/View/Venta.fxml";

        } else if (e.getSource().equals(buttonAceptar)){
            HashMap<String,Object> vehiculo = new HashMap<>();
            vehiculo.put("Marca", tfMarca.getText());
            vehiculo.put("Modelo", tfModelo.getText());
            vehiculo.put("NumeroPuertas", tfNumeroPuertas.getText());
            vehiculo.put("Precio", tfPrecio.getText());
            vehiculo.put("Fecha", dpFechaEntrada.getValue().toString());


            Vehiculo v = new Vehiculo(vehiculo);
            VehiculoDAO vdao = new VehiculoDAO();
            vdao.crearVehiculo(v);

            ruta = "/View/Venta.fxml";
        }
        FXMLLoader pane = new FXMLLoader(getClass().getResource(ruta));
        miApp.getPrimaryStage().setScene(new Scene(pane.load(), 1280, 720));

        ControladorVenta co = pane.getController();
        co.setMiApp(miApp);
    }


}
