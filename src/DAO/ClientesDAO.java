package DAO;
import Models.Cliente;
import Utils.ParseFecha;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO extends AbstractDAO {

   public void darAltaCliente(Cliente miCliente){
        super.conectar();
        String SSQL = "INSERT INTO cliente (nombre,apellido,dni,fechaNac,direccion,sexo,correo,telefono,tipoComunicacion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?)";
        try {
            if(!comprobarDni(miCliente.getDni())){

                PreparedStatement ps = conexion.prepareStatement(SSQL);
                ps.setString(1, miCliente.getNombre());
                ps.setString(2, miCliente.getApellido());
                ps.setString(3, miCliente.getDni());
                ps.setDate(4, java.sql.Date.valueOf(miCliente.getFechaNac()));
                ps.setString(5,miCliente.getDireccion());
                ps.setString(6,miCliente.getSexo());
                ps.setString(7,miCliente.getCorreo());
                ps.setString(8,miCliente.getTelefono());
                ps.setString(9,miCliente.getTipoComunicacion());

                ps.executeUpdate();
                System.out.println("Terminado");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Método donde actualiza los datos que me muestra por la pantalla.
     * @param miCliente
     */
    public void actualizarDatos(Cliente miCliente) {

        String SQL = "UPDATE cliente SET Nombre=?,apellido=?,dni=?,fechaNac=?,direccion=?,sexo=?,correo=?,telefono=?,tipoComunicacion=? where dni=?";

        ParseFecha fecha = new ParseFecha();

        try{
            PreparedStatement ps = conexion.prepareStatement(SQL);
            ps.setString(1, miCliente.getNombre());
            ps.setString(2, miCliente.getApellido());
            ps.setString(3, miCliente.getDni());
            ps.setDate(4, fecha.parse(miCliente.getFechaNac()));
            ps.setString(5, miCliente.getDireccion());
            ps.setString(6, miCliente.getSexo());
            ps.setString(7, miCliente.getCorreo());
            ps.setString(8, miCliente.getTelefono());
            ps.setString(9, miCliente.getTipoComunicacion());
            ps.executeUpdate();

            System.out.println("Actualizado");

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Método que comprueba el DNI ante de insertar un cliente.
     * @param miDni
     * @return
     * @throws SQLException
     */
    private boolean comprobarDni(String miDni) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement("select dni from cliente where dni=?");
        ps.setString(1, miDni);
        ResultSet rs = ps.executeQuery();
        return rs.isBeforeFirst();
    }


}
