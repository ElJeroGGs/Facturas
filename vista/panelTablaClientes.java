package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelTablaClientes extends JScrollPane {
    private JTable table;

    public panelTablaClientes() {
        String[] columnNames = {"RUT", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "DOMICILIO", "TELEFONO"};
        this.table = new JTable();
        DefaultTableModel modeloTabla = new DefaultTableModel(columnNames, 0);
        this.table.setModel(modeloTabla);
        this.setViewportView(this.table); // Establecer la tabla como la vista del JScrollPane
    }

    public JTable getTabla() {
        return this.table;
    }
}
