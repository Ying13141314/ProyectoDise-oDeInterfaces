package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDAO {

    protected static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://localhost:3306/yicar?useSSL=false";
    protected static final String USUARIO = "root";
    protected static final String CLAVE = "123asd";
    protected static Connection conexion;

    /**
     * Conectar al bbdd.
     * @return
     */
    public Connection conectar() {

        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return conexion;
    }

    /**
     * Método que cierra el bbdd.
     */
    public void cerrarBasesDatos() {
        try {
            conexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
