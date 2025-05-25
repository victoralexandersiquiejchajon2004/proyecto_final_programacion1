/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class AsignacionTicketDAO {
    private Connection conn;

    public AsignacionTicketDAO(Connection conn) {
        this.conn = conn;
    }

    public void asignarTicket(String ticketNumero, String tecnicoUsuario) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO asignaciontickets(ticket_numero, tecnico_usuario) VALUES (?, ?);")) {
            ps.setString(1, ticketNumero);
            ps.setString(2, tecnicoUsuario);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al asignar ticket: " + e.getMessage());
        }
    }

    public List<String> listarAsignaciones() {
        List<String> lista = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM asignaciontickets")) {
            while (rs.next()) {
                lista.add("Ticket: " + rs.getString("ticket_numero") + " - Técnico: " + rs.getString("tecnico_usuario"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar asignaciones: " + e.getMessage());
        }
        return lista;
    }

    public void eliminarAsignacion(String ticketNumero) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM asignaciontickets WHERE ticket_numero=?")) {
            ps.setString(1, ticketNumero);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar asignación: " + e.getMessage());
        }
    }
}