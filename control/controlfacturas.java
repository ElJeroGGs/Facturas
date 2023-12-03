package control;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

import modelo.Venta;
import modelo.connection;
import vista.PanelesFactura.panelEliminarFactura;
import vista.PanelesFactura.panelVentas;
import vista.PanelesFactura.panelConsultarFactura;
import vista.PanelesProducto.panelEliminaProductos;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class controlfacturas {

    public controlfacturas() {
        this.ultimoNumeroCodigo = leerUltimoNumeroCodigo();
    }

    private int ultimoNumeroCodigo;
    private vista.facturas ventanaFacturas;
    private vista.PanelesFactura.panelTablaFactura panelTablaFactura;

    public void setVentanaFacturas(vista.facturas ventanaFacturas) {
        this.ventanaFacturas = ventanaFacturas;
    }

    public void verFacturas() {
        JTable Tabla = panelTablaFactura.getTabla();

        DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
        modeloTabla.setRowCount(0);
        connection conn;
        Connection connection = modelo.connection.openConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FACTURA ORDER BY RUT");
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnas = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
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

    public void addFactura() {
        List<modelo.cliente> clientes = new ArrayList<>();
        List<modelo.producto> productos = new ArrayList<>(); // Add this line

        try (Connection conexion = modelo.connection.openConnection()) { // Fix method name
            String consultaClientes = "SELECT RUT, NOMBRE FROM CLIENTE";
            Statement statementClientes = conexion.createStatement();
            ResultSet resultadoClientes = statementClientes.executeQuery(consultaClientes);

            while (resultadoClientes.next()) {
                String nombreCliente = resultadoClientes.getString("nombre");
                String rutCliente = resultadoClientes.getString("rut");
                clientes.add(new modelo.cliente(rutCliente, nombreCliente)); // Fix constructor
            }

            String consultaProductos = "SELECT CODIGO, DESCRIPCION FROM producto";
            Statement statementProductos = conexion.createStatement();
            ResultSet resultadoProductos = statementProductos.executeQuery(consultaProductos);

            while (resultadoProductos.next()) {
                String nombreProducto = resultadoProductos.getString("descripcion");
                String codigoProducto = resultadoProductos.getString("codigo");
                productos.add(new modelo.producto(codigoProducto, nombreProducto)); // Fix constructor
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        panelVentas panelVentas = new panelVentas(productos);
        vista.PanelesFactura.panelGenerarFactura panel = new vista.PanelesFactura.panelGenerarFactura(clientes,
                panelVentas);
        panel.setControl(this);
        panel.setPanelVentas(panelVentas);
        JPanel panelGenerarFactura = panel.getPanel();
        this.ventanaFacturas.setPanel(panelGenerarFactura);
    }

    public void eliminarFactura() {
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
        panelConsultarFactura panelConsultarFactura = new panelConsultarFactura(this.panelTablaFactura);
        panelConsultarFactura.setControl(this);
        JPanel panelGeneraFactura = (JPanel) panelConsultarFactura;

        this.ventanaFacturas.setPanel(panelGeneraFactura);

    }

    public void setPanelTablaFactura(vista.PanelesFactura.panelTablaFactura panelTablaFactura) {
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
                Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12).deriveFont(Font.BOLD); // Cambia "12" por el
                                                                                             // tamaño de fuente deseado
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

    public void crearFactura(panelVentas panelVentas, String RUT) {

        List<Venta> Venta = panelVentas.getVenta();
        if (Venta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun producto", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            try (Connection conexion = modelo.connection.openConnection()) {
                String codigo = generarCodigo();

                // Preparar la llamada al procedimiento almacenado
                CallableStatement stmt = conexion.prepareCall("{call agregar_venta(?, ?, ?, ?)}");
                for (Venta ventita : Venta) {
                    // Establecer los parámetros del procedimiento almacenado
                    stmt.setInt(1, ventita.getCantidad());
                    stmt.setString(2, ventita.getCodigo());
                    stmt.setString(3, codigo);
                    stmt.setString(4, RUT);

                    // Ejecutar el procedimiento almacenado
                    stmt.execute();
                }

                // Display success message in a JDialog
                JOptionPane.showMessageDialog(null, "Factura creada exitosamente", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    public String generarCodigo() {
        String codigo = "A" + ultimoNumeroCodigo;
        escribirUltimoNumeroCodigo(++ultimoNumeroCodigo);
        return codigo;
    }

    private void escribirUltimoNumeroCodigo(int ultimoNumeroCodigo) {
        try {
            FileWriter escritor = new FileWriter("ultimoNumeroCodigo.txt");
            escritor.write(String.valueOf(ultimoNumeroCodigo));
            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private int leerUltimoNumeroCodigo() {
        try {
            File archivo = new File("ultimoNumeroCodigo.txt");
            if (archivo.exists()) {
                Scanner lector = new Scanner(archivo);
                if (lector.hasNextInt()) {
                    return lector.nextInt();
                }
                lector.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return 2300; // Valor por defecto si no se pudo leer el archivo
    }

}
