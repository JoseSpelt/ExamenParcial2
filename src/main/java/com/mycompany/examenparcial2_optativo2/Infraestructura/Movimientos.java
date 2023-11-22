
package com.mycompany.examenparcial2_optativo2.Infraestructura;

public class Movimientos {
    private int id_movimiento;
    private int id_cuenta;
    private String FechaMovimiento;
    private String TipoMovimiento;
    private String SaldoAnterior;
    private String SaldoActual;
    private String MontoMovimiento;
    private String CuentaOrigen;
    private String Canal;

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    
    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getFechaMovimiento() {
        return FechaMovimiento;
    }

    public void setFechaMovimiento(String FechaMovimiento) {
        this.FechaMovimiento = FechaMovimiento;
    }

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String TipoMovimiento) {
        this.TipoMovimiento = TipoMovimiento;
    }

    public String getSaldoAnterior() {
        return SaldoAnterior;
    }

    public void setSaldoAnterior(String SaldoAnterior) {
        this.SaldoAnterior = SaldoAnterior;
    }

    public String getSaldoActual() {
        return SaldoActual;
    }

    public void setSaldoActual(String SaldoActual) {
        this.SaldoActual = SaldoActual;
    }

    public String getMontoMovimiento() {
        return MontoMovimiento;
    }

    public void setMontoMovimiento(String MontoMovimiento) {
        this.MontoMovimiento = MontoMovimiento;
    }

    public String getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(String CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public String getCanal() {
        return Canal;
    }

    public void setCanal(String Canal) {
        this.Canal = Canal;
    }
    
    
    
}
