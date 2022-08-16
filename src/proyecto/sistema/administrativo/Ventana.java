
package proyecto.sistema.administrativo;


import javax.swing.JFrame; //Importar paquete para ventanas
import javax.swing.JLabel; //Importar paquete de etiquetas
import javax.swing.JPanel; //Importar paquete de paneles
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame{ //Indica que hereda de los objetos JFrame
    Usuario ususistem[] = new Usuario[10]; //Creación de arreglo para los 10 usuarios
    JPanel panelInicioSesion = new JPanel(); //Crear panel Inicio Sesión
    JPanel panelControl = new JPanel();
    JPanel panelCrearUsuario = new JPanel();
    int control = 1;
    Cliente clientes[] = new Cliente[100];
    int controlCliente = 0;
    JPanel panelControlClientes = new JPanel();
    
     //Método constructor
     public Ventana(){
        Objetos();
        crearAdmin();
        crearClientes();
    }
     
     public void crearAdmin(){ //En la posición 0 posicionar al administrador
        ususistem[0] = new Usuario();
        ususistem[0].nombreUsuario = "admin";
        ususistem[0].nombre = "administrador";
        ususistem[0].contra = "123456";
     }
     
    public void crearClientes(){
       clientes[0]= new Cliente();
       clientes[0].nombre = "cliente 1";
       clientes[0].edad = 22;
       clientes[0].genero = 'M';
       clientes[0].nit = 150;
       
       clientes[1]= new Cliente();
       clientes[1].nombre = "cliente 2";
       clientes[1].edad = 30;
       clientes[1].genero = 'F';
       clientes[1].nit = 300;  
    }
       
    public void Objetos(){
        
        this.getContentPane().add(panelInicioSesion);
        panelInicioSesion.setLayout(null);
        panelInicioSesion.setBackground(new Color (190, 229, 227)); //Agregar color al panel
        
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(175, 15, 100, 45);
        panelInicioSesion.add(lblLogin);
        lblLogin.setFont (new Font ("Richela Kids", Font.PLAIN, 30));
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(60, 75, 100, 15);
        panelInicioSesion.add(lblUsuario);
        lblUsuario.setFont (new Font ("Verdana", Font.BOLD, 14));
        
        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(60, 130, 100, 15);
        panelInicioSesion.add(lblContra);
        lblContra.setFont (new Font ("Verdana", Font.BOLD, 14));
        
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(160, 75, 200, 25);
        panelInicioSesion.add(txtUsuario);
        
        JTextField txtContra = new JTextField();
        txtContra.setBounds(160, 130, 200, 25);
        panelInicioSesion.add(txtContra);
        
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds (130, 190, 180, 35);
        btnIngresar.setBackground(new Color (108, 200, 216 ));
        btnIngresar.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        panelInicioSesion.add(btnIngresar);
        ActionListener Ingresar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtUsuario.getText().equals("") || txtContra.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }else{
                    recorrerUsuario (txtUsuario.getText(), txtContra.getText());
                    }
                } 
        };
        btnIngresar. addActionListener(Ingresar); 
        
        JButton btnCrearUsuario = new JButton ("Registrarse");
        btnCrearUsuario.setBounds(130, 240, 180, 35);
        btnCrearUsuario.setBackground(new Color (241, 148, 138));
        btnCrearUsuario.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        panelInicioSesion.add(btnCrearUsuario);
        ActionListener crearUsuario = new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCrearUsuario.setVisible(true);
                crearUsuario();
            }
        }; 
        btnCrearUsuario.addActionListener(crearUsuario);
    }
    
    public void recorrerUsuario (String nombreUsuario, String contra){ 
        boolean encontrado = false;
        for(int i = 0; i<10; i++){
            if(ususistem[i] != null){
                if(ususistem [i].nombreUsuario.equals(nombreUsuario) && ususistem[i].contra.equals(contra)){
                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema usuario " + nombreUsuario);
                    panelControl();
                    encontrado=true;
                    break;   
                }else{
                    encontrado=false;
                }
            }
        }
        if(encontrado == false){
        JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }
    
    public void panelControl(){
        this.getContentPane().add(panelControl);
        panelControl.setLayout(null);
        this.setSize(600, 500);
        this.setTitle("Control Principal");
        panelInicioSesion.setVisible(false);
        
        JButton btnAdminClientes = new JButton("Administración de Clientes");
        btnAdminClientes.setBounds(160,100,250,50);
        panelControl.add(btnAdminClientes);
        ActionListener administrarClientes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelControlCli();
               panelControlClientes.setVisible(true);  
            }   
        };
        btnAdminClientes.addActionListener(administrarClientes); 
        
        JButton btnAdminProductos = new JButton("Administración de Productos");
        btnAdminProductos.setBounds(160,200,250,50);
        panelControl.add(btnAdminProductos);
        
        JButton btnReportes = new JButton("Reportes");
        btnReportes.setBounds(160,300, 250,50);
        panelControl.add(btnReportes);
    }
    public void crearUsuario(){
        this.getContentPane().add(panelCrearUsuario);
        panelCrearUsuario.setLayout(null);
        this.setSize(500, 450);
        this.setTitle("Registro de Usuario");
        panelInicioSesion.setVisible(false);
        
        JLabel lblRegistro = new JLabel("Registro de Usuario");
        lblRegistro.setBounds(110, 15, 300, 45);
        lblRegistro.setFont (new Font ("Richela Kids", Font.PLAIN, 30));
        panelCrearUsuario.add(lblRegistro);
    
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(40, 100, 300, 15);
        lblUsuario.setFont (new Font ("Verdana", Font.BOLD, 14));
        panelCrearUsuario.add(lblUsuario);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(40, 150, 300, 15);
        lblNombre.setFont (new Font ("Verdana", Font.BOLD, 14));
        panelCrearUsuario.add(lblNombre);
        
        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(40, 200, 300, 15);
        lblContra.setFont (new Font ("Verdana", Font.BOLD, 14));
        panelCrearUsuario.add(lblContra);
        
        JLabel lblConfContra = new JLabel("Confirmar Contraseña");
        lblConfContra.setBounds(40, 250, 300, 15);
        lblConfContra.setFont (new Font ("Verdana", Font.BOLD, 14));
        panelCrearUsuario.add(lblConfContra);
        
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(240, 100, 200, 25);
        panelCrearUsuario.add(txtUsuario);
        
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(240, 150, 200, 25);
        panelCrearUsuario.add(txtNombre);
        
        JTextField txtContra = new JTextField();
        txtContra.setBounds(240, 200, 200, 25);
        panelCrearUsuario.add(txtContra);
        
        JTextField txtConfContra = new JTextField();
        txtConfContra.setBounds(240, 250, 200, 25);
        panelCrearUsuario.add(txtConfContra);
        
        JButton btnRegistrar = new JButton ("Registrar");
        btnRegistrar.setBounds(85,320, 150,50);
        panelCrearUsuario.add(btnRegistrar);
        ActionListener registro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtUsuario.getText().equals("") || txtNombre.getText().equals("") || txtContra.getText().equals("") || txtConfContra.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }else{
                     if (txtContra.getText().equals(txtConfContra.getText())){
                    guardarUsuario(txtUsuario.getText(), txtNombre.getText(), txtContra.getText());
                    txtUsuario.setText("");
                    txtNombre.setText("");
                    txtContra.setText("");
                    txtConfContra.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Las contraseñas NO coinciden");
                    }
                }
            } 
        };
        btnRegistrar.addActionListener(registro);
        
        JButton btnVolver = new JButton ("Volver al Inicio");
        btnVolver.setBounds(260,320, 150,50);
        panelCrearUsuario.add(btnVolver);
        ActionListener volverInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInicioSesion.setVisible(true);
                panelCrearUsuario.setVisible(false);
                volverInicio();
            }   
        };
        btnVolver.addActionListener(volverInicio);
    }
    
        public void volverInicio(){
        this.setSize(450, 350);
        this.setTitle("Sistema administrativo de clientes y recursos");
    }
        
        public void guardarUsuario( String nombre, String nombreUsuario, String contra){
            int posicion = 0;
            if(control < 10){
                for(int i=0; i< 9; i++){
                    if(ususistem[i] == null){
                    posicion = i;
                    break;
                }
            }
            //System.out.println("La posición libre es " + posicion);
            ususistem[posicion] = new Usuario();
            ususistem[posicion].nombreUsuario = nombre;
            ususistem[posicion].nombre = nombreUsuario;
            ususistem[posicion].contra = contra;
            control++;
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente, total usuarios " + control);
            
        } else {
                JOptionPane.showMessageDialog(null, "No se puede registrar más usuarios");  
        }
    }
    public void panelControlCli(){
        this.getContentPane().add(panelControlClientes);
        panelControlClientes.setLayout(null);
        this.setSize(750, 600);
        this.setTitle("Administración de Clientes ");
        panelControl.setVisible(false); 
        
        DefaultTableModel datosTabla = new DefaultTableModel();
        datosTabla.addColumn("Nombre");
        datosTabla.addColumn("Edad");
        datosTabla.addColumn("Genero");
        datosTabla.addColumn("NIT");
        String fila [] = {"Juan", "15", "M", "500"};
        datosTabla.addRow(fila);
        String fila2 [] = {"Juan", "15", "M", "500"};
        datosTabla.addRow(fila2);
        
        JTable tablaClientes = new JTable(datosTabla);
        JScrollPane barraTablaClientes = new JScrollPane(tablaClientes);
        barraTablaClientes.setBounds(10,10,300,100);
        panelControlClientes.add(barraTablaClientes);
    }
}
