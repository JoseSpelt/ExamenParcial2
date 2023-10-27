
package com.mycompany.examenparcial2_optativo2.Servicios;

import com.mycompany.examenparcial2_optativo2.Infraestructura.ClientePersistencia;
import com.mycompany.examenparcial2_optativo2.Infraestructura.Clientes;
import java.util.List;


public class Cliente {
    ClientePersistencia clienteDB;
    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new ClientePersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarCliente(Clientes cliente){
            clienteDB.registrarCliente(cliente);
    }
    public void modificarCliente(Clientes cliente){
           clienteDB.modificarCLiente(cliente);
    }


    public List<Clientes> consultarClientes(){
        return  clienteDB.consultarClientes();
    }
    
    public Clientes consultarClientePorId(int idCliente) {
    return clienteDB.consultarClientePorId(idCliente);
}
    public void eliminarCliente(int cliente){
        clienteDB.eliminarCliente(cliente);
    }


}
