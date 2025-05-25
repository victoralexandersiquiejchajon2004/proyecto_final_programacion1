/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DB = "javadb"; 
    private final String USER = "postgres";
    private final String PASSWORD = "alexander";

    public Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + HOST + ":" + PUERTO + "/" + DB;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "✅ Conexión exitosa a PostgreSQL");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "❌ No se encontró el driver de PostgreSQL. Asegúrate de agregar el archivo .jar al proyecto.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al conectar: " + e.getMessage());
        }
        return conexion;
    }
}