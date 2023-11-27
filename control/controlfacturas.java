package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.connection;
import vista.panelEliminaProductos;
import vista.panelEliminarFactura;

public class controlfacturas {
    private vista.facturas ventanaFacturas;
    private vista.panelTablaFactura panelTablaFactura;

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
        panelEliminarFactura panelEliminaFactura = new panelEliminarFactura(this.panelTablaFactura);
        panelEliminaFactura.setControl(this);
        JPanel panelEliminarFactura = (JPanel) panelEliminaFactura;

        this.ventanaFacturas.setPanel(panelEliminarFactura);
        verFacturas();
    }

    public void borradoFactura(String numero){
        Connection conn = modelo.connection.openConnection();
        try {
            // Crear un CallableStatement para llamar al procedimiento almacenado
            CallableStatement cstmt = conn.prepareCall("{call pr_elimina_factura(?)}");

            // Establecer el valor del parámetro de entrada
            cstmt.setString(1, numero);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            // Mostrar ventana de éxito
            JOptionPane.showMessageDialog(null, "La factura se ha borrado con éxito");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            modelo.connection.closeConnection(conn);
        }
        eliminarFactura();
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

    public void setPanelTablaFactura(vista.panelTablaFactura panelTablaFactura) {
        this.panelTablaFactura = panelTablaFactura;
    }

    
}
