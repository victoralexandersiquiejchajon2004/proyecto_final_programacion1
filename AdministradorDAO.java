/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class AdministradorDAO {
    private Connection conn;

    public AdministradorDAO(Connection conn) {
        this.conn = conn;
    }

    public void crear(Administrador a) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO administradores(nombre, usuario, contrasena) VALUES (?, ?, ?)")) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getUsuario());
            ps.setString(3, a.getContrasena());
            ps.executeUpdate();
        } catch (Exception e) {
            error("crear", e);
        }
    }

    public List<Administrador> listar() {
        List<Administrador> lista = new ArrayList<>();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM administradores")) {
            while (rs.next()) {
                lista.add(new Administrador(
                        rs.getString("nombre"),
                        rs.getString("usuario"),
                        rs.getString("contrasena")));
            }
        } catch (Exception e) {
            error("listar", e);
        }
        return lista;
    }

    public void actualizar(Administrador a) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE administradores SET nombre=?, contrasena=? WHERE usuario=?")) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getContrasena());
            ps.setString(3, a.getUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            error("actualizar", e);
        }
    }

    public void eliminar(String usuario) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM administradores WHERE usuario=?")) {
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (Exception e) {
            error("eliminar", e);
        }
    }

    private void error(String metodo, Exception e) {
        JOptionPane.showMessageDialog(null, "Error en " + metodo + ": " + e.getMessage());
    }
}
