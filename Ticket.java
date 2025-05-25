/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sayda
 */

// Caso de Uso 6: Crear ticket de soporte

public class Ticket implements Serializable {
    private String numero;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private EstadoTicket estado;
    private Persona creador;
    private LocalDateTime fechaCreacion;

    // Constructor actualizado que recibe todos los campos necesarios
    public Ticket(String numero, String titulo, String descripcion, String prioridad, EstadoTicket estado, Persona creador, LocalDateTime fechaCreacion) {
        this.numero = numero;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.creador = creador;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y setters
    public String getNumero() { return numero; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getPrioridad() { return prioridad; }
    public EstadoTicket getEstado() { return estado; }
    public Persona getCreador() { return creador; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    public void setEstado(EstadoTicket estado) {
        this.estado = estado;
    }

    // Otros métodos según necesidad...

    void setAsignado(UsuarioFinal usuarioAsignado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setDepartamento(Departamento dept) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}