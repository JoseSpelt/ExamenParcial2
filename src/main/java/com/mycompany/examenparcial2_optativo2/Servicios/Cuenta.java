
package com.mycompany.examenparcial2_optativo2.Servicios;

import com.mycompany.examenparcial2_optativo2.Infraestructura.CuentaPersistencia;
import com.mycompany.examenparcial2_optativo2.Infraestructura.Cuentas;
import java.util.List;


public class Cuenta {
    CuentaPersistencia cuentaDB;
    public Cuenta(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentaDB = new CuentaPersistencia(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarCuenta(Cuentas cuenta){
            cuentaDB.registrarCuenta(cuenta);  
    }
    public void modificarCuenta(Cuentas cuenta){
           cuentaDB.modificarCuenta(cuenta);
    }


    public List<Cuentas> consultarCuentas(){
        return  cuentaDB.consultarCuentas();
    }
    public Cuentas consultarCuentaPorId(int idCuenta) {
    return cuentaDB.consultarCuentaPorId(idCuenta);
}
    
    public void eliminarCuenta(int cuenta){
        cuentaDB.eliminarCuenta(cuenta);
    }

}
