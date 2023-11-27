package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelEliminaClientes extends JPanel{

 

    public panelEliminaClientes(panelTablaClientes panelTablaClientes) {
        this.setLayout(new BorderLayout());
        
        JPanel contentPanel = new JPanel(new GridLayout(2, 1)); // Use GridLayout with 2 rows and 1 column
        contentPanel.add(panelTablaClientes);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Eliminar"));
        contentPanel.add(buttonPanel);
        
        this.add(contentPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return this.getPanel();
    }
    
}
