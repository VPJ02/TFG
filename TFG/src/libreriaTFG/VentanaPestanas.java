/***
 * VentanaPestanas: proporciona una ventana de dialogo organizada en pestañas  
 * 
 * @author VICTOR PERALTA JIMENEZ
 */
package libreriaTFG;

import javax.swing.JTabbedPane;

public class VentanaPestanas extends Ventana {
 
    
 private JTabbedPane panel_pestanas;
      
    
 /*
 * Constructor
 */   
 public VentanaPestanas(){}
 
 @Override
 public final boolean setUpVentana() {
        return super.setUpVentana();
  }
 
 
    @Override
public final void addVentanaHija(final Ventana ventanaHija, final String caption) {
        
        try {
            // parte común a todos los tipos
            super.addVentanaHija(ventanaHija,caption);
            
            
            panel_pestanas=this.getPanel_Pestanas();
            panel_pestanas.addTab(caption, ventanaHija);
                       
            
            //Tengo que redimensionar
           
          // Si da error lo capturo 
        }catch(Exception e) {
               System.out.println("ERROR Ventana: No puede crear la ventana HIJA de PESTANAS");
          }
    }

 
   /**
   * GETs y SETs       * 
   */
 
    
    public JTabbedPane getPanel_Pestanas() {
        return panel_pestanas;
    }

    
    public void setPanel_Pestanas(JTabbedPane zona_pestanas) {
        this.panel_pestanas = zona_pestanas;
    }
    
    
    
}
