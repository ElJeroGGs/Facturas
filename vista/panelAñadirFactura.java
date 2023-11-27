package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class panelAñadirFactura extends JPanel{

    JTextField txtnumero, txtfecha, txtsubtotal, txtiva, txttotal, txtruta;   
    JPanel panelPrincipal, panelContenido, panelBoton;

    public panelAñadirFactura(){
        JLabel lblnumero, lblfecha, lblsubtotal, lbliva, lbltotal, lblruta, lbltitulo;  
        JButton btnEnviar;

        panelPrincipal = new JPanel(new GridLayout(3,1));
        panelPrincipal.setBorder(new EmptyBorder(10,15,15,20));

        panelContenido = new JPanel(new GridLayout(6,2));
        panelContenido.setBorder(new EmptyBorder(10,20,20,20));

        panelBoton = new JPanel();
        panelContenido.setBorder(new EmptyBorder(0,10,10,10));

        lbltitulo = new JLabel("AÑADIR FACTURA");
        Font boldFontTitulo = new Font(lbltitulo.getFont().getFontName(), Font.BOLD, 25); 
        lbltitulo.setFont(boldFontTitulo);
        lbltitulo.setHorizontalAlignment(JLabel.CENTER);

        lblnumero = new JLabel("Numero: ");
        lblnumero.setHorizontalAlignment(JLabel.LEFT);

        lblfecha = new JLabel("Fecha (DD/MM/AAAA): ");
        lblfecha.setHorizontalAlignment(JLabel.LEFT);

        lblsubtotal = new JLabel("Subtotal: ");
        lblsubtotal.setHorizontalAlignment(JLabel.LEFT);

        lbliva = new JLabel("IVA: ");
        lbliva.setHorizontalAlignment(JLabel.LEFT);

        lbltotal = new JLabel("Total: ");
        lbltotal.setHorizontalAlignment(JLabel.LEFT);

        lblruta = new JLabel("RUT: ");
        lblruta.setHorizontalAlignment(JLabel.LEFT);

        btnEnviar = new JButton("Enviar Datos");
        btnEnviar.setPreferredSize(new Dimension(150, 30));

        txtnumero = new JTextField(); 
        txtfecha = new JTextField(); 
        txtsubtotal = new JTextField(); 
        txtiva = new JTextField(); 
        txttotal = new JTextField(); 
        txtruta = new JTextField(); 

        panelPrincipal.add(lbltitulo);
        
        panelPrincipal.add(panelContenido);

            panelContenido.add(lblnumero);
            panelContenido.add(txtnumero);
            panelContenido.add(lblfecha);
            panelContenido.add(txtfecha);
            panelContenido.add(lblsubtotal);
            panelContenido.add(txtsubtotal);
            panelContenido.add(lbliva);
            panelContenido.add(txtiva);
            panelContenido.add(lbltotal);
            panelContenido.add(txttotal);
            panelContenido.add(lblruta);
            panelContenido.add(txtruta);

            panelPrincipal.add(panelBoton);

            panelBoton.add(btnEnviar);
            btnEnviar.setHorizontalAlignment(JButton.CENTER);

    }

    public JPanel getPanel(){
        return this.panelPrincipal;
    }

}
