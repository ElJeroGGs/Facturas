package main;
import vista.*;
import control.*;
public class main {
    public static void main(String[] args) {
        // Instanciar las clases
        controlventanas controlventanas = new controlventanas();
        controlclientes controlclientes = new controlclientes();
        Inicio inicio = new Inicio();
        clientes clientes = new clientes();
        productos productos = new productos();
        facturas facturas = new facturas();

        // Establecer las relaciones entre clases
        inicio.setControlVentanas(controlventanas);

        clientes.setControlClientes(controlclientes);
        
        controlclientes.setClientesVentana(clientes);
        controlventanas.setInicio(inicio);
        controlventanas.setClientes(clientes);
        controlventanas.setProductos(productos);
        controlventanas.setFacturas(facturas);

        inicio.setVisible(true);
    }
}