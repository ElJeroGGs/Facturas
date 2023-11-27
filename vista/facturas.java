package vista;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlclientes;
import control.controlfacturas;
import control.controlventanas; 
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class facturas extends JFrame implements ActionListener{
                
                    private controlventanas control;
                    private controlfacturas controlfacturas;
                    private JScrollPane panelExtra;  
                    private JTable table;
                    
                    public DefaultTableModel getTableModel() {
                        return (DefaultTableModel) table.getModel();
                    }

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
                        btnAddFactura.setActionCommand("agregar");
                        btnAddFactura.addActionListener(this);                        
                        panelBotones.add(btnAddFactura);
  

                        // Añadir botón "Eliminar factura"
                        JButton btnEliminarFactura = new JButton("Eliminar factura");
                        panelBotones.add(btnEliminarFactura);



                        add(panelBotones);

                        // Panel adicional a la derecha
                        this.panelExtra = new JScrollPane();
                        add(this.panelExtra);
                        // Centrar la ventana en la pantalla
                        setLocationRelativeTo(null);
                    }

                    public void setControlVentanas(controlventanas control) {
                        this.control = control;
                    }

                    public void setControlfacturas(controlfacturas controlfacturas) {
                        this.controlfacturas = controlfacturas;
                    }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        controlfacturas.hacer(command);
                        System.out.println(command);
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
