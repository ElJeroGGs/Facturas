package vista.PanelesFactura;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.SpinnerNumberModel;

import modelo.Venta;
import modelo.producto;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class panelVentas extends JPanel {
        public panelVentas(List<producto> productos) {
            int espacioVertical = 10;
            int espaciohorizontal = 20;
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(espacioVertical, espaciohorizontal, espacioVertical, espaciohorizontal);

            // Agregar etiquetas con los códigos de los productos al this
            for (int i = 0; i < productos.size(); i++) {
                producto p = productos.get(i);
                JLabel lblCodigoProducto = new JLabel(p.getCodigo() + " - " + p.getDescripcion());
                lblCodigoProducto.setName(p.getCodigo());
                gbc.gridx = 0;
                gbc.gridy = i;
                gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
                this.add(lblCodigoProducto, gbc);

                JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
                gbc.gridx = 1;
                gbc.gridy = i;
                gbc.anchor = GridBagConstraints.EAST; // Alinear a la derecha
                this.add(spinner, gbc);
            }
            this.setBorder(new EmptyBorder(0, 10, 0, 10));
        }

    public JPanel getPanel() {
        return this;
    }

    public List<Venta> getVenta() {
        List<Venta> lista = new ArrayList<>();
        for (int i = 0; i < this.getComponentCount(); i++) {
            if (i % 2 == 0) {
                JLabel lblCodigoProducto = (JLabel) this.getComponent(i);
                JSpinner spinner = (JSpinner) this.getComponent(i + 1);
                if ((int) spinner.getValue() > 0) {
                    lista.add(new Venta(null, lblCodigoProducto.getName(), (int) spinner.getValue()));
                }
            }
        }
        return lista;
    }

}
