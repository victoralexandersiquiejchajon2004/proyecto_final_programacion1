/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sayda
 */
public class GestorDatos {
    private static List<UsuarioFinal> usuarios = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();

    public static void agregarUsuario(UsuarioFinal usuario) {
        usuarios.add(usuario);
    }

    public static List<UsuarioFinal> getUsuarios() {
        return usuarios;
    }

    public static void agregarTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public static List<Ticket> getTickets() {
        return tickets;
    }

    public static void agregarDepartamento(Departamento d) {
        departamentos.add(d);
    }

    public static List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
