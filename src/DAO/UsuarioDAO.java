package DAO;

import Models.AbstractUsuario;
import Models.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends AbstractDAO {

    @Override
    public Connection conectar() {
        return super.conectar();
    }

    @Override
    public void cerrarBasesDatos() {
        super.cerrarBasesDatos();
    }


    public AbstractUsuario comprobarContrasenaUsuario(String pass,String user) throws SQLException {
        String sql = "SELECT * from Usuario where contrasena = ? and nombreUsuario=?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,pass);
        ps.setString(2,user);
        ResultSet rs = ps.executeQuery();

        return AbstractUsuario.tipo(rs);

    }
}
