package Controllers;

import Indice.Main;
import Models.AbstractUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorVentaAltaCliente {

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

    @FXML
    private void dragPanel(MouseEvent mouseEvent) {
        panel.setOnMouseDragged(dragEvent -> {
            miApp.getPrimaryStage().setX(dragEvent.getScreenX() - mouseEvent.getSceneX());
            miApp.getPrimaryStage().setY(dragEvent.getScreenY() - mouseEvent.getSceneY());
        });
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

    public void cargarDesplegables(){
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Hombre");
        generos.add("Mujer");
        ObservableList<String> list = FXCollections.observableArrayList(generos);
        cbSexo.setItems(list);

        ArrayList<String> aviso = new ArrayList<>();
        aviso.add("Email");
        aviso.add("SMS");
        ObservableList<String> list2 = FXCollections.observableArrayList(aviso);
        cbOpciones.setItems(list2);
    }

    public void setMiApp(Main miApp) {
        this.miApp = miApp;
    }

}