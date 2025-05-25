/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Sayda
 */
public class Nota implements Serializable {
    private String contenido;
    private Persona autor;
    private LocalDateTime fecha;

    public Nota(String contenido, Persona autor) {
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = LocalDateTime.now();
    }

    public String toString() {
        return "[" + fecha + "] " + autor.getNombre() + ": " + contenido;
    }
}