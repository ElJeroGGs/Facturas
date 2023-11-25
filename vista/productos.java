package vista;
import javax.swing.JFrame;

import control.controlventanas;

public class productos extends JFrame {
    private controlventanas control;

    public productos() {
        setTitle("Productos");
        setSize(500, 300);

        // Agregar componentes u otras configuraciones

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

    }

    public void setControlVentanas(controlventanas control) {
        this.control = control;
    }

    
}
