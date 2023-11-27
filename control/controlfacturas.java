package control;

import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.connection;
import vista.panelEliminaProductos;
import vista.panelEliminarFactura;
import vista.panelGenerarFactura;
import java.sql.Types;
import javax.swing.JLabel;

public class controlfacturas {
    private vista.facturas ventanaFacturas;
    private vista.panelTablaFactura panelTablaFactura;

    public void setVentanaFacturas(vista.facturas ventanaFacturas) {
        this.ventanaFacturas = ventanaFacturas;
    }
    
    public void verFacturas(){
        JTable Tabla =  panelTablaFactura.getTabla();      

        DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
        modeloTabla.setRowCount(0);
        connection conn;
        Connection connection = modelo.connection.openConnection();
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FACTURA");
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

    public void addFactura(){
        JPanel panelAñadirFactura = new vista.panelAñadirFactura().getPanel();
        // Configura el panel de añadir cliente en la ventanaClientes
        this.ventanaFacturas.setPanel(panelAñadirFactura);
    }

    public void eliminarFactura(){
        verFacturas();
        panelEliminarFactura panelEliminaFactura = new panelEliminarFactura(this.panelTablaFactura);
        panelEliminaFactura.setControl(this);
        JPanel panelEliminarFactura = (JPanel) panelEliminaFactura;

        this.ventanaFacturas.setPanel(panelEliminarFactura);
    }

    public void borradoFactura(String numero) {
        Connection conn = modelo.connection.openConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM FACTURA WHERE numero = ?");
            preparedStatement.setString(1, numero);
            preparedStatement.executeUpdate();

            // Mostrar ventana de éxito
            JOptionPane.showMessageDialog(null, "La factura se ha borrado con éxito");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            modelo.connection.closeConnection(conn);
        }
        eliminarFactura();
    }

    

    public void hacer(String command) {
        switch (command) {
            case "generar":
            generarFactura();
                break;
            case "agregar":
                addFactura();
                break;
            case "eliminar":
                eliminarFactura();
                break;
            
            default:
                System.out.println("Comando inválido");
                break;
        }
    }

    private void generarFactura() {
        verFacturas();
        panelGenerarFactura panelGenerarFactura = new panelGenerarFactura(this.panelTablaFactura);
        panelGenerarFactura.setControl(this);
        JPanel panelGeneraFactura = (JPanel) panelGenerarFactura;

        this.ventanaFacturas.setPanel(panelGeneraFactura);

    }

    public void setPanelTablaFactura(vista.panelTablaFactura panelTablaFactura) {
        this.panelTablaFactura = panelTablaFactura;
    }

    public void generadoFactura(String selectedRecord) {
        String reporte = "";

        Connection conn = modelo.connection.openConnection();
        try {
            // Obtener la conexión a la base de datos
            Connection connection = modelo.connection.openConnection();

            // Habilitar la salida del servidor
            CallableStatement enableOutput = connection.prepareCall("BEGIN DBMS_OUTPUT.ENABLE; END;");
            enableOutput.execute();
            enableOutput.close();

            // Ejecutar el procedimiento almacenado
            String query = "{CALL pr_reporte_de_factura(?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, selectedRecord);
            statement.execute();
            statement.close();

            // Recuperar la salida del servidor
            CallableStatement retrieveOutput = connection.prepareCall("BEGIN DBMS_OUTPUT.GET_LINE(:1, :2); END;");

            try {
                retrieveOutput.registerOutParameter(1, Types.VARCHAR);
                retrieveOutput.registerOutParameter(2, Types.INTEGER);
                int status = 0;
                StringBuilder lines = new StringBuilder(); // Store all lines
                while (status == 0) {
                    retrieveOutput.execute();
                    String line = retrieveOutput.getString(1);
                    status = retrieveOutput.getInt(2);
                    if (line != null && status == 0) {
                        lines.append(line).append("\n"); // Append each line
                    }
                }
                retrieveOutput.close();

                JPanel factura = new JPanel();
                JTextArea textArea = new JTextArea(lines.toString());
                Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12).deriveFont(Font.BOLD); // Cambia "12" por el tamaño de fuente deseado
                textArea.setFont(font);
                textArea.setEditable(false);
                factura.add(textArea);
                this.ventanaFacturas.setPanel(factura);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
