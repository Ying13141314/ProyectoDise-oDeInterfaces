package Controllers.Venta;

import Controllers.AbstractControlador;
import DAO.ClientesDAO;
import Models.AbstractUsuario;
import Models.Cliente;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorVentaAltaCliente extends AbstractControlador {


    @FXML
    Pane panel;
    @FXML
    TextField tfNombre;
    @FXML
    TextField tfApellidos;
    @FXML
    TextField tfDNI;
    @FXML
    TextField tfDireccion;
    @FXML
    TextField tfEmail;
    @FXML
    TextField tfTelefono;
    @FXML
    TextField tfConfirmarEmail;
    @FXML
    TextField tfConfirmarTelefono;
    @FXML
    DatePicker dpFechaNacimiento;
    @FXML
    ChoiceBox cbSexo;
    @FXML
    ChoiceBox cbOpciones;
    @FXML
    Button buttonCancelar;
    @FXML
    Button buttonAceptar;

    AbstractUsuario miUsuario;

    public ControladorVentaAltaCliente() {
    }

    // Para inicial cuando el xml ya esta ejecutando.
    @FXML
    public void initialize(){
        cargarDesplegables();
    }

    public void changeScene(ActionEvent e) throws IOException, SQLException {
        String ruta = "";
        if(e.getSource().equals(buttonCancelar)) {
            ruta = "/View/Venta.fxml";

        } else if (e.getSource().equals(buttonAceptar)){
            HashMap<String,String> cliente = new HashMap<>();
            cliente.put("Nombre", tfNombre.getText());
            cliente.put("Apellidos", tfApellidos.getText());
            cliente.put("DNI", tfDNI.getText());
            cliente.put("Fecha", dpFechaNacimiento.getValue().toString());
            cliente.put("Direccion", tfDireccion.getText());
            cliente.put("Sexo", cbSexo.getSelectionModel().getSelectedItem().toString());
            cliente.put("Email", tfEmail.getText());
            cliente.put("Telefono", tfTelefono.getText());
            cliente.put("Opciones", cbOpciones.getSelectionModel().getSelectedItem().toString());

            Cliente c = new Cliente(cliente);
            ClientesDAO cdao = new ClientesDAO();
            cdao.darAltaCliente(c);

            ruta = "/View/Venta.fxml";
        }
        FXMLLoader pane = new FXMLLoader(getClass().getResource(ruta));
        miApp.getPrimaryStage().setScene(new Scene(pane.load(), 1280, 720));

        ControladorVenta co = pane.getController();
        co.setMiApp(miApp);
    }

    public void cargarDesplegables(){
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Hombre");
        generos.add("Mujer");
        ObservableList<String> list = FXCollections.observableArrayList(generos);
        cbSexo.setItems(list);

        ArrayList<String> aviso = new ArrayList<>();
        aviso.add("correo");
        aviso.add("sms");
        ObservableList<String> list2 = FXCollections.observableArrayList(aviso);
        cbOpciones.setItems(list2);
    }


}