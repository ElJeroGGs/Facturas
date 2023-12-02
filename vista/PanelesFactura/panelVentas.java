package vista.PanelesFactura;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.SpinnerNumberModel;

import modelo.Venta;
import modelo.producto;

public class panelVentas extends JPanel {

    public panelVentas(List<producto> productos) {
        this.setLayout(new GridLayout(productos.size(), 2));

        // Agregar etiquetas con los códigos de los productos al this
        for (producto p : productos) {
            JLabel lblCodigoProducto = new JLabel(p.getCodigo());
            this.add(lblCodigoProducto);

            JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
            this.add(spinner);
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
                    lista.add(new Venta(null, lblCodigoProducto.getText(), (int) spinner.getValue()));
                }
            }
        }
        return lista;
    }

}
