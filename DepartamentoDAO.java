/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_progra1;


import java.sql.*;
import java.util.*;
import javax.swing.*;

public class DepartamentoDAO {
    private Connection conn;

    public DepartamentoDAO(Connection conn) {
        this.conn = conn;
    }

    public void crear(Departamento d) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO departamentos(nombre, descripcion) VALUES (?, ?)")) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("crear", e);
        }
    }

    public List<Departamento> listar() {
        List<Departamento> lista = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM departamentos")) {
            while (rs.next()) {
                Departamento d = new Departamento(
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                );
                lista.add(d);
            }
        } catch (Exception e) {
            mostrarError("listar", e);
        }
        return lista;
    }

    public void actualizar(Departamento d) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE departamentos SET descripcion=? WHERE nombre=?")) {
            ps.setString(1, d.getDescripcion());
            ps.setString(2, d.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("actualizar", e);
        }
    }

    public void eliminar(String nombre) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM departamentos WHERE nombre=?")) {
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (Exception e) {
            mostrarError("eliminar", e);
        }
    }

    private void mostrarError(String metodo, Exception e) {
        JOptionPane.showMessageDialog(null, "Error en DepartamentoDAO - " + metodo + ": " + e.getMessage());
    }
}
