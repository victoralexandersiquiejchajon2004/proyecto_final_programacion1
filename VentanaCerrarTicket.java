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
public class VentanaCerrarTicket extends JFrame {
    private JTextField txtNumeroTicket;
    private GestorTickets gestorTickets;

    public VentanaCerrarTicket(GestorTickets gestor) {
        this.gestorTickets = gestor;

        setTitle("Cerrar Ticket");
        setSize(300, 180);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número Ticket:");
        lblNumero.setBounds(30, 30, 100, 25);
        add(lblNumero);

        txtNumeroTicket = new JTextField();
        txtNumeroTicket.setBounds(130, 30, 130, 25);
        add(txtNumeroTicket);

        JButton btnCerrar = new JButton("Cerrar Ticket");
        btnCerrar.setBounds(90, 80, 120, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = txtNumeroTicket.getText().trim();
                if(numero.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese el número del ticket.");
                    return;
                }

                Ticket ticket = gestorTickets.buscarPorNumero(numero);
                if(ticket == null) {
                    JOptionPane.showMessageDialog(null, "Ticket no encontrado.");
                    return;
                }

                ticket.setEstado(EstadoTicket.CERRADO);
                JOptionPane.showMessageDialog(null, "Ticket cerrado exitosamente.");
                dispose();
            }
        });
    }
}