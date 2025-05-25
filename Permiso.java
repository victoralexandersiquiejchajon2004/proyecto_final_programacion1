/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.io.Serializable;

/**
 *
 * @author Sayda
 */
class Permiso implements Serializable {
    private String nombre;
    private String descripcion;

    public Permiso(String nombre, String descripcion) {
        if (nombre == null || nombre.length() < 3 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre del permiso debe tener entre 3 y 50 caracteres.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String toString() {
        return nombre;
    }
}


