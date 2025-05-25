/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sayda
 */
public class VentanaBuscarTicket extends JFrame {
    private JTextField txtBuscar;
    private JTextArea areaResultado;

    public VentanaBuscarTicket() {
        setTitle("Buscar Ticket");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblBuscar = new JLabel("Título o Usuario:");
        lblBuscar.setBounds(30, 20, 150, 25);
        add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(160, 20, 180, 25);
        add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(130, 60, 100, 25);
        add(btnBuscar);

        areaResultado = new JTextArea();
        areaResultado.setBounds(30, 100, 310, 130);
        add(areaResultado);

        btnBuscar.addActionListener(e -> {
            String criterio = txtBuscar.getText();
            areaResultado.setText("Ticket encontrado: " + criterio);
        });
    }
}
