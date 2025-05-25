/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sayda
 */
public class VentanaCambiarEstado extends JFrame {
    private JTextField txtTicketNumero;
    private JComboBox<String> comboEstado;

    public VentanaCambiarEstado() {
        setTitle("Cambiar Estado Ticket");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("N° Ticket:");
        lblNumero.setBounds(30, 30, 100, 25);
        add(lblNumero);

        txtTicketNumero = new JTextField();
        txtTicketNumero.setBounds(120, 30, 130, 25);
        add(txtTicketNumero);

        JLabel lblEstado = new JLabel("Nuevo Estado:");
        lblEstado.setBounds(30, 70, 100, 25);
        add(lblEstado);

        comboEstado = new JComboBox<>(new String[] {"PENDIENTE", "EN_PROCESO", "RESUELTO"});
        comboEstado.setBounds(120, 70, 130, 25);
        add(comboEstado);

        JButton btnCambiar = new JButton("Cambiar");
        btnCambiar.setBounds(90, 120, 100, 30);
        add(btnCambiar);

        btnCambiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = txtTicketNumero.getText();
                String estado = (String) comboEstado.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Estado del ticket N° " + numero + " cambiado a " + estado);
                dispose();
            }
        });
    }
}

