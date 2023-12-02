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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelGenerarFactura extends JPanel implements ActionListener {

    private controlfacturas control;
    private panelVentas panelVentas;
    private JComboBox<String> comboBoxClientes;
    

    public panelGenerarFactura(List<cliente> clientes, panelVentas panelVentas) {
        JPanel panelclientes = new JPanel(new GridLayout(1, 2));
        JPanel panelproductos = new JPanel();
        JPanel panelboton = new JPanel();

        setLayout(new GridLayout(3, 1)); // Set GridLayout with 4 rows and 1 column

        JLabel lblSeleccionaCliente = new JLabel("Selecciona un cliente");
        panelclientes.add(lblSeleccionaCliente);
        panelclientes.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create a JComboBox with client ruts
        comboBoxClientes = new JComboBox<>();
        comboBoxClientes.setToolTipText("Si desconoces el rut, puedes consultar toda la información relacionada a los clientes en la pestaña de clientes");
        for (cliente c : clientes) {
            comboBoxClientes.addItem(c.getRut());
        }
        comboBoxClientes.setSelectedIndex(-1); // Asegura que no haya nada seleccionado por defecto
        panelclientes.add(comboBoxClientes);

        panelboton.setBorder(new EmptyBorder(0, 10, 0, 10));
        JButton btnGenerarFactura = new JButton("Generar Factura");
        btnGenerarFactura.addActionListener(this);
        panelboton.add(btnGenerarFactura);

        // agrega paneles al panel principal
        this.add(panelclientes);
        this.add(panelVentas);
        this.add(panelboton);
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
