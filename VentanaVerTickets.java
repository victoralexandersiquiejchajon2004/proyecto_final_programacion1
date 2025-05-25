/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentanaVerTickets extends JFrame {
    private JTextArea area;

    public VentanaVerTickets() {
        setTitle("Ver Tickets");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 340, 200);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(150, 230, 100, 25);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());

        try {
            Connection conn = new Conexion().getConexion();
            String sql = "SELECT titulo, descripcion, prioridad FROM tickets";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                area.append("Título: " + rs.getString("titulo") +
                            "\nDescripción: " + rs.getString("descripcion") +
                            "\nPrioridad: " + rs.getString("prioridad") + "\n\n");
            }
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar tickets: " + ex.getMessage());
        }
    }
}
