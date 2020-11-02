package Models;

import Utils.tipoUsuario;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractUsuario {

    //Estado
    protected String id,nombre,apellido,nombreUsuario,contrasena,telefono,correo,dni,tipo;
    protected Double salario;
    public static final String VENTA = "venta";
    public static final String JEFE = "jefe";
    public static final String MECANICO = "mecanico";


    //Constructor
    public AbstractUsuario(ResultSet rs) throws SQLException {
        id = rs.getString("idUsuario");
        nombre= rs.getString("nombre");
        apellido = rs.getString("apellido");
        nombreUsuario=rs.getString("nombreUsuario");
        contrasena=rs.getString("contrasena");
        telefono=rs.getString("telefono");
        correo = rs.getString("correo");
        dni = rs.getString("dni");
        salario=rs.getDouble("salario");
        tipo = rs.getString("tipo");
        
    }
    public static AbstractUsuario tipo(ResultSet rs) throws SQLException {
        if (rs.getString("tipo").equals(VENTA)){
            return new Venta(rs);
        }else if(rs.getString("tipo").equals(JEFE)){
            return new Jefe(rs);
        }else if (rs.getString("tipo").equals(MECANICO)){
            return new Mecanico(rs);
        }
        return null;

    }

    public String getTipo() {
        return tipo;
    }
}
