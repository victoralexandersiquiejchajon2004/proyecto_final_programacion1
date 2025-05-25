/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

/**
 *
 * @author Sayda
 */
class UsuarioFinal extends Persona {
    public UsuarioFinal(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena, new Rol("Usuario", "Crea y consulta tickets"));
    }

    public String toString() {
        return nombre + " (Usuario)";
    }

    String getContrasena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setNombre(String victor_Alexander) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setContrasena(String nuevaClave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}