package control;

public class controlclientes {

    public void verClientes() {
        
    }

    public void addCliente() {
    }

    public void eliminarCliente() {
    }

    public void modificarCliente() {
    }

   public void hacer(String command) {
        switch (command) {
            case "ver":
                verClientes();
                break;
            case "agregar":
                addCliente();
                break;
            case "eliminar":
                eliminarCliente();
                break;
            case "modificar":
                modificarCliente();
                break;
            default:
                System.out.println("Comando inválido");
                break;
        }
    }
    
}
