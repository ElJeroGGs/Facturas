package vista.PanelesProducto;

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

import control.controlproductos;
import modelo.producto;

public class panelActualizaProducto extends JPanel implements ActionListener {

    JLabel lblCodigo, lblPrecioUnitario, lblDescripcion, lblTitulo, txtCodigo;
    JTextField  txtPrecioUnitario, txtCantidad;
    JPanel panelPrincipal, panelTitulo, panelContenido, panelBoton;

      public panelActualizaProducto(String codigo) {
        JButton btnEnviar;

        panelPrincipal = new JPanel(new GridLayout(3,1));
        panelPrincipal.setBorder(new EmptyBorder(10,15,15,20));

        panelTitulo = new JPanel();

        panelContenido = new JPanel(new GridLayout(3,2));
        panelContenido.setBorder(new EmptyBorder(10,20,20,20));

        panelBoton = new JPanel();
        panelContenido.setBorder(new EmptyBorder(0,10,10,10));

        lblTitulo = new JLabel("Añadir Producto");
        Font boldFontTitulo = new Font(lblTitulo.getFont().getFontName(), Font.BOLD, 25); 
        lblTitulo.setFont(boldFontTitulo);

        lblCodigo = new JLabel("Codigo: ");
        lblCodigo.setHorizontalAlignment(JLabel.LEFT);

        lblPrecioUnitario = new JLabel("Precio Unitario: ");
        lblPrecioUnitario.setHorizontalAlignment(JLabel.LEFT);

        lblDescripcion = new JLabel("Descripcion: ");
        lblDescripcion.setHorizontalAlignment(JLabel.LEFT);

        txtCodigo = new JLabel(codigo);
        txtPrecioUnitario = new JTextField();
        txtCantidad = new JTextField();

        btnEnviar = new JButton("Enviar Datos");
        btnEnviar.addActionListener(this);
        btnEnviar.setPreferredSize(new Dimension(150, 30));

        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(panelContenido);

            panelContenido.add(lblCodigo);
            panelContenido.add(txtCodigo);
            panelContenido.add(lblDescripcion);
            panelContenido.add(txtCantidad);
            panelContenido.add(lblPrecioUnitario);
            panelContenido.add(txtPrecioUnitario);

        panelPrincipal.add(panelBoton);

            panelBoton.add(btnEnviar);
            btnEnviar.setHorizontalAlignment(JButton.CENTER);
    }

    public JPanel getPanel(){
        return this.panelPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        producto nuevoProducto = new producto();
            nuevoProducto.setCodigo(txtCodigo.getText());
            nuevoProducto.setDescripcion(txtCantidad.getText());
            nuevoProducto.setPrecio_unitario(txtPrecioUnitario.getText());
    controlproductos.ProductoRefresh(nuevoProducto);

    }
}
