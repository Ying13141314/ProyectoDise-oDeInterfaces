package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Jefe extends AbstractUsuario {
    public Jefe(ResultSet rs) throws SQLException {
        super(rs);
    }
}
