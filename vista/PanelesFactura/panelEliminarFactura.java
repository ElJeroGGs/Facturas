package vista.PanelesFactura;

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

import control.controlclientes;
import control.controlfacturas;

public class panelEliminarFactura extends JPanel implements ActionListener{
    private controlfacturas controlfacturas;
    String selectedRecord;

    public panelEliminarFactura(panelTablaFactura panelTablaFactura){
        this.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel(new GridLayout(2, 1)); 
        contentPanel.add(panelTablaFactura);

        JPanel buttonPanel = new JPanel();
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(this);

        buttonPanel.add(eliminarButton);
        contentPanel.add(buttonPanel);
        this.add(contentPanel, BorderLayout.CENTER);

        //Comportamiento del MouseListener
        setupMouseListener(panelTablaFactura.getTabla());
    }

    private void setupMouseListener(JTable paneltabla) {
        paneltabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = paneltabla.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    selectedRecord = (String) paneltabla.getModel().getValueAt(row, 0);
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (selectedRecord == null) {
            // Mostrar ventana que diga "Selecciona una factura"
            JOptionPane.showMessageDialog(this, "Selecciona una factura", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            controlfacturas.borradoFactura(selectedRecord);
        }
    }


    public void setControl(controlfacturas controlfacturas) {
        this.controlfacturas = controlfacturas;
    }

    public JPanel getPanel() {
        return this.getPanel();
    }

}
