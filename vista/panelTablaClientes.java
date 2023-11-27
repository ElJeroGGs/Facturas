package vista;

import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

public class panelTablaClientes extends JScrollPane {
    private JTable table;
    private Object selectedRecord;

    public panelTablaClientes() {
        String[] columnNames = {"RUT", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "DOMICILIO", "TELEFONO"};
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
