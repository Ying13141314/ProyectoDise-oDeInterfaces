package Indice;

import Controllers.ControladorLogin;
import DAO.UsuarioDAO;
import Models.AbstractUsuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;
    private AbstractUsuario miUsuario;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        iniciarLogin();
    }

    private void iniciarLogin(){
        try {
            //Cargar toda la FXML y más.
            FXMLLoader logueader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
            primaryStage.setTitle("Yicar");
            primaryStage.setScene(new Scene(logueader.load(), 1280, 720));
            primaryStage.getScene().getStylesheets().add(getClass().getResource("/View/Resources/styleMain.css").toExternalForm());
            //Cargar el controlador
            ControladorLogin co = logueader.getController();
            //Para dar parametro al constructor.
            co.setMiApp(this);



            //Para mostrar la ventana por eso se pone al final.
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cambiarScene() throws IOException {
        //comprobar el tipo de usuario , segun cual es carga uno u otra.
        String ruta="";
        if(miUsuario.getTipo().equals(AbstractUsuario.VENTA)){
            ruta="/View/Venta.fxml";
        }else if (miUsuario.getTipo().equals(AbstractUsuario.MECANICO)){
            ruta="/View/Mecanico.fxml";
        }else{
            ruta="/View/Jefe.fxml";
        }
        Parent pane = FXMLLoader.load(getClass().getResource(ruta));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setMiUsuario(AbstractUsuario miUsuario) {
        this.miUsuario = miUsuario;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
