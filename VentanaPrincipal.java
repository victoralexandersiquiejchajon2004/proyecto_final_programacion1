/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Sayda
 */
public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Sistema de Tickets");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setBounds(100, 30, 200, 30);
        add(btnCrearUsuario);

        JButton btnCrearTicket = new JButton("Crear Ticket");
        btnCrearTicket.setBounds(100, 70, 200, 30);
        add(btnCrearTicket);

        JButton btnVerTickets = new JButton("Ver Tickets");
        btnVerTickets.setBounds(100, 110, 200, 30);
        add(btnVerTickets);

        JButton btnEditarTicket = new JButton("Editar Ticket");
        btnEditarTicket.setBounds(100, 150, 200, 30);
        add(btnEditarTicket);

        JButton btnReporteTickets = new JButton("Reporte de Tickets");
        btnReporteTickets.setBounds(100, 190, 200, 30);
        add(btnReporteTickets);

        // Eventos
        btnCrearUsuario.addActionListener(e -> new VentanaCrearUsuario().setVisible(true));
        btnCrearTicket.addActionListener(e -> new VentanaCrearTicket().setVisible(true));
        btnVerTickets.addActionListener(e -> new VentanaVerTickets().setVisible(true));
        btnEditarTicket.addActionListener(e -> new VentanaEditarTicket().setVisible(true));
        btnReporteTickets.addActionListener(e -> new VentanaReporteTickets().setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}