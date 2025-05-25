/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
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
public class VentanaCambiarEstadoTicket extends JFrame {
    private JComboBox<String> comboEstado;

    public VentanaCambiarEstadoTicket() {
        setTitle("Cambiar Estado de Ticket");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblEstado = new JLabel("Nuevo Estado:");
        lblEstado.setBounds(30, 30, 100, 25);
        add(lblEstado);

        comboEstado = new JComboBox<>(new String[]{"PENDIENTE", "EN_PROCESO", "RESUELTO"});
        comboEstado.setBounds(130, 30, 120, 25);
        add(comboEstado);

        JButton btnCambiar = new JButton("Cambiar");
        btnCambiar.setBounds(90, 80, 100, 30);
        add(btnCambiar);

        btnCambiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String estadoStr = (String) comboEstado.getSelectedItem();
                EstadoTicket nuevoEstado = EstadoTicket.valueOf(estadoStr);
                Ticket ticket = new Ticket("T4", "Impresora", "Sin tinta", "Baja", EstadoTicket.PENDIENTE, new UsuarioFinal("Luis", "luis", "123"), LocalDateTime.now());
                ticket.setEstado(nuevoEstado);
                JOptionPane.showMessageDialog(null, "Nuevo estado del ticket: " + ticket.getEstado());
                dispose();
            }
        });
    }
}
