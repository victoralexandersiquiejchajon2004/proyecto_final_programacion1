/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

/**
 *
 * @author Sayda
 */
class Administrador extends Persona {
    public Administrador(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena, new Rol("Administrador", "Acceso total"));
    }

    String getContrasena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}