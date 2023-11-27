package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.cliente;
import modelo.connection;
import vista.panelAñadirCliente;
import vista.panelEliminaClientes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class controlclientes {

      private vista.clientes ventanaClientes;
      private vista.panelTablaClientes panelTablaClientes;

        public void setClientesVentana(vista.clientes ventana) {
            this.ventanaClientes = ventana;
        }
    public void verClientes() {
        JTable Tabla =  panelTablaClientes.getTabla();      

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
        panelEliminaClientes panelEliminarCliente = new panelEliminaClientes(this.panelTablaClientes);
        panelEliminarCliente.setControl(this);
        JPanel panelEliminaCliente = (JPanel) panelEliminarCliente;
        // Configura el panel de añadir cliente en la ventanaClientes
        this.ventanaClientes.setPanel(panelEliminaCliente);
        verClientes();
    }


    public void borradoCliente(String rut) {
        Connection conn = modelo.connection.openConnection();
        try {
            // Crear un CallableStatement para llamar al procedimiento almacenado
            CallableStatement cstmt = conn.prepareCall("{call pr_elimina_cliente(?)}");

            // Establecer el valor del parámetro de entrada
            cstmt.setString(1, rut);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            // Mostrar ventana de éxito
            JOptionPane.showMessageDialog(null, "El cliente se ha borrado con éxito");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            modelo.connection.closeConnection(conn);
        }
        eliminarCliente();
    }

    public void modificarCliente() {
        // Add your code here for modifying a client
    }

   public void hacer(String command) {
        switch (command) {
            case "ver":
                verClientes();
        this.ventanaClientes.setPanel(panelTablaClientes);
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


    public static void insertarCliente(cliente cliente) {
        String sql = "INSERT INTO CLIENTE (RUT, NOMBRE, APELLIDO1, APELLIDO2, DOMICILIO, TELEFONO) VALUES (?, ?, ?, ?, ?, ?)";
        connection conn;
        
        try (Connection connection = modelo.connection.openConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getRut().toUpperCase());
            pstmt.setString(2, cliente.getNombre().toUpperCase());
            pstmt.setString(3, cliente.getApellido1().toUpperCase());
            pstmt.setString(4, cliente.getApellido2().toUpperCase());
            pstmt.setString(5, cliente.getDomicilio().toUpperCase());
            pstmt.setString(6, cliente.getTelefono().toUpperCase());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Cliente insertado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el cliente");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
