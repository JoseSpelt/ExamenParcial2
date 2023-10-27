
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
                    cuenta.id_cliente + "', '" +
                    cuenta.NumeroCuenta + "', '" +
                    cuenta.FechaAlta + "', '" +
                    cuenta.TipoCuenta + "', '" +
                    cuenta.estado + "', '" +
                    cuenta.Saldo + "', '" +
                    cuenta.NumeroContrato + "', '" +
                    cuenta.CostoMantenimiento + "', '" +
                    cuenta.PromedioAcreditacion + "', '" +
                    cuenta.Moneda +"')");
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
                    "id_cliente = '" + cuenta.id_cliente + "'," +
                    "nro_cuenta = '" + cuenta.NumeroCuenta + "'," +
                    "fecha_alta = '" + cuenta.FechaAlta + "'," +
                    "tipo_cuenta = '" + cuenta.TipoCuenta + "'," +
                    "estado = '" + cuenta.estado + "'," +
                    "saldo = '" + cuenta.Saldo + "'," +
                    "nro_contrato = '" + cuenta.NumeroContrato + "'," +
                    "costo_mantenimiento = '" + cuenta.CostoMantenimiento + "'," + 
                    "prom_acreditacion = '" + cuenta.PromedioAcreditacion + "'," +
                    "moneda = '" + cuenta.Moneda + "' " +
                    "WHERE id_cuenta = " + cuenta.id_cuenta);
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
            cuenta.id_cuenta = conexion.getResultadoQuery().getInt("id_cuenta");
            cuenta.id_cliente = conexion.getResultadoQuery().getInt("id_cliente");
            cuenta.NumeroCuenta = conexion.getResultadoQuery().getString("nro_cuenta");
            cuenta.FechaAlta = conexion.getResultadoQuery().getString("fecha_alta");
            cuenta.TipoCuenta = conexion.getResultadoQuery().getString("tipo_cuenta");
            cuenta.estado = conexion.getResultadoQuery().getString("estado");
            cuenta.Saldo = conexion.getResultadoQuery().getString("saldo");
            cuenta.NumeroContrato = conexion.getResultadoQuery().getString("nro_contrato");
            cuenta.CostoMantenimiento = conexion.getResultadoQuery().getString("costo_mantenimiento");
            cuenta.PromedioAcreditacion = conexion.getResultadoQuery().getString("prom_acreditacion");
            cuenta.Moneda = conexion.getResultadoQuery().getString("moneda");

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
            cuenta.id_cuenta = conexion.getResultadoQuery().getInt("id_cuenta");
            cuenta.id_cliente = conexion.getResultadoQuery().getInt("id_cliente");
            cuenta.NumeroCuenta = conexion.getResultadoQuery().getString("nro_cuenta");
            cuenta.FechaAlta = conexion.getResultadoQuery().getString("fecha_alta");
            cuenta.TipoCuenta = conexion.getResultadoQuery().getString("tipo_cuenta");
            cuenta.estado = conexion.getResultadoQuery().getString("estado");
            cuenta.Saldo = conexion.getResultadoQuery().getString("saldo");
            cuenta.NumeroContrato = conexion.getResultadoQuery().getString("nro_contrato");
            cuenta.CostoMantenimiento = conexion.getResultadoQuery().getString("costo_mantenimiento");
            cuenta.PromedioAcreditacion = conexion.getResultadoQuery().getString("prom_acreditacion");
            cuenta.Moneda = conexion.getResultadoQuery().getString("moneda");
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
