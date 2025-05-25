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
// Caso de Uso 9: Agregar comentarios o respuestas al ticket
class Comentario implements Serializable {
    private String autor;
    private String mensaje;
    private LocalDateTime fecha;

    public Comentario(String autor, String mensaje) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
    }

    public String toString() {
        return "[" + fecha + "] " + autor + ": " + mensaje;
    }
}
