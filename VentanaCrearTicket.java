/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VentanaCrearTicket extends JFrame {
    private JTextField txtTitulo, txtDescripcion, txtPrioridad;

    public VentanaCrearTicket() {
        setTitle("Crear Ticket");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 30, 100, 25);
        add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 30, 130, 25);
        add(txtTitulo);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(30, 70, 100, 25);
        add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(120, 70, 130, 25);
        add(txtDescripcion);

        JLabel lblPrioridad = new JLabel("Prioridad:");
        lblPrioridad.setBounds(30, 110, 100, 25);
        add(lblPrioridad);

        txtPrioridad = new JTextField();
        txtPrioridad.setBounds(120, 110, 130, 25);
        add(txtPrioridad);

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(90, 160, 100, 30);
        add(btnCrear);

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                String descripcion = txtDescripcion.getText();
                String prioridad = txtPrioridad.getText();
                String creadorUsuario = JOptionPane.showInputDialog("Usuario creador (id):");

                try {
                    Connection conn = new Conexion().getConexion();
                    String sql = "INSERT INTO tickets (titulo, descripcion, prioridad, estado, creador_id, fecha_creacion) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, titulo);
                    stmt.setString(2, descripcion);
                    stmt.setString(3, prioridad);
                    stmt.setString(4, "Abierto");
                    stmt.setInt(5, Integer.parseInt(creadorUsuario));
                    stmt.setTimestamp(6, java.sql.Timestamp.valueOf(LocalDateTime.now()));

                    int rows = stmt.executeUpdate();

                    if (rows > 0) {
                        JOptionPane.showMessageDialog(null, "Ticket creado exitosamente.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo crear el ticket.");
                    }

                    conn.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}