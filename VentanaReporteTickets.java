/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sayda
 */
public class VentanaReporteTickets extends JFrame {
    private JTextArea areaReporte;

    public VentanaReporteTickets() {
        setTitle("Reporte de Tickets");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        areaReporte = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaReporte);
        scroll.setBounds(20, 20, 340, 200);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(150, 230, 100, 25);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());

        // Simulación de generación de reporte
        List<Ticket> tickets = Arrays.asList(
            new Ticket("001", "Error sistema", "No abre app", "Alta", EstadoTicket.PENDIENTE, new UsuarioFinal("Juan", "juan", "123"), java.time.LocalDateTime.now()),
            new Ticket("002", "Falla de red", "Sin internet", "Media", EstadoTicket.EN_PROCESO, new UsuarioFinal("Ana", "ana", "123"), java.time.LocalDateTime.now())
        );

        for (Ticket t : tickets) {
            areaReporte.append("Ticket N°: " + t.getNumero() +
                                "\nTítulo: " + t.getTitulo() +
                                "\nEstado: " + t.getEstado() +
                                "\nPrioridad: " + t.getPrioridad() +
                                "\nUsuario: " + t.getCreador().getNombre() +
                                "\nFecha: " + t.getFechaCreacion() + "\n\n");
        }
    }
}

