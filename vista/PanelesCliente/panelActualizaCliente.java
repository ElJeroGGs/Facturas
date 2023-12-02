package vista.PanelesCliente;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.controlclientes;
import modelo.cliente;

public class panelActualizaCliente extends JPanel implements ActionListener {

    JPanel panelPrincipal, panelContenido, panelBtn;
    JTextField  txtNombre, txtApellido1, txtApellido2, txtTelefono, txtDomicilio;
    String rut;

      public panelActualizaCliente(String rut) {
        this.rut = rut;
        
        JLabel lblRut, lblNombre, lblApellido1, lblApellido2, lblTelefono, lblDomicilio, titulo, txtRut;
        
        JButton btnEnviar;

        panelPrincipal = new JPanel(new GridLayout(3,1));
        panelPrincipal.setBorder(new EmptyBorder(10,15,15,20));

        panelContenido = new JPanel(new GridLayout(6,2));
        panelContenido.setBorder(new EmptyBorder(10,20,20,20));
        
        panelBtn = new JPanel();
        panelContenido.setBorder(new EmptyBorder(0,10,10,10));
       
        txtRut = new JLabel(rut);
        txtNombre = new JTextField();
        txtApellido1 = new JTextField();
        txtApellido2 = new JTextField();
        txtTelefono = new JTextField();
        txtDomicilio = new JTextField();

        titulo = new JLabel("ACTUALIZAR CLIENTES");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        
        Font boldFontTitulo = new Font(titulo.getFont().getFontName(), Font.BOLD, 25); 
        titulo.setFont(boldFontTitulo);
        
        lblRut = new JLabel("RUT: ");
        lblRut.setHorizontalAlignment(JLabel.LEFT);
        
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setHorizontalAlignment(JLabel.LEFT);
        
        lblApellido1 = new JLabel("Apellido 1: ");
        lblApellido1.setHorizontalAlignment(JLabel.LEFT);
        
        lblApellido2 = new JLabel("Apellido 2: ");
        lblApellido2.setHorizontalAlignment(JLabel.LEFT);
        
        lblDomicilio = new JLabel("Domicilio: ");
        lblDomicilio.setHorizontalAlignment(JLabel.LEFT);
        
        lblTelefono = new JLabel("Telefono: ");
        lblTelefono.setHorizontalAlignment(JLabel.LEFT);
        
        btnEnviar = new JButton("Actualizar Datos");
        btnEnviar.addActionListener(this);
        btnEnviar.setPreferredSize(new Dimension(150, 30));
        
        panelPrincipal.add(titulo);

        panelPrincipal.add(panelContenido);
        
        panelContenido.add(lblRut);
        panelContenido.add(txtRut);
        panelContenido.add(lblNombre);
        panelContenido.add(txtNombre);
        panelContenido.add(lblApellido1);
        panelContenido.add(txtApellido1);
        panelContenido.add(lblApellido2);
        panelContenido.add(txtApellido2);
        panelContenido.add(lblDomicilio);
        panelContenido.add(txtDomicilio);
        panelContenido.add(lblTelefono);
        panelContenido.add(txtTelefono);


        panelPrincipal.add(panelBtn);
        
        panelBtn.add(btnEnviar);
        btnEnviar.setHorizontalAlignment(JButton.CENTER);
    }

    public JPanel getPanel(){
        return this.panelPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    modelo.cliente nuevoCliente = new cliente();
nuevoCliente.setRut(rut);
nuevoCliente.setNombre(txtNombre.getText());
nuevoCliente.setApellido1(txtApellido1.getText());
nuevoCliente.setApellido2(txtApellido2.getText());
nuevoCliente.setDomicilio(txtDomicilio.getText());
nuevoCliente.setTelefono(txtTelefono.getText());

    controlclientes.ClienteRefresh(nuevoCliente);

    }
}
