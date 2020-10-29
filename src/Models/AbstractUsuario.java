package Models;

import Utils.tipoUsuario;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractUsuario {

    //Estado
    protected String id,nombre,apellido,nombreUsuario,contrasena,telefono,correo,dni;
    protected Double salario;
    protected tipoUsuario tipo;


    //Constructor
    public AbstractUsuario(ResultSet rs) throws SQLException {
        id = rs.getNString("idUsuario");
        nombre= rs.getNString("nombre");
        apellido = rs.getNString("apellido");
        nombreUsuario=rs.getNString("nombreUsuario");
        contrasena=rs.getNString("contrasena");
        telefono=rs.getNString("telefono");
        correo = rs.getNString("correo");
        dni = rs.getNString("dni");
        salario = rs.getNString("salario");
        tipo = rs.getNString("tipo");
        
    }
    public static AbstractUsuario tipo(ResultSet rs){

    }




}
