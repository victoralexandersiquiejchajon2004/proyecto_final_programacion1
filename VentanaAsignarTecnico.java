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
public class VentanaAsignarTecnico extends JFrame {
    private JTextField txtTicketNumero, txtTecnicoNombre;

    public VentanaAsignarTecnico() {
        setTitle("Asignar Técnico");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTicket = new JLabel("N° Ticket:");
        lblTicket.setBounds(30, 30, 100, 25);
        add(lblTicket);

        txtTicketNumero = new JTextField();
        txtTicketNumero.setBounds(120, 30, 130, 25);
        add(txtTicketNumero);

        JLabel lblTecnico = new JLabel("Técnico:");
        lblTecnico.setBounds(30, 70, 100, 25);
        add(lblTecnico);

        txtTecnicoNombre = new JTextField();
        txtTecnicoNombre.setBounds(120, 70, 130, 25);
        add(txtTecnicoNombre);

        JButton btnAsignar = new JButton("Asignar");
        btnAsignar.setBounds(90, 120, 100, 30);
        add(btnAsignar);

        btnAsignar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = txtTicketNumero.getText();
                String tecnico = txtTecnicoNombre.getText();
                JOptionPane.showMessageDialog(null, "Técnico " + tecnico + " asignado al ticket N° " + numero);
                dispose();
            }
        });
    }
}
