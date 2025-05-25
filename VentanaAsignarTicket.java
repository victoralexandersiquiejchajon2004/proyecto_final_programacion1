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
public class VentanaAsignarTicket extends JFrame {
    private JTextField txtNumeroTicket, txtDepartamento;
    private GestorTickets gestorTickets;

    public VentanaAsignarTicket(GestorTickets gestor) {
        this.gestorTickets = gestor;

        setTitle("Asignar Ticket a Departamento");
        setSize(350, 220);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número Ticket:");
        lblNumero.setBounds(30, 30, 120, 25);
        add(lblNumero);

        txtNumeroTicket = new JTextField();
        txtNumeroTicket.setBounds(150, 30, 150, 25);
        add(txtNumeroTicket);

        JLabel lblDepto = new JLabel("Departamento:");
        lblDepto.setBounds(30, 70, 120, 25);
        add(lblDepto);

        txtDepartamento = new JTextField();
        txtDepartamento.setBounds(150, 70, 150, 25);
        add(txtDepartamento);

        JButton btnAsignar = new JButton("Asignar");
        btnAsignar.setBounds(110, 120, 120, 30);
        add(btnAsignar);

        btnAsignar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = txtNumeroTicket.getText().trim();
                String departamentoNombre = txtDepartamento.getText().trim();

                if(numero.isEmpty() || departamentoNombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos.");
                    return;
                }

                Ticket ticket = gestorTickets.buscarPorNumero(numero);
                if(ticket == null) {
                    JOptionPane.showMessageDialog(null, "Ticket no encontrado.");
                    return;
                }

                String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción del departamento:");
                if (descripcion == null || descripcion.trim().isEmpty()) {
                    descripcion = "Sin descripción";
                }

                try {
                    Departamento dept = new Departamento(departamentoNombre, descripcion);
                    ticket.setDepartamento(dept);
                    ticket.setEstado(EstadoTicket.ASIGNADO);

                    JOptionPane.showMessageDialog(null, "Ticket asignado al departamento: " + departamentoNombre);
                    dispose();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}