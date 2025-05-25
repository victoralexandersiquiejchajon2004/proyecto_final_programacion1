/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sayda
 */
// Caso de Uso 3: Definir roles y permisos
class Rol implements Serializable {
    private String nombre;
    private String descripcion;
    private Set<Permiso> permisos;

    public Rol(String nombre, String descripcion) {
        setNombre(nombre);
        this.descripcion = descripcion;
        this.permisos = new HashSet<>();
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() < 3 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre del rol debe tener entre 3 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    public void agregarPermiso(Permiso permiso) {
        permisos.add(permiso);
    }

    public void quitarPermiso(Permiso permiso) {
        permisos.remove(permiso);
    }

    public String toString() {
        return nombre + " - " + descripcion;
    }

    String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}