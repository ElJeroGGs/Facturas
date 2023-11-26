package vista;
import javax.swing.JFrame;
import java.awt.GridLayout;
import control.controlventanas; 
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class productos extends JFrame {

                

        private controlventanas control;

        public productos() {
            // Configurar propiedades de la ventana
            setTitle("Productos");
            setSize(600, 300);
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
            panelBotones.add(btnVerProductos);

            // Añadir botón "Añadir producto"
            JButton btnAddProducto = new JButton("Añadir producto");
            panelBotones.add(btnAddProducto);

            // Añadir botón "Eliminar producto"
            JButton btnEliminarProducto = new JButton("Eliminar producto");
            panelBotones.add(btnEliminarProducto);

            // Añadir botón "Modificar producto"
            JButton btnModificarProducto = new JButton("Modificar producto");
            panelBotones.add(btnModificarProducto);

            add(panelBotones);

            // Panel adicional a la derecha
            JPanel panelExtra = new JPanel();
            // Configurar propiedades del panel extra
            // ...

            add(panelExtra);

            // Centrar la ventana en la pantalla
            setLocationRelativeTo(null);
        }

        public void setControlVentanas(controlventanas control) {
            this.control = control;
        }
        
    }
