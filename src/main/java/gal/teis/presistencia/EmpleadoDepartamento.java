/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.presistencia;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Esther Ferreiro
 */
public class EmpleadoDepartamento {
    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private Double sueldo;
    
    private int idDireccion;
    private String direccion;
    private String ciudad;

    public EmpleadoDepartamento(int idEmpleado, String nombre, String apellidos, Double sueldo, int idDireccion, String direccion, String ciudad) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "EmpleadoDepartamento{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sueldo=" + sueldo + ", idDireccion=" + idDireccion + ", direccion=" + direccion + ", ciudad=" + ciudad + '}';
    }
    
    
   
}
