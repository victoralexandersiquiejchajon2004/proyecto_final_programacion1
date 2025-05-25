/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class RolDAO {
    private Connection conn;

    public RolDAO(Connection conn) {
        this.conn = conn;
    }

    public void crear(Rol r) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO roles(nombre, descripcion) VALUES (?, ?)")) {
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("crear", e);
        }
    }

    public List<Rol> listar() {
        List<Rol> lista = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM roles")) {
            while (rs.next()) {
                lista.add(new Rol(
                        rs.getString("nombre"),
                        rs.getString("descripcion")));
            }
        } catch (Exception e) {
            mostrarError("listar", e);
        }
        return lista;
    }

    public void actualizar(Rol r) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE roles SET descripcion=? WHERE nombre=?")) {
            ps.setString(1, r.getDescripcion());
            ps.setString(2, r.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("actualizar", e);
        }
    }

    public void eliminar(String nombre) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM roles WHERE nombre=?")) {
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("eliminar", e);
        }
    }

    private void mostrarError(String metodo, Exception e) {
        JOptionPane.showMessageDialog(null, "Error en " + metodo + ": " + e.getMessage());
    }
}