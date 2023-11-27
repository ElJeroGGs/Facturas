package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.controlclientes;

public class panelEliminaClientes extends JPanel implements ActionListener{

private controlclientes controlclientes;
String selectedRecord;

    public panelEliminaClientes(panelTablaClientes panelTablaClientes) {
        this.setLayout(new BorderLayout());
        
        JPanel contentPanel = new JPanel(new GridLayout(2, 1)); // Use GridLayout with 2 rows and 1 column
        contentPanel.add(panelTablaClientes);
        
        JPanel buttonPanel = new JPanel();
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(this);
        buttonPanel.add(eliminarButton);
        contentPanel.add(buttonPanel);
        this.add(contentPanel, BorderLayout.CENTER);

        //Comportamiento del MouseListener
        setupMouseListener(panelTablaClientes.getTabla());
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
        //quiero ver el registro seleccionado
        System.out.println("Registro seleccionado: " + selectedRecord);
        controlclientes.borradoCliente(selectedRecord);
    }

    public void setControl(controlclientes controlclientes) {
        this.controlclientes = controlclientes;
    }

    public JPanel getPanel() {
        return this.getPanel();
    }

    }
