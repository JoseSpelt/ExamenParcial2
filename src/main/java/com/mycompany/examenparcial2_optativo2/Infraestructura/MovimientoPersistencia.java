
package com.mycompany.examenparcial2_optativo2.Infraestructura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MovimientoPersistencia {
        private Conexiones conexion;

    public MovimientoPersistencia(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(Movimientos movimiento){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO movimientos(" +
                    "id_cuenta, " +
                    "fecha_movimiento, " +
                    "tipo_movimiento, " +
                    "saldo_anterior, " +
                    "saldo_actual, " +
                    "monto_movimiento, " +
                    "cuenta_origen, " +
                    "canal) " +
                    "values('" +
                    movimiento.getId_cuenta() + "', '" +
                    movimiento.getFechaMovimiento() + "', '" +
                    movimiento.getTipoMovimiento() +
                    movimiento.getSaldoAnterior() +
                    movimiento.getSaldoActual() +
                    movimiento.getMontoMovimiento() +
                    movimiento.getCuentaOrigen() +
                    movimiento.getCanal() + "')");
            conexion.conexionDB().close();
            return "El movimiento fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimiento(Movimientos movimiento){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE movimientos SET " +
                    "id_cuenta = '" + movimiento.getId_cuenta() + "'," +
                    "fecha_movimiento = '" + movimiento.getFechaMovimiento() + "'," +
                    "tipo_movimiento = '" + movimiento.getTipoMovimiento() + "'," +
                    "saldo_anterior= '" + movimiento.getSaldoAnterior() + "'," +
                    "saldo_actual= '" + movimiento.getSaldoActual() + "'," +
                    "monto_movimiento = '" + movimiento.getMontoMovimiento() + "'," +
                    "cuenta_origen = '" + movimiento.getCuentaOrigen() + "'," +
                    "canal = '" + movimiento.getCanal() + "'," +
                    "' Where movimientos.id_movimiento = " + movimiento.getId_movimiento());
            conexion.conexionDB().close();
            return "Los datos fueron modificads correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movimientos> consultarMovimiento() {
    List<Movimientos> movimientos = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM movimientos"));

        while (conexion.getResultadoQuery().next()) {
            Movimientos movimiento = new Movimientos();
            movimiento.setId_movimiento(conexion.getResultadoQuery().getInt("id_movimiento"));
            movimiento.setId_cuenta(conexion.getResultadoQuery().getInt("id_cuenta"));
            movimiento.setFechaMovimiento(conexion.getResultadoQuery().getString("fecha_movimiento"));
            movimiento.setTipoMovimiento(conexion.getResultadoQuery().getString("tipo_movimiento"));
            movimiento.setSaldoAnterior(conexion.getResultadoQuery().getString("saldo_anterior"));
            movimiento.setSaldoActual(conexion.getResultadoQuery().getString("saldo_actual"));
            movimiento.setMontoMovimiento(conexion.getResultadoQuery().getString("monto_movimiento"));
            movimiento.setCuentaOrigen(conexion.getResultadoQuery().getString("cuenta_origen"));
            movimiento.setCanal(conexion.getResultadoQuery().getString("canal"));

            movimientos.add(movimiento);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return movimientos;
}
    public String eliminarMovimiento(int movimiento) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());

        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM movimientos WHERE id_movimiento = " + movimiento);

        conexion.conexionDB().close();

        if (rowCount > 0) {
            return "El movimiento con ID " + movimiento + " ha sido eliminada correctamente.";
        } else {
            return "No se encontró ningun movimiento con ID " + movimiento + ". No se realizó ninguna eliminación.";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
