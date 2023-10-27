
package com.mycompany.examenparcial2_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClientePersistencia {
           private Conexiones conexion;

    public ClientePersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarCliente(Clientes cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente(" +
                    "id_persona, " +
                    "fecha_ingreso, " +
                    "calificacion, " +
                    "estado) " +
                    "values('" +
                    cliente.id_persona + "', '" +
                    cliente.FechaIngreso + "', '" +
                    cliente.Calificacion + "', '" +
                    cliente.estado + "')");
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modificarCLiente(Clientes cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "id_persona = '" + cliente.id_persona + "'," +
                    "fecha_ingreso = '" + cliente.FechaIngreso + "'," +
                    "calificacion = '" + cliente.Calificacion +  "'," +
                    "estado = '" + cliente.estado + "' Where id_cliente = " + cliente.id_cliente);
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "El cliente ha sido actualizada con éxito.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Clientes> consultarClientes() {
    List<Clientes> clientes = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cliente"));

        while (conexion.getResultadoQuery().next()) {
            Clientes cliente = new Clientes();
            cliente.id_cliente = conexion.getResultadoQuery().getInt("id_cliente");
            cliente.id_persona = conexion.getResultadoQuery().getInt("id_persona");
            cliente.FechaIngreso = conexion.getResultadoQuery().getString("fecha_ingreso");
            cliente.Calificacion = conexion.getResultadoQuery().getString("calificacion");
            cliente.estado = conexion.getResultadoQuery().getString("estado");


            clientes.add(cliente);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return clientes;
}
    public Clientes consultarClientePorId(int idCliente) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cliente WHERE id_cliente = " + idCliente));

        if (conexion.getResultadoQuery().next()) {
            Clientes cliente = new Clientes();
            cliente.id_cliente = conexion.getResultadoQuery().getInt("id_cliente");
            cliente.id_persona = conexion.getResultadoQuery().getInt("id_persona");
            cliente.FechaIngreso = conexion.getResultadoQuery().getString("fecha_ingreso");
            cliente.Calificacion = conexion.getResultadoQuery().getString("calificacion");
            cliente.estado = conexion.getResultadoQuery().getString("estado");

            return cliente;
        } else {
            return null;
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void eliminarCliente(int cliente) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cliente WHERE id_cliente = " + cliente);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "El cliente ha sido eliminada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
