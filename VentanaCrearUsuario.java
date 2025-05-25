/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class VentanaCrearUsuario extends JFrame {
    private JTextField txtNombre, txtUsuario, txtContrasena;

    public VentanaCrearUsuario() {
        setTitle("Crear Usuario");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 30, 130, 25);
        add(txtNombre);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 70, 100, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 70, 130, 25);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 110, 100, 25);
        add(lblContrasena);

        txtContrasena = new JTextField();
        txtContrasena.setBounds(120, 110, 130, 25);
        add(txtContrasena);

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(90, 160, 100, 30);
        add(btnCrear);

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String usuario = txtUsuario.getText();
                String contrasena = txtContrasena.getText();

                try {
                    Connection conn = new Conexion().getConexion();
                    String sql = "INSERT INTO usuarios (nombre, usuario, contrasena) VALUES (?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, nombre);
                    stmt.setString(2, usuario);
                    stmt.setString(3, contrasena);

                    int rows = stmt.executeUpdate();

                    if (rows > 0) {
                        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo crear el usuario.");
                    }

                    conn.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }
}