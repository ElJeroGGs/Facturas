package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.clientes;
import modelo.connection;
import vista.panelAñadirCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlclientes {

      private vista.clientes ventanaClientes;
      private vista.panelTablaClientes panelTablaClientes;
      

        public void setClientesVentana(vista.clientes ventana) {
            this.ventanaClientes = ventana;
        }
    public void verClientes() {
        JTable Tabla =  panelTablaClientes.getTabla();        
        this.ventanaClientes.setPanel(panelTablaClientes);

        DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
        modeloTabla.setRowCount(0);
        connection conn;
        Connection connection = modelo.connection.openConnection();
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLIENTE");
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnas = resultSet.getMetaData().getColumnCount();

            while(resultSet.next()) {
                Object[] fila = new Object[columnas];
                for(int i = 0; i < columnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);}
                modeloTabla.addRow(fila);
            }

            // No olvides cerrar tus recursos
            resultSet.close();
            preparedStatement.close();
            modelo.connection.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addCliente() {
        JPanel panelAñadirCliente = new vista.panelAñadirCliente().getPanel();
        // Configura el panel de añadir cliente en la ventanaClientes
        this.ventanaClientes.setPanel(panelAñadirCliente);
    }

    public void eliminarCliente() {
    }

    public void modificarCliente() {
    }

   public void hacer(String command) {
        switch (command) {
            case "ver":
                verClientes();
                break;
            case "agregar":
                addCliente();
                break;
            case "eliminar":
                eliminarCliente();
                break;
            case "modificar":
                modificarCliente();
                break;
            default:
                System.out.println("Comando inválido");
                break;
        }
    }

    public void setPanelTablaClientes(vista.panelTablaClientes panelTablaClientes) {
        this.panelTablaClientes = panelTablaClientes;
    }
    
    public void setPanelAñadirClientes(vista.panelAñadirCliente panelAñadirCliente) {
       // this.panelAñadirCLienes = panelAñadirCliente;
    }
}
