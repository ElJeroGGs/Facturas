package control;

import javax.swing.JPanel;

public class controlfacturas {
    private vista.facturas ventanaFacturas;

    public void setVentanaFacturas(vista.facturas ventanaFacturas) {
        this.ventanaFacturas = ventanaFacturas;
    }
    
    public void verFacturas(){

    }

    public void addFactura(){
        JPanel panelAñadirFactura = new vista.panelAñadirFactura().getPanel();
        // Configura el panel de añadir cliente en la ventanaClientes
        this.ventanaFacturas.setPanel(panelAñadirFactura);
    }

    public void eliminarFactura(){

    }

    public void modificarFactura(){

    }

    public void hacer(String command) {
        switch (command) {
            case "ver":
                verFacturas();
                break;
            case "agregar":
                addFactura();
                break;
            case "eliminar":
                eliminarFactura();
                break;
            case "modificar":
                modificarFactura();
                break;
            default:
                System.out.println("Comando inválido");
                break;
        }
    }
}
