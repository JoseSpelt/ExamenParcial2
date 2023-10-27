

package com.mycompany.examenparcial2_optativo2;

import com.mycompany.examenparcial2_optativo2.Infraestructura.Personas;
import com.mycompany.examenparcial2_optativo2.Servicios.Persona;





public class Consultar_BD {

    public static void main(String[] args) {
        int idPersona = 1; // ID de la persona que deseas consultar

        Persona persona = new Persona("postgres", "Invocador1998", "localhost", "5432", "Parcial 1");

        // Consultar persona por ID
        Personas personaConsultada = persona.consultarPersonaPorId(idPersona);

        if (personaConsultada != null) {
            // Si la persona se encuentra en la base de datos, imprime sus datos
            System.out.println("Persona encontrada:");
            System.out.println("ID: " + personaConsultada.id_persona);
            System.out.println("Nombre: " + personaConsultada.Nombre);
            System.out.println("Apellido: " + personaConsultada.Apellido);
            System.out.println("Tipo de Documento: " + personaConsultada.TipoDocumento);
            System.out.println("Número de Documento: " + personaConsultada.NroDocumento);
            // Agrega aquí el resto de los campos que desees mostrar
        } else {
            System.out.println("Persona no encontrada para el ID: " + idPersona);
        }
    }
}


