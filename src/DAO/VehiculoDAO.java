package DAO;

import Models.AbstractUsuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculoDAO extends AbstractDAO {

    /**
     * Método para insertar un vehiculo en la Base de Datos.
     * @param marca
     * @param modelo
     * @param numeroPuertas
     * @param vendido
     * @param fechaEntrada
     * @throws SQLException
     */
    public void crearVehiculo(String marca, String modelo, int numeroPuertas, boolean vendido, String fechaEntrada) throws SQLException {

        super.conectar();

        //
        String query = "INSERT INTO vehiculo (marca,modelo,numeroPuertas,vendido,fechaEntrada) " + "VALUES (?,?,?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ps.setString(1, marca);
        ps.setString(2, modelo);
        ps.setInt(3, numeroPuertas);
        ps.setBoolean(4, vendido);
        ps.setString(5, fechaEntrada);
        ps.executeUpdate();

        super.cerrarBasesDatos();
    }
}
