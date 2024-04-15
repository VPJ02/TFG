/***
 *VentanaSimple: proporciona una ventana de dialogo sencilla, sin pestañas ni organizada en árbol  
 * 
 * @author VICTOR PERALTA JIMENEZ
 */

package libreriaTFG;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import libreriaTFG.Ventana;


public class VentanaSimple extends Ventana {
 
 /*
 * Constructor
 */   
 public VentanaSimple(){}
 
 /**
  * 
  * @return 
  */
 @Override
 public final boolean setUpVentana() {
        return super.setUpVentana();
  }
 
 /**
  * 
  * @param ventanaHija 
  * @param caption 
  */
 @Override
 public final void addVentanaHija(final Ventana ventanaHija, final String caption) {
        
        // Compruebo que el numero de ventanas hijas
        int nroVentanasHijas = getListaVentanasHijas().size();
        
        // Como no se permite tener más de 2 ventanas hijas, se lanza una excepción al intentar añadir un 3ª
        if(nroVentanasHijas >= 2){
            throw new RuntimeException(" No se pueden añadir más de 2 ventanas hijas 'SIMPLES'");
                                     
        }else{
            try{
             super.addVentanaHija(ventanaHija, caption);
         
             
             // Si da error lo capturo 
            }catch(Exception e) {

               System.out.println("ERROR VentanaSIMPLE: No puede crear la ventana HIJA");
            
            }
        }
        
            // como mucho puede haber 2 ventanas simples. Entonce o es la primera nroVentanasHijas=0,
            // o ya hay una nroVentanasHijas=1
            nueva_ventana_simple_atributos(ventanaHija, nroVentanasHijas);
            
            //redimensiono
           // redimensiona_ventanaSimple(ventanaHija.getTamano());
        
    }
    

   private void nueva_ventana_simple_atributos(Ventana ventanaHija, int nrofila) {
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = nrofila;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(ventanaHija,gbc);
    }
 
      protected final void redimensiona_ventanaSimple(Dimension tamano_ventanaHija) {
        
     /*tengo que redimensionar*/
    }    

}
