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
    protected static final String VENTA = "ventas";
    protected static final String JEFE = "jefe";
    protected static final String MECANICO = "mecanico";


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
        salario=rs.getDouble("salario");
        tipo = rs.getNString("tipo");

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




}
