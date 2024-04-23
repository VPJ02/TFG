/**
 *
 * @author VICTOR PERALTA JIMENEZ
 */

package libreriaTFG;
import java.awt.CardLayout;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import libreriaTFG.Ventana.TipoVentana;

public class VentanaFactoria {
    
 
   /**
    * Los botones de la ventana principal.
    */
   private static JButton boton_ACEPTAR; 
   private static JButton boton_RECHAZAR;

  /**
   * Constraints de la ventana principal
   */  
   private static GridBagConstraints gbc; 

 
    
   public static Ventana nuevaVentana(TipoVentana tipo, JFrame padre, String nombreVentana, String captionVentana) {
        
        Ventana ventana_creada; 
        
        switch (tipo.toString().toUpperCase()) {
           case "ARBOL":
                ventana_creada = new VentanaArbol(); 
               break;
  
           case "PESTANAS":
                ventana_creada = new VentanaPestanas(); 
               break;
 
           case "SIMPLE":
                ventana_creada = new VentanaSimple();              
               break;
                
            default:
                ventana_creada = null;    
        }

        Ventana_por_defecto(ventana_creada, tipo);
        ventana_creada.setNombreVentana(nombreVentana);
        ventana_creada.setVentanaPadre(ventana_creada);
        ventana_creada.setUpVentana();               

        
        //Añado el Marco que recubre la opción seleccionada
        marco_Ventana(padre, ventana_creada, captionVentana);

        return ventana_creada;
    }
    
   
 
   
   
   
   
   private static void Ventana_por_defecto(Ventana ventana_nueva, TipoVentana tipo) {
    
       ventana_nueva.setLayout(new GridBagLayout());
       
       
       // tamaño a añadir segun el tipo
       int ancho=0;
       int alto=0;
      

       //Las caracterísitcas de la ventana SIMPLE es comun a los tres tipos, solo pongo los botones.
       // las de PESTANAS y ARBOL hay que añadirles sus 'Características' que ambas comparten.
       if (tipo!=TipoVentana.SIMPLE )
          {
            //Lo común a pestanas y árbol
            gbc = new GridBagConstraints();
            //posición x del componente, es decir, el número de columna en la que está el componente, siendo la columna 0 la primera columna de la izquierda
            gbc.gridx = 0;
            //posición y del componente, es decir, el número de fila en la que está el componente, siendo la fila 0 la primera fila de la parte de arriba
            gbc.gridy = 0;
            //celdas en horizontal debe ocupar el componente. El ancho del componente.
            gbc.gridwidth = 2;
            //Para estirar filas y columnas, dentro del GridBagConstraints tenemos los campos weigthx y weigthy. 
            //weigthx para estirar las columnas.
            gbc.weightx = 1.0;
            //weigthy para estirar las filas.
            gbc.weighty = 1.0;
            //Para hacer que los componentes qu están dentro de las filas y columnas tambien se estiren, utilizamos el atributo fill
            // GridBagConstraints.BOTH para que se estire en ambas dimensiones
            gbc.fill = GridBagConstraints.BOTH;
           
            if (tipo==TipoVentana.PESTANAS ){//es PESTANAS
               // Creo la zona de las pestañas de la ventana de PESTANAS
               crear_ZonaPestanas((VentanaPestanas)ventana_nueva, gbc);
               //Dimensiones para el conjunto PESTANAS + BOTONES
               ancho=50;
               alto=100;
                   
            }else{ //es ARBOL              
               // Creo la zona de las "ramas" de la ventana de ARBOL
               crear_ZonaArbol((VentanaArbol)ventana_nueva, gbc);               
               //Dimensiones para el conjunto ARBOL + BOTONES                
               ancho=100;
               alto=200;   
            }    
                   
         }
       //Si no ha entrado en if anterio será SIMPLE
       //Solo añado los botones. Esto es común a los 3 tipos de ventana

 
       // Creo los botones 
       crear_Botones(ventana_nueva);
       
       // ACEPTAR   
       gbc = new GridBagConstraints();
       //posición x del componente, es decir, el número de columna en la que está el componente, siendo la columna 0 la primera columna de la izquierda
       gbc.gridx = 0;
       //posición y del componente, es decir el número de fila en la que está el componente, siendo la fila 0 la primera fila de la parte de arriba
       //el número de fila es la 2 para 2 (la tercera) para poder poner hasta 2 ventanas simples
       gbc.gridy = 2;               
       //Para estirar filas y columnas, dentro del GridBagConstraints tenemos los campos weigthx y weigthy. 
       //weigthx para estirar las columnas y weigthy para estirar las filas.               
       //En este caso, solo se estiran la fila. No queremos que se estire la columna 
       gbc.weightx = 1.0;
       gbc.weighty = 0;
       //la propiedad Insets de su valor por defecto (0, 0, 0, 0), estableciendo un margen de 10 unidades a la izquierda, 5 a la derecha, 5 arriba y 5 abajo
       gbc.insets = new Insets(10, 5, 5, 5);                  
       //gbc.insets = new Insets(0, 0, 0, 0);
       gbc.anchor = GridBagConstraints.SOUTH;;
       //lo añado
       ventana_nueva.add(boton_ACEPTAR, gbc);
               
       // botón RECHAZAR               
       gbc = new GridBagConstraints();
       gbc.gridx = 1;
       gbc.gridy = 2;
       gbc.weightx = 1.0;
       gbc.weighty = 0;
       //estableciendo un margen de 10 unidades a la izquierda, 5 a la derecha, 5 arriba y 5 abajo
       gbc.insets = new Insets(10, 5, 5, 5);
       //gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.SOUTH;
       //lo añado       
       ventana_nueva.add(boton_RECHAZAR, gbc);
       
       
       /*switch(tipo.toString().toUpperCase()) {

           case "ARBOL": 
           case "PESTANAS":
           case "SIMPLE":
         }*/
       
       ancho=300+ancho;
       alto=250+alto;
       
       //Establezco el tamaño por defecto en funcion del tipo
       ventana_nueva.setSize(alto, ancho);
           
        
   }
 
   private static void crear_Botones(Ventana ventana_nueva) {
       // Establezco el tamaño mínimo por defecto
       final Dimension tamano_x_defecto_botones = new Dimension(100, 20);

       // botón ACEPTAR 
       boton_ACEPTAR = new JButton();
       boton_ACEPTAR.setText("ACEPTAR");       
      // boton_ACEPTAR.setMinimumSize(tamano_x_defecto_botones); 
       boton_ACEPTAR.setPreferredSize(tamano_x_defecto_botones);
       
             
     
         // botón RECHAZAR 
       boton_RECHAZAR = new JButton(); 
       boton_RECHAZAR.setText("RECHAZAR");
       //boton_RECHAZAR.setMinimumSize(tamano_x_defecto_botones); 
       boton_RECHAZAR.setPreferredSize(tamano_x_defecto_botones);
     
        // añado las "funciones asignadas a cada botón
       /**
        * POR HACER
        */   

   }

   
   private static void crear_ZonaPestanas(VentanaPestanas ventana_nueva, GridBagConstraints atributos) {
       JTabbedPane zona_pestanas = new JTabbedPane();
       ventana_nueva.setPanel_Pestanas(zona_pestanas);
       ventana_nueva.add(zona_pestanas, atributos);
              
   } 
   
    private static void crear_ZonaArbol(VentanaArbol ventana_nueva, GridBagConstraints atributos) {
       // Primero creo el arbol- Siempre que debe crearse la vistadelarbol y su scroll
       //La vista del arbol. Su "menu"
       /**Definimos cual será el directorio principal o la raiz de nuestro arbol*/
        DefaultMutableTreeNode Raiz = new DefaultMutableTreeNode("Menú");
        /**Definimos el modelo donde se agregaran los nodos*/
        DefaultTreeModel modelo = new DefaultTreeModel(Raiz);
        /**agregamos el modelo al arbol, donde previamente establecimos la raiz*/
        JTree arbolado = new JTree(modelo);
           
        
        
       // y su scroll
       // inicializaciones propias de los paneles de desplazamiento
       JScrollPane barra_arbolado = new JScrollPane(arbolado);
       barra_arbolado.setMinimumSize(new Dimension(80, 0));

       //Ahora creo el Panel donde se visualizarán las pantallas de la opcion del árbol seleccionada
       // inicializaciones propias del panel de contenido
       JPanel pantalla_trabajo = new JPanel();
       pantalla_trabajo.setMinimumSize(new Dimension(80, 0));
     
       
       //Finalmente utilizo el compenente JsplitPane que me permite dividir la zona de árbol de la pantalla de trabajo
        // inicializaciones propias del panel divisor
       JSplitPane zona_arbol = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, barra_arbolado, pantalla_trabajo);
       zona_arbol.setDividerSize(5);
       
       //Establezco las tres propiedades*/
       ventana_nueva.setArbol(arbolado);
       ventana_nueva.setPanel_trabajo(pantalla_trabajo);
       ventana_nueva.setDivisor_arbol( zona_arbol);
       
       ventana_nueva.add(zona_arbol, atributos);
      
    }
   
    private static void marco_Ventana(JFrame marco_padre, Ventana ventana_nueva, String titulo) {
       
       //
       JFrame marco;
       //Compruebo si el Frame padre es nulo 
       if (marco_padre != null) {
           marco = marco_padre;
       }else{
           marco = new JFrame(titulo);
       }
       
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null);
        marco.pack();

        
        marco.add(ventana_nueva);
        marco.setSize(ventana_nueva.getSize());
        //Establezco el marco como ventana padre
        //ventana_nueva.setVentanaPadre(marco);
        //Establezco el tamaño mínimo
        marco.setMinimumSize(new Dimension (300,300));
        marco.setVisible(true);
   }

   
}
