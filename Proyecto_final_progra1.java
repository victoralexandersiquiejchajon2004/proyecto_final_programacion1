/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final_progra1;

import java.time.LocalDateTime;

/**
 *
 * @author Sayda
 */
public class Proyecto_final_progra1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

 UsuarioFinal usuario = new UsuarioFinal("Ana López", "analopez", "clave123");

        Ticket ticket = new Ticket(
                "1",
                "Problema con impresora",
                "La impresora no enciende",
                "Alta",
                EstadoTicket.PENDIENTE,
                usuario,
                LocalDateTime.now()
        );

        System.out.println("Ticket creado:");
        System.out.println("Número: " + ticket.getNumero());
        System.out.println("Título: " + ticket.getTitulo());
        System.out.println("Descripción: " + ticket.getDescripcion());
        System.out.println("Prioridad: " + ticket.getPrioridad());
        System.out.println("Estado: " + ticket.getEstado());
        System.out.println("Creador: " + ticket.getCreador().getNombre());
        System.out.println("Fecha creación: " + ticket.getFechaCreacion());
        
        Departamento dpto = new Departamento("Soporte Técnico", "Atención y resolución de problemas técnicos");

        System.out.println("Departamento creado:");
        System.out.println("Nombre: " + dpto.getNombre());
        System.out.println("Descripción: " + dpto.getDescripcion());
        
        
    
    }
}