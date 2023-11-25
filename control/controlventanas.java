package control;

import vista.*;

public class controlventanas {
    private Inicio inicio;
    private clientes clientes;
    private productos productos;
    private facturas facturas;

    public void setInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    public void setClientes(clientes clientes) {
        this.clientes = clientes;
    }

    public void setProductos(productos productos) {
        this.productos = productos;
    }

    public void setFacturas(facturas facturas) {
        this.facturas = facturas;
    }

public void abrir(String ventana){
    switch (ventana) {
        case "clientes":
            clientes.setVisible(true);
            productos.setVisible(false);
            facturas.setVisible(false);
            break;
        case "productos":
            clientes.setVisible(false);
            productos.setVisible(true);
            facturas.setVisible(false);
            break;
        case "facturas":
            clientes.setVisible(false);
            productos.setVisible(false);
            facturas.setVisible(true);
            break;
        default:
            break;
    }
}
}