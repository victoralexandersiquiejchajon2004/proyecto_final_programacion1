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
// Caso de Uso 2: Crear y modificar usuarios con validaciones
abstract class Persona implements Serializable {
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected Rol rol;
    protected boolean activo;

    public Persona(String nombre, String usuario, String contrasena, Rol rol) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.activo = true;
    }

    public void desactivar() { this.activo = false; }
    public boolean estaActivo() { return activo; }
    public String getUsuario() { return usuario; }
    public Rol getRol() { return rol; }
    public String getNombre() { return nombre; }
}
