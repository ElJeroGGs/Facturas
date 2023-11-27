package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.connection;
import modelo.producto;
import vista.panelEliminaProductos;
import vista.panelTablaProductos;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlproductos {

      private vista.productos ventanaProductos;
      private vista.panelTablaProductos panelTablaProductos;

        public void setProductosVentana(vista.productos ventana) {
            this.ventanaProductos = ventana;
        }
    public void verProductos() {
        JTable Tabla =  panelTablaProductos.getTabla();        
       
        DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
        
        modeloTabla.setRowCount(0);
        connection conn;
        Connection connection = modelo.connection.openConnection();
        
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTO");
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnas = resultSet.getMetaData().getColumnCount();

            while(resultSet.next()) {
                Object[] fila = new Object[columnas];
                for(int i = 0; i < columnas; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
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
    public void addProducto() {
        JPanel panelAñadirProducto = new vista.panelAñadirProducto().getPanel();
        // Configura el panel de añadir cliente en la ventanaClientes
        this.ventanaProductos.setPanel(panelAñadirProducto);
    }

    public void eliminarProducto() {
        panelEliminaProductos panelEliminarProductos = new panelEliminaProductos(this.panelTablaProductos);
        panelEliminarProductos.setControl(this);
        JPanel panelEliminaProductos = (JPanel) panelEliminarProductos;
        // Configura el panel de añadir cliente en la ventanaClientes
        this.ventanaProductos.setPanel(panelEliminaProductos);
        
        verProductos();
    }

    public void modificarCliente() {
    }

    public void borradoProducto(String codigo) {
        Connection conn = modelo.connection.openConnection();
        try {
            // Crear un CallableStatement para llamar al procedimiento almacenado
            CallableStatement cstmt = conn.prepareCall("{call pr_elimina_producto(?)}");

            // Establecer el valor del parámetro de entrada
            cstmt.setString(1, codigo);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            // Mostrar ventana de éxito
            JOptionPane.showMessageDialog(null, "El producto se ha borrado con éxito");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            modelo.connection.closeConnection(conn);
        }
        eliminarProducto();
    }

   public void hacer(String command) {
        switch (command) {
            case "ver":
                verProductos();
                break;
            case "agregar":
                addProducto();
                break;
            case "eliminar":
                eliminarProducto();
                break;
            case "modificar":
                modificarCliente();
                break;
            default:
                System.out.println("Comando inválido");
                break;
        }
    }

    public void setPanelTablaProductos(vista.panelTablaProductos panelTablaProductos) {
        this.panelTablaProductos = panelTablaProductos;
    }
    
    public void setPanelAñadirProducto(vista.panelAñadirProducto panelAñadirProducto) {
       // this.panelAñadirProducto = panelAñadirProducto;
    }
    
    public static void insertarProductos(producto productos){
        String sql = "INSERT INTO PRODUCTO (CODIGO, DESCRIPCION, PRECIO_UNITARIO) VALUES (?, ?, ?)";
        connection conn;

        try (Connection connection = modelo.connection.openConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, productos.getCodigo().toUpperCase());
            pstmt.setString(2, productos.getDescripcion().toUpperCase());
            pstmt.setString(3, productos.getPrecio_unitario().toUpperCase());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Producto insertado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el producto");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
