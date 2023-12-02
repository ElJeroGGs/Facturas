package vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import control.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame implements ActionListener {
    controlventanas control = new controlventanas();

    public Inicio() {
        // Configurar propiedades de la ventana
        setTitle("COMPU S. A. FACTURAS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel principal con GridLayout
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agregar margen
        getContentPane().add(panel);

        // Crear mensaje de bienvenida
        JLabel lblBienvenido = new JLabel("Bienvenido, ¿qué deseas hacer?");
        lblBienvenido.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiar fuente y tamaño
        lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
        panel.add(lblBienvenido);

        // Crear botón de clientes
        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agregar espacio
        btnClientes.setActionCommand("clientes");
        panel.add(btnClientes);

        // Crear botón de productos
        JButton btnProductos = new JButton("Productos");
        btnProductos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agregar espacio
        btnProductos.setActionCommand("productos");
        panel.add(btnProductos);

        // Crear botón de facturas
        JButton btnFacturas = new JButton("Facturas");
        btnFacturas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agregar espacio
        btnFacturas.setActionCommand("facturas");
        panel.add(btnFacturas);

        // Agregar el ActionListener a los botones
        btnClientes.addActionListener(this);
        btnProductos.addActionListener(this);
        btnFacturas.addActionListener(this);

        // Acomoda la ventana
        this.pack();
        setLocationRelativeTo(null);

    }

    public void setControlVentanas(controlventanas control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        control.abrir(command);

    }

}
