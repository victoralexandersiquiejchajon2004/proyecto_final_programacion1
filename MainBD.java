/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author Sayda
 */
public class MainBD {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conn = (Connection) conexion.getConexion();

        if (conn != null) {
            UsuarioFinalDAO dao = new UsuarioFinalDAO((java.sql.Connection) conn);

            // Crear usuario
            UsuarioFinal usuario = new UsuarioFinal("Ana López", "analopez", "clave123");
            dao.crear(usuario);

            // Listar todos los usuarios
            for (UsuarioFinal u : dao.listar()) {
                System.out.println("Usuario: " + u.getUsuario() + " - Nombre: " + u.getNombre());
            }

            // Actualizar usuario
            usuario.setNombre("Ana María López");
            usuario.setContrasena("claveActualizada");
            dao.actualizar(usuario);

            // Eliminar usuario
            // dao.eliminar("analopez");
        }
    }
}