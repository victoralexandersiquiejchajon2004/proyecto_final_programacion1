/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class TecnicoDAO {
    private Connection conn;

    public TecnicoDAO(Connection conn) {
        this.conn = conn;
    }

    public void crear(Tecnico t) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO tecnicos(nombre, usuario, contrasena, especialidad) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getUsuario());
            ps.setString(3, t.getContrasena());
            ps.setString(4, t.getEspecialidad());
            ps.executeUpdate();
        } catch (Exception e) {
            error("crear", e);
        }
    }

    public List<Tecnico> listar() {
        List<Tecnico> lista = new ArrayList<>();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM tecnicos")) {
            while (rs.next()) {
                lista.add(new Tecnico(
                        rs.getString("nombre"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("especialidad")));
            }
        } catch (Exception e) {
            error("listar", e);
        }
        return lista;
    }

    public void actualizar(Tecnico t) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE tecnicos SET nombre=?, contrasena=?, especialidad=? WHERE usuario=?")) {
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getContrasena());
            ps.setString(3, t.getEspecialidad());
            ps.setString(4, t.getUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            error("actualizar", e);
        }
    }

    public void eliminar(String usuario) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM tecnicos WHERE usuario=?")) {
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

