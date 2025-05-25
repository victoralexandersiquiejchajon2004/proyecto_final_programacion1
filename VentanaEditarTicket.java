/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sayda
 */
public class VentanaEditarTicket extends JFrame {
    private JTextField txtNumero, txtTitulo, txtDescripcion, txtPrioridad;

    public VentanaEditarTicket() {
        setTitle("Editar Ticket");
        setSize(320, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("N° Ticket:");
        lblNumero.setBounds(30, 30, 100, 25);
        add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 150, 25);
        add(txtNumero);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 70, 100, 25);
        add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 70, 150, 25);
        add(txtTitulo);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(30, 110, 100, 25);
        add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(120, 110, 150, 25);
        add(txtDescripcion);

        JLabel lblPrioridad = new JLabel("Prioridad:");
        lblPrioridad.setBounds(30, 150, 100, 25);
        add(lblPrioridad);

        txtPrioridad = new JTextField();
        txtPrioridad.setBounds(120, 150, 150, 25);
        add(txtPrioridad);

        JButton btnEditar = new JButton("Guardar");
        btnEditar.setBounds(100, 200, 100, 30);
        add(btnEditar);

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí iría la lógica para buscar el ticket por número y actualizarlo
                JOptionPane.showMessageDialog(null, "Ticket actualizado correctamente.");
                dispose();
            }
        });
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}