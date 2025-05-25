/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TicketDAO {
    private Connection conn;

    public TicketDAO(Connection conn) {
        this.conn = conn;
    }

    public void crear(Ticket t) {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tickets(numero, titulo, descripcion, prioridad, estado, creador, fechacreacion) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, t.getNumero());
            ps.setString(2, t.getTitulo());
            ps.setString(3, t.getDescripcion());
            ps.setString(4, t.getPrioridad());
            ps.setString(5, t.getEstado().name());
            ps.setString(6, t.getCreador().getUsuario());
            ps.setTimestamp(7, Timestamp.valueOf(t.getFechaCreacion()));
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("crear", e);
        }
    }

    public List<Ticket> listar() {
        List<Ticket> lista = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM tickets")) {
            while (rs.next()) {
                UsuarioFinal creador = new UsuarioFinalDAO(conn).buscarPorUsuario(rs.getString("creador"));
                Ticket t = new Ticket(
                        rs.getString("numero"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getString("prioridad"),
                        EstadoTicket.valueOf(rs.getString("estado")),
                        creador,
                        rs.getTimestamp("fechacreacion").toLocalDateTime()
                );
                lista.add(t);
            }
        } catch (Exception e) {
            mostrarError("listar", e);
        }
        return lista;
    }

    public void actualizar(Ticket t) {
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE tickets SET titulo=?, descripcion=?, prioridad=?, estado=? WHERE numero=?")) {
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getDescripcion());
            ps.setString(3, t.getPrioridad());
            ps.setString(4, t.getEstado().name());
            ps.setString(5, t.getNumero());
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("actualizar", e);
        }
    }

    public void eliminar(String numero) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM tickets WHERE numero=?")) {
            ps.setString(1, numero);
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("eliminar", e);
        }
    }

    private void mostrarError(String metodo, Exception e) {
        JOptionPane.showMessageDialog(null, "Error en TicketDAO - " + metodo + ": " + e.getMessage());
    }
}