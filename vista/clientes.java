package vista;
import javax.swing.JFrame;
import java.awt.GridLayout;

import control.controlclientes;
import control.controlventanas;
import modelo.connection;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


                public class clientes extends JFrame implements ActionListener {
                    
                    private controlventanas control;
                    private controlclientes controlclientes;
                    private JTable table;
                    
                    public DefaultTableModel getTableModel() {
                        return (DefaultTableModel) table.getModel();
                    }
                    
                    public clientes() {
                        // Configurar propiedades de la ventana
                        setTitle("Clientes");
                        setSize(1000, 300);
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
                        btnVerClientes.setActionCommand("ver");
                        btnVerClientes.addActionListener(this);
                        panelBotones.add(btnVerClientes);

                        // Añadir botón "Añadir cliente"
                        JButton btnAddCliente = new JButton("Añadir cliente");
                        btnAddCliente.setActionCommand("agregar");
                        btnAddCliente.addActionListener(this);
                        panelBotones.add(btnAddCliente);

                        // Añadir botón "Eliminar cliente"
                        JButton btnEliminarCliente = new JButton("Eliminar cliente");
                        btnEliminarCliente.setActionCommand("eliminar");
                        btnEliminarCliente.addActionListener(this);
                        panelBotones.add(btnEliminarCliente);

                        // Añadir botón "Modificar cliente"
                        JButton btnModificarCliente = new JButton("Modificar cliente");
                        btnModificarCliente.setActionCommand("modificar");
                        btnModificarCliente.addActionListener(this);
                        panelBotones.add(btnModificarCliente);

                        add(panelBotones);

                        // Panel adicional a la derecha
                        JPanel panelExtra = new JPanel();
                        // Configurar propiedades del panel extra

                        //tabla 
                        String[] columnNames = {"RUT", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "DOMICILIO", "TELEFONO"};
                  
                        table = new JTable();
                        DefaultTableModel modeloTabla = new DefaultTableModel(columnNames, 0);
                        table.setModel(modeloTabla);
                        JScrollPane scrollPane = new JScrollPane(table); 

                        panelExtra.add(scrollPane);
                        add(panelExtra);
                        // Centrar la ventana en la pantalla
                        setLocationRelativeTo(null);

                    }

                    public void setControlVentanas(controlventanas control) {
                        this.control = control;
                    }

                    public void setControlClientes(controlclientes controlclientes) {
                        this.controlclientes = controlclientes;
                    }


                    public void pintaTabla(JTable tabla) {
                        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
                        controlclientes.verClientes(modeloTabla);
                    
                    }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        controlclientes.hacer(command);
                    
                    }
                }


    


