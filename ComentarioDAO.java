/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ComentarioDAO {
    private Connection conn;

    public ComentarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void agregarComentario(String ticketNumero, String autor, String texto) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO comentarios(ticket_numero, autor, texto) VALUES (?, ?, ?)")) {
            ps.setString(1, ticketNumero);
            ps.setString(2, autor);
            ps.setString(3, texto);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar comentario: " + e.getMessage());
        }
    }

    public List<String> listarComentarios(String ticketNumero) {
        List<String> lista = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM comentarios WHERE ticket_numero = ?")) {
            ps.setString(1, ticketNumero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("autor") + ": " + rs.getString("texto"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar comentarios: " + e.getMessage());
        }
        return lista;
    }

    public void eliminarComentario(int id) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM comentarios WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar comentario: " + e.getMessage());
        }
    }
}
