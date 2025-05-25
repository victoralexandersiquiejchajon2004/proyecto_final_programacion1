/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class CategoriaDAO {
    private Connection conn;

    public CategoriaDAO(Connection conn) {
        this.conn = conn;
    }

    public void crearCategoria(String nombre, String descripcion) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO categorias(nombre, descripcion) VALUES (?, ?)")) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear categoría: " + e.getMessage());
        }
    }

    public List<String> listarCategorias() {
        List<String> lista = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM categorias")) {
            while (rs.next()) {
                lista.add(rs.getString("nombre") + " - " + rs.getString("descripcion"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar categorías: " + e.getMessage());
        }
        return lista;
    }

    public void eliminarCategoria(String nombre) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM categorias WHERE nombre=?")) {
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar categoría: " + e.getMessage());
        }
    }
}
