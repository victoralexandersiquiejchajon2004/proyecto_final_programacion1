/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Sayda
 */
public class UsuarioFinalDAO {
    private Connection conn;

    public UsuarioFinalDAO(Connection conn) {
        this.conn = conn;
    }

    public void crear(UsuarioFinal u) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO usuariosfinales(nombre, usuario, contrasena) VALUES (?, ?, ?)")) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getContrasena());
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("crear", e);
        }
    }

    public List<UsuarioFinal> listar() {
        List<UsuarioFinal> lista = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM usuariosfinales")) {
            while (rs.next()) {
                lista.add(new UsuarioFinal(
                    rs.getString("nombre"),
                    rs.getString("usuario"),
                    rs.getString("contrasena")));
            }
        } catch (Exception e) {
            mostrarError("listar", e);
        }
        return lista;
    }

    public void actualizar(UsuarioFinal u) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE usuariosfinales SET nombre=?, contrasena=? WHERE usuario=?")) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getContrasena());
            ps.setString(3, u.getUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("actualizar", e);
        }
    }

    public void eliminar(String usuario) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM usuariosfinales WHERE usuario=?")) {
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("eliminar", e);
        }
    }

    private void mostrarError(String metodo, Exception e) {
        JOptionPane.showMessageDialog(null, "Error en " + metodo + ": " + e.getMessage());
    }

    UsuarioFinal buscarPorUsuario(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}