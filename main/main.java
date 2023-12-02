package main;
import vista.*;
import vista.PanelesCliente.panelEliminaClientes;
import vista.PanelesCliente.panelModificaCliente;
import vista.PanelesCliente.panelTablaClientes;
import vista.PanelesProducto.panelEliminaProductos;
import vista.PanelesProducto.panelTablaProductos;
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

        vista.PanelesCliente.panelTablaClientes panelTablaClientes = new panelTablaClientes();
        vista.PanelesCliente.panelEliminaClientes panelEliminaClientes = new panelEliminaClientes(panelTablaClientes);
        vista.PanelesCliente.panelModificaCliente panelModificaCliente = new panelModificaCliente(panelTablaClientes);

        vista.PanelesProducto.panelTablaProductos panelTablaProductos = new panelTablaProductos();
        vista.PanelesProducto.panelEliminaProductos panelEliminaProductos = new panelEliminaProductos(panelTablaProductos);

        vista.PanelesFactura.panelTablaFactura panelTablaFactura = new vista.PanelesFactura.panelTablaFactura();
        vista.PanelesFactura.panelEliminarFactura panelEliminarFactura = new vista.PanelesFactura.panelEliminarFactura(panelTablaFactura);
        

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
        panelEliminarFactura.setControl(controlfacturas);
        controlfacturas.setVentanaFacturas(facturas);


        controlfacturas.setPanelTablaFactura(panelTablaFactura);
        controlventanas.setFacturas(facturas);

        inicio.setVisible(true);
    }
}