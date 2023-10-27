
package com.mycompany.examenparcial2_optativo2.Servicios;

import com.mycompany.examenparcial2_optativo2.Infraestructura.PersonaPersistencia;
import com.mycompany.examenparcial2_optativo2.Infraestructura.Personas;
import java.util.List;
import javax.swing.JOptionPane;



public class Persona {
  PersonaPersistencia personasDB;
    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new PersonaPersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarPersona(Personas persona){
        if(validarDatos(persona)){
           personasDB.registrarPersona(persona);
        }
        else{
             JOptionPane.showMessageDialog(null, "El registro no pudo completarse", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String modificarPersona(Personas persona){
        if(validarDatos(persona)){
            personasDB.modificarPersona(persona);
            JOptionPane.showMessageDialog(null, "La persona ha sido actualizada con éxito.");
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public List<Personas> consultarPersona(){
        return  personasDB.consultarPersonas();
    }
    public Personas consultarPersonaPorId(int id) {
        return personasDB.consultarPersonaPorId(id);
    }
    public Personas consultarPersonaPorDocumento(int documento) {
        return personasDB.consultarPersonaPorDocumento(documento);
    }
    public void eliminarPersona(int persona){
         personasDB.eliminarPersona(persona);
    }

    private boolean validarDatos(Personas persona) {
        try {
        if(persona.Nombre.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (persona.Nombre.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
