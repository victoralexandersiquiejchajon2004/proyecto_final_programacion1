/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class VentanaActualizarTicket extends JFrame {
    private JTextField txtNumero, txtEstado;

    public VentanaActualizarTicket() {
        setTitle("Actualizar Ticket");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(30, 30, 100, 25);
        add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 130, 25);
        add(txtNumero);

        JLabel lblEstado = new JLabel("Nuevo Estado:");
        lblEstado.setBounds(30, 70, 100, 25);
        add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(120, 70, 130, 25);
        add(txtEstado);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(90, 120, 120, 30);
        add(btnActualizar);

        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = txtNumero.getText();
                String estado = txtEstado.getText().toUpperCase();

                try (Connection conn = new Conexion().getConexion()) {
                    String sql = "UPDATE ticket SET estado = ? WHERE numero = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, estado);
                    stmt.setString(2, numero);
                    int rows = stmt.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(null, "Ticket actualizado correctamente");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un ticket con ese número");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}
