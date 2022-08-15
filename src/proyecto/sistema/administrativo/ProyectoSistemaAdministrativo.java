
package proyecto.sistema.administrativo;

import javax.swing.JFrame;

public class ProyectoSistemaAdministrativo {

    public static void main(String[] args) {
        
        Ventana marco = new Ventana(); //Configuraciones básicas de la ventana
        marco.setVisible(true); //Visible
        marco.setTitle("Sistema Administrativo de Clientes y Recursos"); //Nombre
        marco.setSize(450, 350); //Medidas ancho-alto
        marco.setLocationRelativeTo(null); //Centrado
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar al dar clic
        
    }
    
}
