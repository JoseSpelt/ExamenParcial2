
package com.mycompany.examenparcial2_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CuentaPersistencia {
    private Conexiones conexion;

    public CuentaPersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public void registrarCuenta(Cuentas cuenta){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cuentas(" +
                    "id_cliente, " +
                    "nro_cuenta, " +
                    "fecha_alta, " +
                    "tipo_cuenta, " +
                    "estado, " +
                    "saldo, " +
                    "nro_contrato, " +
                    "costo_mantenimiento, " +
                    "prom_acreditacion, " +
                    "moneda) " +
                    "values('" +
                    cuenta.getId_cliente() + "', '" +
                    cuenta.getNumeroCuenta() + "', '" +
                    cuenta.getFechaAlta()+ "', '" +
                    cuenta.getTipoCuenta()+ "', '" +
                    cuenta.getEstado() + "', '" +
                    cuenta.getSaldo() + "', '" +
                    cuenta.getNumeroContrato() + "', '" +
                    cuenta.getCostoMantenimiento() + "', '" +
                    cuenta.getPromedioAcreditacion() + "', '" +
                    cuenta.getMoneda() +"')");
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modificarCuenta(Cuentas cuenta){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuentas SET " +
                    "id_cliente = '" + cuenta.getId_cliente() + "'," +
                    "nro_cuenta = '" + cuenta.getNumeroCuenta() + "'," +
                    "fecha_alta = '" + cuenta.getFechaAlta() + "'," +
                    "tipo_cuenta = '" + cuenta.getTipoCuenta() + "'," +
                    "estado = '" + cuenta.getEstado() + "'," +
                    "saldo = '" + cuenta.getSaldo() + "'," +
                    "nro_contrato = '" + cuenta.getNumeroContrato() + "'," +
                    "costo_mantenimiento = '" + cuenta.getCostoMantenimiento() + "'," + 
                    "prom_acreditacion = '" + cuenta.getPromedioAcreditacion() + "'," +
                    "moneda = '" + cuenta.getMoneda() + "' " +
                    "WHERE id_cuenta = " + cuenta.getId_cuenta());
            conexion.conexionDB().close();
            JOptionPane.showMessageDialog(null, "La persona ha sido actualizada con éxito.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cuentas> consultarCuentas() {
    List<Cuentas> cuentas = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cuentas"));

        while (conexion.getResultadoQuery().next()) {
            Cuentas cuenta = new Cuentas();
            cuenta.setId_cuenta(conexion.getResultadoQuery().getInt("id_cuenta"));
            cuenta.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cuenta.setNumeroCuenta(conexion.getResultadoQuery().getString("nro_cuenta")); 
            cuenta.setFechaAlta(conexion.getResultadoQuery().getString("fecha_alta"));
            cuenta.setTipoCuenta(conexion.getResultadoQuery().getString("tipo_cuenta"));
            cuenta.setEstado(conexion.getResultadoQuery().getString("estado"));
            cuenta.setSaldo(conexion.getResultadoQuery().getString("saldo"));
            cuenta.setNumeroContrato(conexion.getResultadoQuery().getString("nro_contrato"));
            cuenta.setCostoMantenimiento(conexion.getResultadoQuery().getString("costo_mantenimiento"));
            cuenta.setPromedioAcreditacion(conexion.getResultadoQuery().getString("prom_acreditacion"));
            cuenta.setMoneda(conexion.getResultadoQuery().getString("moneda")); 

            cuentas.add(cuenta);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return cuentas;
}
    public Cuentas consultarCuentaPorId(int idCuenta) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM cuentas WHERE id_cuenta = " + idCuenta));

        if (conexion.getResultadoQuery().next()) {
            Cuentas cuenta = new Cuentas();
            cuenta.setId_cuenta(conexion.getResultadoQuery().getInt("id_cuenta"));
            cuenta.setId_cliente(conexion.getResultadoQuery().getInt("id_cliente"));
            cuenta.setNumeroCuenta(conexion.getResultadoQuery().getString("nro_cuenta")); 
            cuenta.setFechaAlta(conexion.getResultadoQuery().getString("fecha_alta"));
            cuenta.setTipoCuenta(conexion.getResultadoQuery().getString("tipo_cuenta"));
            cuenta.setEstado(conexion.getResultadoQuery().getString("estado"));
            cuenta.setSaldo(conexion.getResultadoQuery().getString("saldo"));
            cuenta.setNumeroContrato(conexion.getResultadoQuery().getString("nro_contrato"));
            cuenta.setCostoMantenimiento(conexion.getResultadoQuery().getString("costo_mantenimiento"));
            cuenta.setPromedioAcreditacion(conexion.getResultadoQuery().getString("prom_acreditacion"));
            cuenta.setMoneda(conexion.getResultadoQuery().getString("moneda"));
            return cuenta;
        } else {
            return null; 
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void eliminarCuenta(int cuenta) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cuentas WHERE id_cuenta = " + cuenta);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            JOptionPane.showMessageDialog(null, "La cuenta ha sido eliminada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
