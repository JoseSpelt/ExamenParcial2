
package com.mycompany.examenparcial2_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PersonaPersistencia {
        private Conexiones conexion;

    public PersonaPersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarPersona(Personas persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO personas(" +
                    "id_ciudad, " +
                    "nombre, " +
                    "apellido, " +
                    "tipo_documento, " +
                    "nro_documento, " +
                    "direccion," +
                    "celular, " +
                    "email, " +
                    "estado) " +
                    "values('" +
                    persona.getId_ciudad() + "', '" +
                    persona.getNombre() + "', '" +
                    persona.getApellido() + "', '" +
                    persona.getTipoDocumento() + "', '" +
                    persona.getNroDocumento() + "', '" +
                    persona.getDireccion() + "', '" +
                    persona.getCelular() + "', '" +
                    persona.getEmail() + "', '" +
                    persona.getEstado() + "')");
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(Personas persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE personas SET " +
                    "nombre = '" + persona.getNombre() + "'," +
                    "apellido = '" + persona.getApellido() + "'," +
                    "tipo_documento = '" + persona.getTipoDocumento() + "'," +
                    "nro_documento = '" + persona.getNroDocumento() + "'," +
                    "direccion = '" + persona.getDireccion() + "'," +
                    "celular = '" + persona.getCelular() + "'," +
                    "email = '" + persona.getEmail() + "'," +
                    "estado = '" + persona.getEstado() + "' Where personas.id_persona = " + persona.getId_persona());
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.getNombre() + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Personas> consultarPersonas() {
    List<Personas> personas = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas"));

        while (conexion.getResultadoQuery().next()) {
            Personas persona = new Personas();
            persona.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
            persona.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
            persona.setNombre(conexion.getResultadoQuery().getString("nombre"));
            persona.setApellido(conexion.getResultadoQuery().getString("apellido"));
            persona.setTipoDocumento(conexion.getResultadoQuery().getString("tipo_documento"));
            persona.setNroDocumento(conexion.getResultadoQuery().getString("nro_documento"));
            persona.setDireccion(conexion.getResultadoQuery().getString("direccion"));
            persona.setCelular(conexion.getResultadoQuery().getString("celular"));
            persona.setEmail(conexion.getResultadoQuery().getString("email"));
            persona.setEstado(conexion.getResultadoQuery().getString("estado"));
            personas.add(persona);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return personas;
}
       public Personas consultarPersonaPorId(int id) {
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas WHERE id_persona = " + id));

            if (conexion.getResultadoQuery().next()) {
                Personas persona = new Personas();
                persona.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
                persona.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
                persona.setNombre(conexion.getResultadoQuery().getString("nombre"));
                persona.setApellido(conexion.getResultadoQuery().getString("apellido"));
                persona.setTipoDocumento(conexion.getResultadoQuery().getString("tipo_documento"));
                persona.setNroDocumento(conexion.getResultadoQuery().getString("nro_documento"));
                persona.setDireccion(conexion.getResultadoQuery().getString("direccion"));
                persona.setCelular(conexion.getResultadoQuery().getString("celular"));
                persona.setEmail(conexion.getResultadoQuery().getString("email"));
                persona.setEstado(conexion.getResultadoQuery().getString("estado"));
                return persona;
            } else {
                return null; 
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
           public Personas consultarPersonaPorDocumento(int documento) {
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas WHERE nro_documento = '" + documento + "'"));

            if (conexion.getResultadoQuery().next()) {
                Personas persona = new Personas();
                persona.setId_persona(conexion.getResultadoQuery().getInt("id_persona"));
                persona.setId_ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
                persona.setNombre(conexion.getResultadoQuery().getString("nombre"));
                persona.setApellido(conexion.getResultadoQuery().getString("apellido"));
                persona.setTipoDocumento(conexion.getResultadoQuery().getString("tipo_documento"));
                persona.setNroDocumento(conexion.getResultadoQuery().getString("nro_documento"));
                persona.setDireccion(conexion.getResultadoQuery().getString("direccion"));
                persona.setCelular(conexion.getResultadoQuery().getString("celular"));
                persona.setEmail(conexion.getResultadoQuery().getString("email"));
                persona.setEstado(conexion.getResultadoQuery().getString("estado"));
                return persona;
            } else {
                return null; 
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void eliminarPersona(int persona) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM personas WHERE id_persona = " + persona);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "La persona ha sido eliminada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

}
