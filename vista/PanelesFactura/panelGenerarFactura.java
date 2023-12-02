package vista.PanelesFactura;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.controlfacturas;
import modelo.cliente;
import modelo.producto;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelGenerarFactura extends JPanel implements ActionListener {

    private controlfacturas control;
    private panelVentas panelVentas;
    private JComboBox<String> comboBoxClientes;

    public panelGenerarFactura(List<cliente> clientes, panelVentas panelVentas) {
        JPanel panelclientes = new JPanel(new GridBagLayout());
        JPanel panelboton = new JPanel(new GridBagLayout());

        setLayout(new GridBagLayout()); // Set GridBagLayout for the main panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 0, 10);

        JLabel lblSeleccionaCliente = new JLabel("Selecciona un cliente");
        lblSeleccionaCliente.setHorizontalAlignment(JLabel.CENTER);
        panelclientes.add(lblSeleccionaCliente, gbc);

        // Create a JComboBox with client ruts
        comboBoxClientes = new JComboBox<>();
        comboBoxClientes.setToolTipText(
                "Si desconoces el rut, puedes consultar toda la información relacionada a los clientes en la pestaña de clientes");
        for (cliente c : clientes) {
            comboBoxClientes.addItem(c.getRut());
        }
        comboBoxClientes.setSelectedIndex(-1); // Asegura que no haya nada seleccionado por defecto
        Dimension d = new Dimension(200, 20);
        comboBoxClientes.setPreferredSize(d);

        panelboton.setBorder(new EmptyBorder(0, 10, 3, 10));
        JButton btnGenerarFactura = new JButton("Generar Factura");
        btnGenerarFactura.addActionListener(this);
        panelboton.add(btnGenerarFactura);

        gbc.gridy = 1;
        panelclientes.add(comboBoxClientes, gbc);

        gbc.gridy = 2;
        add(panelclientes, gbc);

        gbc.gridy = 3;
        add(panelVentas, gbc);

        gbc.gridy = 4;
        add(panelboton, gbc);
    }

    // END: ed8c6549bwf9

    public JPanel getPanel() {
        return this;
    }

    public void setControl(controlfacturas control) {
        this.control = control;
    }

    public void setPanelVentas(panelVentas panelVentas) {
        this.panelVentas = panelVentas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rut = (String) this.comboBoxClientes.getSelectedItem();
        if (rut == null) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            control.crearFactura(this.panelVentas, rut);
        }
    }

}
