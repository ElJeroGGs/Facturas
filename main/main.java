package main;
import vista.*;
import control.*;
public class main {
    public static void main(String[] args) {
        // Instanciar las clases
        controlventanas controlventanas = new controlventanas();
        controlclientes controlclientes = new controlclientes();
        controlproductos controlproductos = new controlproductos();
        controlfacturas controlfacturas = new controlfacturas();

        Inicio inicio = new Inicio();
        clientes clientes = new clientes();
        productos productos = new productos();
        facturas facturas = new facturas();

        vista.panelTablaClientes panelTablaClientes = new panelTablaClientes();
        vista.panelEliminaClientes panelEliminaClientes = new panelEliminaClientes(panelTablaClientes);

        vista.panelModificaCliente panelModificaCliente = new panelModificaCliente(panelTablaClientes);
        vista.panelTablaProductos panelTablaProductos = new panelTablaProductos();
        vista.panelEliminaProductos panelEliminaProductos = new panelEliminaProductos(panelTablaProductos);

        // Establecer las relaciones entre clases
        inicio.setControlVentanas(controlventanas);

        panelEliminaClientes.setControl(controlclientes);
        panelModificaCliente.setControl(controlclientes);

        panelEliminaProductos.setControl(controlproductos);
        
        clientes.setControlClientes(controlclientes);
        productos.setControlProductos(controlproductos);
        
        controlclientes.setClientesVentana(clientes);
        controlclientes.setPanelTablaClientes(panelTablaClientes);

        controlproductos.setProductosVentana(productos);
        controlproductos.setPanelTablaProductos(panelTablaProductos);
        
        controlventanas.setInicio(inicio);
        controlventanas.setClientes(clientes);
        controlventanas.setProductos(productos);
        controlventanas.setFacturas(facturas);
       
        facturas.setControlfacturas(controlfacturas);
        controlfacturas.setVentanaFacturas(facturas);

        inicio.setVisible(true);
    }
}