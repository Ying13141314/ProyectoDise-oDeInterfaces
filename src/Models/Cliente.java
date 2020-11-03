package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {

    private StringProperty nombre,apellido,dni,fechaNac,direccion,sexo,correo,telefono,tipoComunicacion;

    public Cliente(ResultSet rs) throws SQLException {
        nombre = new SimpleStringProperty(rs.getString("nombre"));
        apellido = new SimpleStringProperty(rs.getString("apellido"));
        dni = new SimpleStringProperty(rs.getString("dni"));
        //.toLocalDate sale en formato español
        fechaNac = new SimpleStringProperty(rs.getDate("fechaNac").toLocalDate().toString());
        direccion = new SimpleStringProperty(rs.getString("direccion"));
        sexo = new SimpleStringProperty(rs.getString("sexo"));
        correo = new SimpleStringProperty(rs.getString("correo"));
        telefono = new SimpleStringProperty(rs.getString("telefono"));
        tipoComunicacion = new SimpleStringProperty(rs.getString("tipoComunicacion"));
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getApellido() {
        return apellido.get();
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }

    public String getDni() {
        return dni.get();
    }

    public StringProperty dniProperty() {
        return dni;
    }

    public String getFechaNac() {
        return fechaNac.get();
    }

    public StringProperty fechaNacProperty() {
        return fechaNac;
    }

    public String getDireccion() {
        return direccion.get();
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public String getSexo() {
        return sexo.get();
    }

    public StringProperty sexoProperty() {
        return sexo;
    }

    public String getCorreo() {
        return correo.get();
    }

    public StringProperty correoProperty() {
        return correo;
    }

    public String getTelefono() {
        return telefono.get();
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    public String getTipoComunicacion() {
        return tipoComunicacion.get();
    }

    public StringProperty tipoComunicacionProperty() {
        return tipoComunicacion;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac.set(fechaNac);
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public void setTipoComunicacion(String tipoComunicacion) {
        this.tipoComunicacion.set(tipoComunicacion);
    }
}

