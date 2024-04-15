

package libreriaTFG;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.List;

/**
 * Libreria del proyecto.
 * @author VICTOR PERALTA JIMENEZ
 */

public class Ventana extends JPanel   {
   /**
    *  Posibles Atributos 
    */
    
    /**
     * nombreVentana: Nombre del objeto.
     */
    private String nombreVentana;
    

    /**
     * tamano: Tamaño del objeto. Será necesario para poder ser modificado o redimensionado     
     */
    private Dimension tamano;    
   
    /**
     * Ventana Padre
     */
    private Ventana ventanaPadre;
    
    
     /**
     * Lista de ventanas hijas.
     */
    private List <Ventana> listaVentanasHijas;
  
    
    
    
   /*
    * Constructor (de momento vacío)
    */ 
   public Ventana() {}
   
    // 
   
     /*
     * INTERFAZ PÚBLICO   
     */
    public boolean setUpVentana() {
                  
             
        
        
        return true;  
        
    }
   
   
   
   /**
    * Añade la ventana pasada como parámetro a la ventana "padre" que es invocada.
    * Ademas de añadirla a la lista de ventanas hijas, tambien establece quién es su ventana "PADRE"
    * 
    * @param ventanaHija La ventana 'hija' añadir: SIMPLE, PESTANAS o ARBOL
    * @param caption El titulo de ventana de PESTANAS o la entrada del ARBOL, en la SIMPLE no se utiliza
    */ 
    
    public void addVentanaHija(final Ventana ventanaHija, final String caption) {
        
       try{  
        
        listaVentanasHijas.add(ventanaHija);
        
        ventanaHija.setVentanaPadre(this);

        // Si da error lo capturo 
        }catch(Exception e) {
               System.out.println("ERROR Ventana: No puede crear la ventana HIJA");
          }
    }
   
   
     /*
     * INTERFAZ NO PÚBLICO   
     */
   
    
   
      /**
       * GETs y SETs       * 
       */
   
        /**
         * Se obtiene el Nombre del objeto.
         * 
         * @return nombreVentana: El nombre del objeto como String
         */
        public String getNombreVentana() {
            return nombreVentana;
        }

        /**
         * Se actualiza el nombre del objeto pasado como parámetro..
         *
         * @param nombreVentana_pasado: nombre del objeto 
         */
        public void setNombreVentana(final String nombreVentana_pasado) {
            this.nombreVentana = nombreVentana_pasado;
        }
   
        // Tamaño del Objeto
        /**
        * Se obtiene el tamaño actual.
        * 
        * @return tamano: El tamaño actual como un objeto Dimension
        */

        protected Dimension getTamano() {
              return tamano;
        }

        /**
        * Se actualiza el tamaño pasado como parámetro.
        * 
        * @param tamano_concreto: tamaño concreto que se determina
        */
        protected void setTamano(final Dimension tamano_concreto) {
              this.tamano = tamano_concreto;
        }

        
         /** 
         * Devuelve la ventana padre.
         *
         * @return VentanaPadre
         */
        protected Ventana getVentanaPadre() {
            return ventanaPadre;
        }

        /**
         * Actualiza la ventana padre pasado como parámetro.
         *
         * @param ventanaPadre_pasada ventana padre que llama
         */
        protected void setVentanaPadre(final Ventana ventanaPadre_pasada) {
            this.ventanaPadre = ventanaPadre_pasada;
        }   
        
        
         /**
         * Devuelve la lista de ventanas hijas.
         *
         * @return listaVentanasHijas
         */
        protected List<Ventana> getListaVentanasHijas() {
            return listaVentanasHijas;
        }

    /**
     * Se crea un tipo enumerado para distinguir los tipos de ventana de la librería.
     */
        
    public enum TipoVentana {
      SIMPLE("Simple"), 
      PESTANAS("Pestanas"),  
      ARBOL("Arbol");
      
      private final String tipoventana;  
      
      /**
       * 
       * @param tipo_pasado 
       */
      private TipoVentana(final String tipo_pasado){
        this.tipoventana=tipo_pasado;
      }
    }    

}
