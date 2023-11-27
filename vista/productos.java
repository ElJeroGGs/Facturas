package vista;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlclientes;
import control.controlproductos;
import control.controlventanas; 
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class productos extends JFrame implements ActionListener{

        private controlproductos controlproductos;
        private JTable table;
        private controlventanas control;
        private JScrollPane panelExtra;

        public productos() {
            // Configurar propiedades de la ventana
            setTitle("Productos");
            setSize(1000, 300);
            setLayout(new GridLayout(1, 2));

            // Panel de botones
            JPanel panelBotones = new JPanel();
            panelBotones.setLayout(new GridLayout(6, 1));
            panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar margen

            // Agregar componente JLabel con el texto "PRODUCTOS" en grande
            JLabel label = new JLabel("PRODUCTOS");
            Font font = new Font("Arial", Font.BOLD, 24);
            label.setFont(font);
            label.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
            panelBotones.add(label);

            // Añadir botón "Ver productos"
             JButton btnVerProductos = new JButton("Ver productos");
             btnVerProductos.setActionCommand("ver");
             btnVerProductos.addActionListener(this);
             panelBotones.add(btnVerProductos);

            // Añadir botón "Añadir producto"
            JButton btnAddProducto = new JButton("Añadir producto");
            btnAddProducto.setActionCommand("agregar");
            btnAddProducto.addActionListener(this);
            panelBotones.add(btnAddProducto);

            // Añadir botón "Eliminar producto"
            JButton btnEliminarProducto = new JButton("Eliminar producto");
            btnEliminarProducto.setActionCommand("eliminar");
            btnEliminarProducto.addActionListener(this);
            panelBotones.add(btnEliminarProducto);

            // Añadir botón "Modificar producto"
            JButton btnModificarProducto = new JButton("Modificar producto");
            btnModificarProducto.setActionCommand("modificar");
            btnModificarProducto.addActionListener(this);
            panelBotones.add(btnModificarProducto);

            add(panelBotones);

            // Panel adicional a la derecha
              this.panelExtra = new JScrollPane();
                // Configurar propiedades del panel extra
                add(panelExtra);
                // Centrar la ventana en la pantalla
                setLocationRelativeTo(null);



        }

        public void setControlVentanas(controlventanas control) {
            this.control = control;
        }

        public DefaultTableModel getTableModel() {
            return (DefaultTableModel) table.getModel();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                controlproductos.hacer(command);
            
        }

        public void setControlProductos(control.controlproductos controlproductos2) {
            this.controlproductos = controlproductos2;
        }

        public void setPanel(JScrollPane scrollPane) {
            panelExtra.setViewportView(scrollPane); // Establecer el nuevo JScrollPane como la vista del JScrollPane existente
            panelExtra.revalidate(); // Recalcular el layout de panelExtra
            panelExtra.repaint(); // Redibujar panelExtra
        }

        public void setPanel(JPanel newPanel) {
            panelExtra.setViewportView(newPanel); // Establecer el nuevo JPanel como la vista del JScrollPane
            panelExtra.revalidate(); // Recalcular el layout de panelExtra
            panelExtra.repaint(); // Redibujar panelExtra
        }

        
    }
