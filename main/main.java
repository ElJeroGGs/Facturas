package main;
import vista.*;
import control.*;
public class main {
    public static void main(String[] args) {
        // Instanciar las clases
        controlventanas controlventanas = new controlventanas();
        controlclientes controlclientes = new controlclientes();
        controlproductos controlproductos = new controlproductos();

        Inicio inicio = new Inicio();
        clientes clientes = new clientes();
        productos productos = new productos();
        facturas facturas = new facturas();

        vista.panelTablaClientes panelTablaClientes = new panelTablaClientes();

        // Establecer las relaciones entre clases
        inicio.setControlVentanas(controlventanas);


        clientes.setControlClientes(controlclientes);
        productos.setControlProductos(controlproductos);
        
        controlclientes.setClientesVentana(clientes);
        controlclientes.setPanelTablaClientes(panelTablaClientes);
        
        controlproductos.setProductosVentana(productos);
        controlventanas.setInicio(inicio);
        controlventanas.setClientes(clientes);
        controlventanas.setProductos(productos);
        controlventanas.setFacturas(facturas);
       

        inicio.setVisible(true);
    }
}