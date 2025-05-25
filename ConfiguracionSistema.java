/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sayda
 */
// Caso de Uso 1: Configurar sistema
public class ConfiguracionSistema implements Serializable {
    private String nombreEmpresa;
    private String logoPath;
    private String idioma;
    private String zonaHoraria;
    private int diasVencimientoTicket;
    private List<String> nivelesPrioridad;
    private List<HistorialCambios> historial;

    public ConfiguracionSistema(String nombreEmpresa, String logoPath, String idioma, String zonaHoraria,
                                 int diasVencimientoTicket, List<String> nivelesPrioridad, String usuarioModificador) {
        setNombreEmpresa(nombreEmpresa);
        setLogoPath(logoPath);
        setIdioma(idioma);
        setZonaHoraria(zonaHoraria);
        setDiasVencimientoTicket(diasVencimientoTicket);
        setNivelesPrioridad(nivelesPrioridad);
        historial = new ArrayList<>();
        historial.add(new HistorialCambios(usuarioModificador));
    }

    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public void setLogoPath(String logoPath) { this.logoPath = logoPath; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public void setZonaHoraria(String zonaHoraria) { this.zonaHoraria = zonaHoraria; }
    public void setDiasVencimientoTicket(int dias) { this.diasVencimientoTicket = dias; }
    public void setNivelesPrioridad(List<String> niveles) { this.nivelesPrioridad = niveles; }

    public void registrarCambio(String usuario) {
        historial.add(new HistorialCambios(usuario));
    }

    public List<String> obtenerHistorialComoTexto() {
        List<String> texto = new ArrayList<>();
        for (HistorialCambios h : historial) {
            texto.add(h.toString());
        }
        return texto;
    }
}
