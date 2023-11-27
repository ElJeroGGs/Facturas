package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.w3c.dom.events.MouseEvent;

import control.controlclientes;
import control.controlproductos;

public class panelModificaProducto extends JPanel implements ActionListener{
String selectedRecord;
private control.controlproductos controlproductos;

    public panelModificaProducto(panelTablaProductos panelTablaProductos){
        this.setLayout(new BorderLayout());
        
        JPanel contentPanel = new JPanel(new GridLayout(2, 1)); // Use GridLayout with 2 rows and 1 column
        contentPanel.add(panelTablaProductos);
        
        JPanel buttonPanel = new JPanel();
        JButton modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(this);
        
        buttonPanel.add(modificarButton);
        contentPanel.add(buttonPanel);
        this.add(contentPanel, BorderLayout.CENTER);

        //Comportamiento del MouseListener
        setupMouseListener(panelTablaProductos.getTabla());
    }

    private void setupMouseListener(JTable paneltabla) {
        paneltabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = paneltabla.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    selectedRecord = (String) paneltabla.getModel().getValueAt(row, 0); // Guardar el primer dato del registro seleccionado
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (selectedRecord == null) {
            JOptionPane.showMessageDialog(this, "Debes escoger un cliente");
        } else {
            controlproductos.modificadoProducto(selectedRecord);
        }
    }

public void setControl(controlproductos controlproductos) {
        this.controlproductos = controlproductos;
    }

    public JPanel getPanel() {
        return this.getPanel();
    }
    
}
