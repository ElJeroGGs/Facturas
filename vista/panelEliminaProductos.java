package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import control.controlproductos;

public class panelEliminaProductos extends JPanel implements ActionListener{

private controlproductos controlproductos;
String selectedRecord;

    public panelEliminaProductos(panelTablaProductos panelTablaProductos) {
        this.setLayout(new BorderLayout());
        
        JPanel contentPanel = new JPanel(new GridLayout(2, 1)); // Use GridLayout with 2 rows and 1 column
        contentPanel.add(panelTablaProductos);
        
        JPanel buttonPanel = new JPanel();
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(this);
        
        buttonPanel.add(eliminarButton);
        contentPanel.add(buttonPanel);
        this.add(contentPanel, BorderLayout.CENTER);

        //Comportamiento del MouseListener
        setupMouseListener(panelTablaProductos.getTabla());
    }

    private void setupMouseListener(JTable paneltabla) {
        paneltabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
            // Show a window with the message "Selecciona un registro"
            JOptionPane.showMessageDialog(this, "Selecciona un registro");
        } else {
            // Print the selected record and perform the deletion
            System.out.println("Registro seleccionado: " + selectedRecord);
            controlproductos.borradoProducto(selectedRecord);
        }
    }

    public void setControl(controlproductos controlproductos) {
        this.controlproductos = controlproductos;
    }

    public JPanel getPanel() {
        return this.getPanel();
    }

    }
