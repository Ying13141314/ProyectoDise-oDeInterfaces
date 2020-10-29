package Models;

import DAO.AbstractDAO;
import Utils.tipoUsuario;

public class Venta extends AbstractUsuario{

    private int idVenta;

    public Venta(String nombre, String apellido, String nombreUsuario, String contrasena, String telefono, String correo, String dni, Double salario, tipoUsuario tipo,int idVenta){
        super(nombre, apellido,nombreUsuario,contrasena,telefono,correo, dni,salario,tipo);
        tipo = tipo.venta;
    }





}
