package modelo;

public class producto {
    
    private String codigo;
    private String descripcion;
    private String precio_unitario;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPrecio_unitario() {
        return precio_unitario;
    }
    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
}
