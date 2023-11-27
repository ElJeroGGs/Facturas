package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelEliminaClientes extends JPanel{

 

    public panelEliminaClientes(panelTablaClientes panelTablaClientes) {
        this.setLayout(new BorderLayout());
        this.add(panelTablaClientes, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Eliminar"));
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return this.getPanel();
    }
    
}
