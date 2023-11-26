package vista;
import javax.swing.JFrame;
import java.awt.GridLayout;
import control.controlventanas; 
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class facturas extends JFrame {
                
    private controlventanas control;

                    public facturas() {
                        // Configurar propiedades de la ventana
                        setTitle("Facturas");
                        setSize(600, 300);
                        setLayout(new GridLayout(1, 2));

                        // Panel de botones
                        JPanel panelBotones = new JPanel();
                        panelBotones.setLayout(new GridLayout(6, 1));
                        panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar margen

                        // Agregar componente JLabel con el texto "FACTURAS" en grande
                        JLabel label = new JLabel("FACTURAS");
                        Font font = new Font("Arial", Font.BOLD, 24);
                        label.setFont(font);
                        label.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
                        panelBotones.add(label);

                        // Añadir botón "Ver facturas"
                        JButton btnVerFacturas = new JButton("Ver facturas");
                        panelBotones.add(btnVerFacturas);

                        // Añadir botón "Añadir factura"
                        JButton btnAddFactura = new JButton("Añadir factura");
                        panelBotones.add(btnAddFactura);

                        // Añadir botón "Eliminar factura"
                        JButton btnEliminarFactura = new JButton("Eliminar factura");
                        panelBotones.add(btnEliminarFactura);

                        // Añadir botón "Modificar factura"
                        JButton btnModificarFactura = new JButton("Modificar factura");
                        panelBotones.add(btnModificarFactura);

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
