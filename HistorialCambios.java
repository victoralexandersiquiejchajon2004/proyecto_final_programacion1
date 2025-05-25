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
class HistorialCambios implements Serializable {
    private String usuario;
    private LocalDateTime fecha;

    public HistorialCambios(String usuario) {
        this.usuario = usuario;
        this.fecha = LocalDateTime.now();
    }

    public String toString() {
        return usuario + " modificó el sistema en " + fecha;
    }
}
