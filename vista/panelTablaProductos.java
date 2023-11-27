package vista;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelTablaProductos extends JScrollPane{
private JTable table;

    public panelTablaProductos() {
     String[] columnNames = {"CÓDIGO", "DESCRIPCIÓN", "PRECIO UNITARIO"};
                table = new JTable();                       
                DefaultTableModel modeloTabla = new DefaultTableModel(columnNames, 0);
                table.setModel(modeloTabla);
                this.setViewportView(this.table);
}

    public JTable getTabla() {
        return this.table;
    }
}
