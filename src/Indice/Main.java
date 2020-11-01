package Indice;

import Controllers.ControladorLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;

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

            //Cargar el controlador
            ControladorLogin co = logueader.getController();

            //Para dar parametro al constructor.
            co.setMiApp(this, primaryStage);

            //Para mostrar la ventana por eso se pone al final.

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
