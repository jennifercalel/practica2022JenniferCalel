
package proyecto.sistema.administrativo;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Ventana extends JFrame{ //Indica que hereda de los objetos JFrame
    Usuario ususistem[] = new Usuario[10]; //Creación de arreglo para los 10 usuarios
    JPanel panelInicioSesion;
    JPanel panelControl;
    JPanel panelCrearUsuario;
    int control = 2;
    
    Cliente clientes[] = new Cliente[100];
    JPanel panelControlClientes;
    int controlClientes = 2;
    
    Producto productos[]=new Producto[100];
    JPanel panelControlProductos;
    int controlProductos = 2;
     //Método constructor
     public Ventana(){
        Objetos();
        crearAdmin();
        crearClientes();
        crearProductos();
    }
     
     public void crearAdmin(){ 
        ususistem[0] = new Usuario();
        ususistem[0].nombreUsuario = "admin";
        ususistem[0].nombre = "administrador";
        ususistem[0].contra = "123";
     //usuario de prueba
        ususistem[1] = new Usuario();
        ususistem[1].nombreUsuario = "jcalel";
        ususistem[1].nombre = "Jennifer";
        ususistem[1].contra = "246";
     }
      
    public void crearClientes(){
       clientes[0]= new Cliente();
       clientes[0].nombre = "Cliente 1";
       clientes[0].edad = 22;
       clientes[0].genero = 'M';
       clientes[0].nit = 150;
       
       clientes[1]= new Cliente();
       clientes[1].nombre = "Cliente 2";
       clientes[1].edad = 30;
       clientes[1].genero = 'F';
       clientes[1].nit = 300;  
    }
    
    public void crearProductos(){
       productos[0]= new Producto();
       productos[0].nombre = "producto 1";
       productos[0].cantidad = 22;
       productos[0].precio = 100; 
       
       productos[1]= new Producto();
       productos[1].nombre = "producto 2";
       productos[1].cantidad = 22;
       productos[1].precio = 300;
    }   
    
    public void Objetos(){
        panelInicioSesion = new JPanel();
        this.getContentPane().add(panelInicioSesion);
        panelInicioSesion.setLayout(null);
        panelInicioSesion.setBackground(new Color (226, 210, 172));
        
        JLabel lblLogin = new JLabel("Iniciar Sesión");
        lblLogin.setBounds(120, 20, 250, 50);
        panelInicioSesion.add(lblLogin);
        lblLogin.setFont (new Font ("Segoe UI Black", Font.PLAIN, 30));
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(60, 90, 100, 30);
        panelInicioSesion.add(lblUsuario);
        lblUsuario.setFont (new Font ("Segoe UI Light", Font.PLAIN, 16));
        
        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(60, 145, 100, 30);
        panelInicioSesion.add(lblContra);
        lblContra.setFont (new Font ("Segoe UI Light", Font.PLAIN, 16));
        
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(160, 90, 200, 30);
        panelInicioSesion.add(txtUsuario);
        
        JTextField txtContra = new JTextField();
        txtContra.setBounds(160, 145, 200, 30);
        panelInicioSesion.add(txtContra);
        
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds (60, 210, 145, 40);
        btnIngresar.setBackground(new Color (108, 200, 216 ));
        btnIngresar.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        panelInicioSesion.add(btnIngresar);
        ActionListener Ingresar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtUsuario.getText().equals("") || txtContra.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                }else{
                    recorrerUsuario (txtUsuario.getText(), txtContra.getText());
                    }
                } 
        };
        btnIngresar. addActionListener(Ingresar); 
        
        JButton btnCrearUsuario = new JButton ("Registrarse");
        btnCrearUsuario.setBounds(210, 210, 145, 40);
        btnCrearUsuario.setBackground(new Color (241, 148, 138));
        btnCrearUsuario.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        panelInicioSesion.add(btnCrearUsuario);
        ActionListener crearUsuario = new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //panelCrearUsuario.setVisible(true);
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
        panelControl = new JPanel();
        this.getContentPane().add(panelControl);
        panelControl.setLayout(null);
        panelControl.setBackground(new Color (241, 229, 201));
        this.setSize(450, 350);
        this.setTitle("Control Principal");
        panelInicioSesion.setVisible(false);
        
        JLabel lblLogin = new JLabel("Menú Principal");
        lblLogin.setBounds(120, 15, 300, 75);
        panelControl.add(lblLogin);
        lblLogin.setFont (new Font ("Richela Kids", Font.PLAIN, 30));
        
        JButton btnAdminClientes = new JButton("Administración de Clientes");
        btnAdminClientes.setBounds(60,100,300,50);
        btnAdminClientes.setBackground(new Color (108, 200, 216));
        btnAdminClientes.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 16));
        panelControl.add(btnAdminClientes);
        ActionListener administrarClientes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               panelControlCli();
               panelControlClientes.setVisible(true);  
            }   
        };
        btnAdminClientes.addActionListener(administrarClientes); 
        
        JButton btnAdminProductos = new JButton("Administración de Productos");
        btnAdminProductos.setBounds(60,180,300,50);
        btnAdminProductos.setBackground(new Color (241, 148, 138));
        btnAdminProductos.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 16));
        panelControl.add(btnAdminProductos);   
        ActionListener administrarProductos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               panelControlProd();
               panelControlProductos.setVisible(true);  

            }   
        };
        btnAdminProductos.addActionListener(administrarProductos);
    }
    
    public void crearUsuario(){
        panelCrearUsuario = new JPanel();
        this.getContentPane().add(panelCrearUsuario);
        
        this.setTitle("Registro de Usuario");
        this.setSize(475, 415);
        panelCrearUsuario.setLayout(null);
        panelCrearUsuario.setBackground(new Color (226, 210, 172));
        panelInicioSesion.setVisible(false);
        
        JLabel lblRegistro = new JLabel("Registro de Usuario");
        lblRegistro.setBounds(90, 15, 300, 45);
        lblRegistro.setFont (new Font ("Segoe UI Black", Font.PLAIN, 30));
        panelCrearUsuario.add(lblRegistro);
    
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(40, 80, 300, 15);
        lblUsuario.setFont (new Font ("Segoe UI Light", Font.PLAIN, 16));
        panelCrearUsuario.add(lblUsuario);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(40, 130, 300, 15);
        lblNombre.setFont (new Font ("Segoe UI Light", Font.PLAIN, 16));
        panelCrearUsuario.add(lblNombre);
        
        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(40, 180, 300, 15);
        lblContra.setFont (new Font ("Segoe UI Light", Font.PLAIN, 16));
        panelCrearUsuario.add(lblContra);
        
        JLabel lblConfContra = new JLabel("Confirmar Contraseña");
        lblConfContra.setBounds(40, 230, 300, 15);
        lblConfContra.setFont (new Font ("Segoe UI Light", Font.PLAIN, 16));
        panelCrearUsuario.add(lblConfContra);
        
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(210, 80, 200, 30);
        panelCrearUsuario.add(txtUsuario);
        
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(210, 130, 200, 30);
        panelCrearUsuario.add(txtNombre);
        
        JTextField txtContra = new JTextField();
        txtContra.setBounds(210, 180, 200, 30);
        panelCrearUsuario.add(txtContra);
        
        JTextField txtConfContra = new JTextField();
        txtConfContra.setBounds(210, 230, 200, 30);
        panelCrearUsuario.add(txtConfContra);
        
        JButton btnRegistrar = new JButton ("Registrar");
        btnRegistrar.setBounds(85,290, 145,40);
        btnRegistrar.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        btnRegistrar.setBackground(new Color (241, 148, 138));
        panelCrearUsuario.add(btnRegistrar);
        ActionListener registro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
        btnVolver.setBounds(240,290, 145,40);
        btnVolver.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        btnVolver.setBackground(new Color (108, 200, 216 ));
        panelCrearUsuario.add(btnVolver);
        ActionListener volverInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
        panelControlClientes = new JPanel();
        this.getContentPane().add(panelControlClientes);
        panelControlClientes.setLayout(null);
        this.setSize(720, 650);
        this.setTitle("Administración de Clientes ");
        panelControlClientes.setBackground(new Color (238, 233, 213));
        panelControl.setVisible(false); 
        
        JLabel lblClientes = new JLabel("Administración de Clientes");
        lblClientes.setBounds(175, 5, 500, 75);
        panelControlClientes.add(lblClientes);
        lblClientes.setFont (new Font ("Richela Kids", Font.PLAIN, 30));
        
        //Creación de la tabla
        DefaultTableModel datosTabla = new DefaultTableModel();
        datosTabla.addColumn("Nombre");
        datosTabla.addColumn("Edad");
        datosTabla.addColumn("Género");
        datosTabla.addColumn("NIT");
        
        for(int i = 0; i<100; i++){
            if(clientes[i] != null){
                String fila [] = {clientes[i].nombre, String.valueOf(clientes[i].edad), String.valueOf(clientes[i].genero), String.valueOf(clientes[i].nit)};
                datosTabla.addRow(fila);
            }
        }
        
        JTable tablaClientes = new JTable(datosTabla);
        JScrollPane barraTablaClientes = new JScrollPane(tablaClientes);
        barraTablaClientes.setBounds(15,80,325,170);
        panelControlClientes.add(barraTablaClientes);
        
        //Creación gráfico circular
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Masculino", totalHombres());
        datos.setValue("Femenino", totalMujeres());
        
        JFreeChart graficoCircular = ChartFactory.createPieChart("Géneros en el sistema", datos);
        ChartPanel panelCircular = new ChartPanel(graficoCircular);
        panelCircular.setBounds(15, 275, 325, 300);
        panelControlClientes.add(panelCircular);
        
        //Creación gráfico de columnas
        DefaultCategoryDataset datos2 = new DefaultCategoryDataset();
        datos2.addValue(rango18a30(), "18-30", "Edad");
        datos2.addValue(rango31a45(), "31-45", "Edad");
        datos2.addValue(rango45mas(), "Mayor a 45", "Edad");
        
        JFreeChart graficoColumnas = ChartFactory.createBarChart("Rango de Edades", "Edad", "Escala", datos2, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panelColumnas = new ChartPanel(graficoColumnas);
        panelColumnas.setBounds(360, 275, 325, 300);
        panelControlClientes.add(panelColumnas);
        
        JButton btnCargarArchivo = new JButton("Buscar archivo CSV");
        btnCargarArchivo.setBounds(365, 80, 300, 40);
        btnCargarArchivo.setBackground(new Color (108, 200, 216));
        panelControlClientes.add(btnCargarArchivo);
         ActionListener buscarArchivo = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                File archivoSeleccionado;
                JFileChooser ventanaSeleccion = new JFileChooser();
                ventanaSeleccion.showOpenDialog(null);
                archivoSeleccionado = ventanaSeleccion.getSelectedFile(); 
                if(archivoSeleccionado ==null){
                    System.out.println("No hat ruta");
                }else{
                System.out.println("La ubicación del archivo es " + archivoSeleccionado.getPath());
                leerArchivoCSV(archivoSeleccionado.getPath());
                panelControlClientes.setVisible(false);
                panelControlCli();
                }
            } 
        };
         btnCargarArchivo.addActionListener(buscarArchivo);
         
        JButton btnReporte = new JButton("Crear reporte HTML");
        btnReporte.setBounds(365,140, 300, 40);
        btnReporte.setBackground(new Color (183, 231, 148));
        panelControlClientes.add(btnReporte);
        ActionListener crearHTML = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               crearReporte();
            }
            
        };
        btnReporte.addActionListener(crearHTML);
        
        JButton btnVolver = new JButton ("Volver al Menú");
        btnVolver.setBounds(365,200, 300,40);
        btnVolver.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        btnVolver.setBackground(new Color (241, 148, 138));
        panelControlClientes.add(btnVolver);
        ActionListener volverInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelControl.setVisible(true);
                panelControlClientes.setVisible(false);
                volverInicio();
            }   
        };
        btnVolver.addActionListener(volverInicio);
    }
    
    public void ordenar(){
        Cliente auxiliar;
        for(int i=0; i<99; i++){
            for(int j=0; j<99; j++){ 
                if(clientes[j+1]==null){
                    break;
                }else{
                    if(clientes[j].edad>clientes[j+1].edad){
                        auxiliar = clientes[j+1];
                        clientes[j+1] = clientes[j];
                        clientes[j]= auxiliar;
                    }
                }
            }
        }
   }
    
    public void crearReporte(){
        try{
            ordenar();
            PrintWriter escribirCSS = new PrintWriter("reporteClientes/estilo.css","UTF-8");
            escribirCSS.println("");
            escribirCSS.print("html {   font-size: 20px; font-family: 'Open Sans', sans-serif; }");
            escribirCSS.print("h1 { font-size: 60px; text-align: center; }");
            escribirCSS.print("p, li {   font-size: 16px;   line-height: 2;   letter-spacing: 1px; }");
            escribirCSS.print("table { table-layout: fixed;   width:250px;}   td{border: 1px solid black; width: 190px;  word-wrap: break-word}");
            escribirCSS.print("html { background-color: #00539F; }");
            escribirCSS.print("body { width: 970px; margin: 0 auto; background-color: #FF9500; padding: 0 20px 20px 20px; border: 5px solid black; }");
            escribirCSS.print("h1 { margin: 0; padding: 20px 0; color: #00539F; text-shadow: 3px 3px 1px black; }");
            escribirCSS.close();
            
            PrintWriter escribir = new PrintWriter("reporteCliente/index.html","UTF-8");
            escribir.println("<!doctype html>");
            escribir.println("<html>");
            escribir.println("<head>");
            escribir.println("<title>Reporte del sistema</title>");
            escribir.println("<link rel=\" stylesheet\" href=\"estilo.css\">");
            escribir.println("</head>");
            escribir.println("<body>");
            escribir.println("<h1>Listado de clientes en el sistema</h1>");
            escribir.println("<br>");
            
            escribir.println("<table>");
            escribir.println("<tr>");
            escribir.println("<td>NIT</td> <td>Nombre</td> <td>Edad<td>Género<td>");
            escribir.println("</tr>");
            for(int i=0; i<99; i++){
                if(clientes[i] != null){
                    escribir.println("<tr>");
                    escribir.println("<td>" + clientes[i].nit + "</td><td>" + clientes[i].nombre + "</td><td>" + clientes[i].edad + "</td><td>" + clientes[i].genero + "</td>");
                    escribir.println("</tr>");
                }
            }
            
            escribir.println("</table>");
            escribir.println("</body>");
            escribir.println("</html>");
            escribir.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado con éxito, este se encuentra en la carpeta REPORTES");
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "No se pudo crear el reporte");
        }
        
    }
    
    public int totalHombres(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].genero == 'M'){
                    total++;
                }
            }
        }
    return total;
    }
    
    public int totalMujeres(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].genero == 'F'){
                    total++;
                }
            }
        }
    return total;
    }
    
    public int rango18a30(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].edad >=18 && clientes[i].edad <=30){
                    total++;
                }
            }
        }
    return total;
    }
    
        public int rango31a45(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].edad >30 && clientes[i].edad <=45){
                    total++;
                }
            }
        }
    return total;
    }
        
        public int rango45mas(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(clientes[i] != null){
                if(clientes[i].edad >45){
                    total++;
                }
            }
        }
    return total;
    }
    
    public void leerArchivoCSV(String ruta){
        try{

            BufferedReader archivoTemporal = new BufferedReader(new FileReader(ruta));
            String lineaLeida = "";
            while(lineaLeida !=null){
                lineaLeida= archivoTemporal.readLine();
                if(lineaLeida != null){
                    String datosSeparados[] = lineaLeida.split(",");
                    
                    int posicion = 0;
                    if(controlClientes < 100){
                        for(int i = 0; i<99; i++) {
                        if (clientes [i] == null) {
                            posicion = i;
                            break;
                            }
                        }
                    clientes [posicion] = new Cliente();
                    clientes [posicion].nombre = datosSeparados[0];
                    clientes [posicion].edad = Integer.parseInt(datosSeparados[1]);
                    clientes [posicion].genero = datosSeparados[2].charAt(0);
                    clientes [posicion].nit = Integer.parseInt(datosSeparados[3]);
                    controlClientes++;
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede registrar más clientes");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente, total de usuarios" + controlClientes);
            archivoTemporal.close();
        }catch(IOException error ){
            JOptionPane.showMessageDialog(null,"No es posible abrir el archivo CSV");
        } 
    }
    
        public void panelControlProd(){
        panelControlProductos = new JPanel();
        this.getContentPane().add(panelControlProductos);
        this.setSize(720, 480);
        this.setTitle("Administración de Productos ");
        panelControlProductos.setLayout(null);
        panelControlProductos.setBackground(new Color (238, 233, 213));
        panelControl.setVisible(false); 
        
        JLabel lblProductos = new JLabel("Administración de Productos");
        lblProductos.setBounds(175, 5, 500, 75);
        panelControlProductos.add(lblProductos);
        lblProductos.setFont (new Font ("Richela Kids", Font.PLAIN, 30));
        
        //Creación de la tabla
        DefaultTableModel datoTabla = new DefaultTableModel();
        datoTabla.addColumn("Nombre");
        datoTabla.addColumn("Cantidad");
        datoTabla.addColumn("Precio");
        
        for(int i = 0; i<100; i++){
            if(productos[i] != null){
                String fila [] = {productos[i].nombre, String.valueOf(productos[i].cantidad), String.valueOf(productos[i].precio)};
                datoTabla.addRow(fila);
            }
        }
        
        JTable tablaProductos = new JTable(datoTabla);
        JScrollPane barraTablaProductos = new JScrollPane(tablaProductos);
        barraTablaProductos.setBounds(15,150,325,250);
        panelControlProductos.add(barraTablaProductos);
        
        //Creación gráfico de columnas
        DefaultCategoryDataset datos3 = new DefaultCategoryDataset();
        datos3.addValue(rangomenor150(), "0-150", "Precio");
        datos3.addValue(rango151a300(), "151-300", "Precio");
        datos3.addValue(rangomayor300(), "Mayor a 300", "Precio");
        JFreeChart graficoColumnas = ChartFactory.createBarChart("Rango de Precios", "Precio", "Cantidad", datos3, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panelColumnas = new ChartPanel(graficoColumnas);
        panelColumnas.setBounds(350, 150, 325,250);
        panelControlProductos.add(panelColumnas);
        
        JButton btnCargarArchivoProducto = new JButton("Buscar archivo CSV");
        btnCargarArchivoProducto.setBounds(20, 80, 210, 40);
        btnCargarArchivoProducto.setBackground(new Color (108, 200, 216));
        panelControlProductos.add(btnCargarArchivoProducto);
         ActionListener buscarArchivo = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                File archivoSeleccionado;
                JFileChooser ventanaSeleccion = new JFileChooser();
                ventanaSeleccion.showOpenDialog(null);
                archivoSeleccionado = ventanaSeleccion.getSelectedFile(); 
                if(archivoSeleccionado ==null){
                    System.out.println("No hat ruta");
                }else{
                System.out.println("La ubicación del archivo es " + archivoSeleccionado.getPath());
                leerArchivoCSVProductos(archivoSeleccionado.getPath());
                panelControlProductos.setVisible(false);
                panelControlProd();
                }
            } 
        };
         btnCargarArchivoProducto.addActionListener(buscarArchivo);
         
        JButton btnReporte = new JButton("Crear reporte HTML");
        btnReporte.setBounds(240,80, 210, 40);
        btnReporte.setBackground(new Color (183, 231, 148));
        panelControlProductos.add(btnReporte);
        ActionListener crearHTML = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               crearReporteProd();
            }
            
        };
        btnReporte.addActionListener(crearHTML);
        
        JButton btnVolver = new JButton ("Volver al Menú");
        btnVolver.setBounds(460,80,210,40);
        btnVolver.setFont (new Font ("Segoe UI Semibold", Font.BOLD, 14));
        btnVolver.setBackground(new Color (241, 148, 138));
        panelControlProductos.add(btnVolver);
        ActionListener volverInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelControl.setVisible(true);
                panelControlProductos.setVisible(false);
                volverInicio();
            }   
        };
        btnVolver.addActionListener(volverInicio);
    }
        public void ordenar2(){
        Producto auxiliar;
        for(int i=0; i<99; i++){
            for(int j=0; j<99; j++){ 
                if(productos[j+1]==null){
                    break;
                }else{
                    if(productos[j].precio>productos[j+1].precio){
                        auxiliar = productos[j+1];
                        productos[j+1] = productos[j];
                        productos[j]= auxiliar;
                    }
                }
            }
        }
   }
            
    public void crearReporteProd(){
        try{
            ordenar2();
            PrintWriter escribir = new PrintWriter("reporteProducto/index.html","UTF-8");
            escribir.println("<!doctype html>");
            escribir.println("<html>");
            escribir.println("<head>");
            escribir.println("<title>Reporte del sistema</title>");
            escribir.println("</head>");
            escribir.println("<body>");
            escribir.println("<h1>Listado de productos en el sistema</h1>");
            escribir.println("<br>");
            
            escribir.println("<table>");
            escribir.println("<tr>");
            escribir.println("<td>Nombre</td> <td>Cantidad</td> <td>Precio</td>");
            escribir.println("</tr>");
            for(int i=0; i<99; i++){
                if(productos[i] != null){
                    escribir.println("<tr>");
                    escribir.println("<td>" + productos[i].nombre + "</td><td>" + productos[i].cantidad + "</td><td>" + productos[i].precio + "</td><td>");
                    escribir.println("</tr>");
                }
            }
            
            escribir.println("</table>");
            escribir.println("</body>");
            escribir.println("</html>");
            escribir.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado con éxito, este se encuentra en la carpeta REPORTES PRODUCTOS");
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "No se pudo crear el reporte");
        }
        
    }
    
    public int rangomenor150(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].precio <=150){
                    total++;
                }
            }
        }
    return total;
    }
    
        public int rango151a300(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].precio >151 && productos[i].precio <=300){
                    total++;
                }
            }
        }
    return total;
    }
        
        public int rangomayor300(){
        int total = 0;
        for(int i=0; i<100; i++){
            if(productos[i] != null){
                if(productos[i].precio >300){
                    total++;
                }
            }
        }
    return total;
    }
    
    public void leerArchivoCSVProductos(String ruta){
        try{

            BufferedReader archivoTemporal = new BufferedReader(new FileReader(ruta));
            String lineaLeida = "";
            while(lineaLeida !=null){
                lineaLeida= archivoTemporal.readLine();
                if(lineaLeida != null){
                    String datosSeparados[] = lineaLeida.split(",");
                    
                    int posicion = 0;
                    if(controlProductos < 100){
                        for(int i = 0; i<99; i++) {
                        if (productos [i] == null) {
                            posicion = i;
                            break;
                            }
                        }
                    productos [posicion] = new Producto();
                    productos [posicion].nombre = datosSeparados[0];
                    productos [posicion].cantidad = Integer.parseInt(datosSeparados[1]);
                    productos [posicion].precio = Float.parseFloat(datosSeparados[2]);
                    controlProductos++;
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede registrar más productos");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente, total de usuarios" + controlProductos);
            archivoTemporal.close();
        }catch(IOException error ){
            JOptionPane.showMessageDialog(null,"No es posible abrir el archivo CSV");
        } 
    }       
}

