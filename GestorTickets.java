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

// Caso de Uso 10: Buscar y filtrar tickets
public class GestorTickets {
    private List<Ticket> tickets;

    public GestorTickets() {
        tickets = new ArrayList<>();
    }

    public void agregarTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> buscarPorEstado(EstadoTicket estado) {
        List<Ticket> resultado = new ArrayList<>();
        for (Ticket t : tickets) {
           if (t.getEstado().equals(estado)) {
    resultado.add(t);
               }
        }
        return resultado;
    }

    public List<Ticket> buscarPorPrioridad(String prioridad) {
        List<Ticket> resultado = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getPrioridad().equalsIgnoreCase(prioridad)) { // corregido: uso de getter
                resultado.add(t);
            }
        }
        return resultado;
    }

    public List<Ticket> buscarPorUsuario(String usuario) {
        List<Ticket> resultado = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getCreador().getUsuario().equalsIgnoreCase(usuario)) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    Ticket buscarPorNumero(String numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

