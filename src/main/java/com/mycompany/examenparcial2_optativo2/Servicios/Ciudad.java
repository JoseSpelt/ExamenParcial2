
package com.mycompany.examenparcial2_optativo2.Servicios;

import com.mycompany.examenparcial2_optativo2.Infraestructura.CiudadPersistencia;
import com.mycompany.examenparcial2_optativo2.Infraestructura.Ciudades;

import java.util.List;
import javax.swing.JOptionPane;

public class Ciudad {
      CiudadPersistencia ciudadDB;
    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new CiudadPersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarCiudad(Ciudades ciudad){
        if(validarDatos(ciudad)){
           ciudadDB.registrarCiudad(ciudad);
        }else{
            JOptionPane.showMessageDialog(null, "El registro no pudo completarse", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void modificarCiudad(Ciudades ciudad){
           ciudadDB.modificarCiudad(ciudad);
    }


    public List<Ciudades> consultarCiudad(){
        return  ciudadDB.consultarCiudades();
    }
    
    public String eliminarCiudad(int ciudad){
        return ciudadDB.eliminarCiudad(ciudad);
    }
    public Ciudades consultarCiudadPorId(int idCiudad) {
    Ciudades ciudad = ciudadDB.consultarCiudadPorId(idCiudad);
    
    if (ciudad == null) {
        JOptionPane.showMessageDialog(null, "No se encontró ninguna ciudad con el ID " + idCiudad, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    return ciudad;
}

    private boolean validarDatos(Ciudades ciudad) {
        try {
        if(ciudad.getNombreCiudad().trim().isEmpty())
            throw new Exception("El nombre de la ciudad no debe estar vacío");
        else if (ciudad.getNombreCiudad().trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
