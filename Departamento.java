/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sayda
 */
// Caso de Uso 4: Crear departamentos, asignar técnicos, gestionar cola de tickets
public class Departamento implements Serializable {
    private String nombre;
    private String descripcion;
    private List<Tecnico> tecnicos;
    private Queue<Ticket> colaAtencion;

    public Departamento(String nombre, String descripcion) {
        if (nombre == null || nombre.length() < 3 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre del departamento debe tener entre 3 y 50 caracteres.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tecnicos = new ArrayList<>();
        this.colaAtencion = new LinkedList<>();
    }

    public void asignarTecnico(Tecnico tecnico) {
        if (!tecnicos.contains(tecnico)) {
            tecnicos.add(tecnico);
            tecnico.asignarDepartamento(this);
        }
    }

    public void agregarTicket(Ticket ticket) {
        colaAtencion.offer(ticket);
    }

    public boolean tieneTicketsActivos() {
        return !colaAtencion.isEmpty();
    }

    public Ticket atenderSiguienteTicket() {
        return colaAtencion.poll();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}