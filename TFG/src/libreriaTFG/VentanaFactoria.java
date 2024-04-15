/*
*
*/
package libreriaTFG;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import libreriaTFG.Ventana.TipoVentana;

/**
 *
 * @author VICTOR PERALTA JIMENEZ
 */
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
    
    
   public final Ventana nuevaVentana(TipoVentana tipo, JFrame padre, String nombreVentana, String captionVentana) {
        
        Ventana ventana_creada; 
        
        switch (tipo.toString().toUpperCase()) {
           case "SIMPLE":
                ventana_creada = new VentanaSimple(); 
                ventana_creada.setNombreVentana(nombreVentana);
                Ventana_por_defecto(ventana_creada, tipo);
               break;
           case "PESTANAS":
                ventana_creada = new VentanaPestanas(); 
                ventana_creada.setNombreVentana(nombreVentana);
                //Ventana_por_defecto(ventana_creada, tipo);
               break;
           case "ARBOL":
                ventana_creada = new VentanaArbol(); 
                ventana_creada.setNombreVentana(nombreVentana);
                //Ventana_por_defecto(ventana_creada, tipo);               
               break;
            default:
                ventana_creada = null;    
        }

        return ventana_creada;
    }
    
   
 
   
   
   
   
   private static void Ventana_por_defecto(Ventana ventana_nueva, TipoVentana tipo) {
    
       ventana_nueva.setLayout(new GridBagLayout());
       
       
       // tamaño a añadir segun el tipo
       int ancho=0;
       int alto=0;

       


       //Las caracterísitcas de la ventana SIMPLE es comun o los tres tipos. Y a las de PESTANAS y ARBOL hay que añadirles sus 
       // 'Características' que ambas comparten. Por ello la dsitribución del switch
    
       
             
       switch(tipo.toString().toUpperCase()) {

           // PESTANAS y ARBOL. 
           case "PESTANAS":
               //Si es pestana 50 más de ancho y 100 de alto 
               ancho=ancho+50;
               alto=alto+100;
           case "ARBOL": 
               //Si es arbol 100 más y 200 de alto
               ancho=ancho+50;
               alto=alto+100;
               
           // SIMPLE, el espacio y los botones. Esto es común a los 3 tipos de ventana
           case "SIMPLE":
                // Creo los botonesbotón ACEPTAR
               crear_Botones(ventana_nueva);
           
               gbc = new GridBagConstraints();
               //posición x del componente, es decir, el número de columna en la que está el componente, siendo la columna 0 la primera columna de la izquierda
               gbc.gridx = 0;
               //posición y del componente, es decir, el número de fila en la que está el componente, siendo la fila 0 la primera fila de la parte de arriba
               //el número de fila es 1 (la segunda) x si la 0 está ocupada
               gbc.gridy = 1;               
               //Para estirar filas y columnas, dentro del GridBagConstraints tenemos los campos weigthx y weigthy. 
               //weigthx para estirar las columnas y weigthy para estirar las filas.               
               //En este caso, solo se estiran la fila. No queremos que se estire la columna 
               gbc.weightx = 1.0;
               gbc.weighty = 0;
               //la propiedad Insets de su valor por defecto (0, 0, 0, 0), estableciendo un margen de 10 unidades a la izquierda, 5 a la derecha, 5 arriba y 5 abajo
               gbc.insets = new Insets(10, 5, 5, 5);                  
               //lo añado
               ventana_nueva.add(boton_ACEPTAR, gbc);
               
               
                // botón RECHAZAR               
               gbc = new GridBagConstraints();
               gbc.gridx = 1;
               gbc.gridy = 1;
               gbc.weightx = 1;
               gbc.weighty = 0;
               //la propiedad Insets de su valor por defecto (0, 0, 0, 0), estableciendo un margen de 5 unidades a la izquierda, 10 a la derecha, 5 arriba y 5 abajo
               gbc.insets = new Insets(5, 10, 5, 5);
              
               ventana_nueva.add(boton_RECHAZAR, gbc);
         }
               
        //Establezco el tamaño por defecto en funcion del tipo
        ventana_nueva.setPreferredSize(new Dimension(300+ancho, 150+alto));
       }
 
   private static void crear_Botones(Ventana ventana_nueva) {
       // Establezco el tamaño mínimo por defecto
       final Dimension tamano_x_defecto_botones = new Dimension(50, 20);

       // botón ACEPTAR 
       boton_ACEPTAR = new JButton("ACEPTAR");       
       boton_ACEPTAR.setMinimumSize(tamano_x_defecto_botones); 
       boton_ACEPTAR.setPreferredSize(tamano_x_defecto_botones);
       
     
         // botón RECHAZAR 
       boton_RECHAZAR = new JButton("RECHAZAR");       
       boton_RECHAZAR.setMinimumSize(tamano_x_defecto_botones); 
       boton_RECHAZAR.setPreferredSize(tamano_x_defecto_botones);
     
        // añado las "funciones asignadas a cada botón
       /**
        * POR HACER
        */   

   }

    
}
