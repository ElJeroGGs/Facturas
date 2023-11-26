package vista;
import javax.swing.JFrame;
import java.awt.GridLayout;
import control.controlventanas; 
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

            public class clientes extends JFrame {
                
                private controlventanas control;

                public clientes() {
                    // Configurar propiedades de la ventana
                    setTitle("Clientes");
                    setSize(600, 300);
                    setLayout(new GridLayout(1, 2));

                    // Panel de botones
                    JPanel panelBotones = new JPanel();
                    panelBotones.setLayout(new GridLayout(6, 1));
                    panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar margen

                    // Agregar componente JLabel con el texto "CLIENTES" en grande
                    JLabel label = new JLabel("CLIENTES");
                    Font font = new Font("Arial", Font.BOLD, 24);
                    label.setFont(font);
                    label.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
                    panelBotones.add(label);

                    // Añadir botón "Ver clientes"
                    JButton btnVerClientes = new JButton("Ver clientes");
                    panelBotones.add(btnVerClientes);

                    // Añadir botón "Añadir cliente"
                    JButton btnAddCliente = new JButton("Añadir cliente");
                    panelBotones.add(btnAddCliente);

                    // Añadir botón "Eliminar cliente"
                    JButton btnEliminarCliente = new JButton("Eliminar cliente");
                    panelBotones.add(btnEliminarCliente);

                    // Añadir botón "Modificar cliente"
                    JButton btnModificarCliente = new JButton("Modificar cliente");
                    panelBotones.add(btnModificarCliente);

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


    


