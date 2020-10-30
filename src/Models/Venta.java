package Models;

import DAO.AbstractDAO;
import Utils.tipoUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Venta extends AbstractUsuario{

    private int idVenta;

    public Venta(ResultSet rs) throws SQLException {
        super(rs);

    }





}
