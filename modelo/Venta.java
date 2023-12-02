package modelo;

public class Venta {

    private String numero;
    private String codigo;
    private int cantidad;

    public Venta(String numero, String codigo, int cantidad) {
        this.numero = numero;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public String getNumero() {
        return numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

}
