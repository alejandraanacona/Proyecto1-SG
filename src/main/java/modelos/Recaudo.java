package modelos;

import java.util.Date;

public class Recaudo {

    private int idRecaudo;
    private int idClientes;
    private int idProveedores;
    private String noReferencia;
    private float valor;
    private Date fechaVencimiento;

    public Recaudo() {
    }

    public Recaudo(int idClientes, int idProveedores, String noReferencia, float valor) {
        this.idClientes = idClientes;
        this.idProveedores = idProveedores;
        this.noReferencia = noReferencia;
        this.valor = valor;
    }

    
    public Recaudo(int idClientes, int idProveedores, String noReferencia, float valor, Date fechaVencimiento) {
        this.idClientes = idClientes;
        this.idProveedores = idProveedores;
        this.noReferencia = noReferencia;
        this.valor = valor;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdRecaudo() {
        return idRecaudo;
    }

    public void setIdRecaudo(int idRecaudo) {
        this.idRecaudo = idRecaudo;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNoReferencia() {
        return noReferencia;
    }

    public void setNoReferencia(String noReferencia) {
        this.noReferencia = noReferencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
