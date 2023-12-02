package vista.PanelesProducto;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelTablaProductos extends JScrollPane{
private JTable table;
private Object selectedRecord;
    public panelTablaProductos() {
     String[] columnNames = {"CÓDIGO", "DESCRIPCIÓN", "PRECIO UNITARIO"};
                this.table = new JTable();                       
                DefaultTableModel modeloTabla = new DefaultTableModel(columnNames, 0);
                this.table.setModel(modeloTabla);
                this.setViewportView(this.table);
                this.setPreferredSize(this.table.getPreferredSize());
}

public JTable getTabla() {
    return this.table;
}
public JPanel getPanel() {
    return this.getPanel();
}
}
