package vista.PanelesFactura;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelTablaFacturas extends JScrollPane {
    private JTable table;
    private Object selectedRecord;

    public panelTablaFacturas() {
        String[] columnNames = {"NUMERO", "FECHA", "SUBTOTAL", "IVA", "TOTAL", "RUT"};
        this.table = new JTable();
        DefaultTableModel modeloTabla = new DefaultTableModel(columnNames, 0);
        this.table.setModel(modeloTabla);
        this.setViewportView(this.table); // Establecer la tabla como la vista del JScrollPane
        
        // Ajustar el tamaño del JScrollPane al tamaño de la tabla
        this.setPreferredSize(this.table.getPreferredSize());
    }

    public JTable getTabla() {
        return this.table;
    }

    public JPanel getPanel() {
        return null;
    }
}