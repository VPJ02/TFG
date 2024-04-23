/***
 *VentanaSimple: proporciona una ventana de dialogo sencilla, sin pestañas ni organizada en árbol  
 * 
 * @author VICTOR PERALTA JIMENEZ
 */

package libreriaTFG;

import java.awt.Dimension;
import java.awt.GridBagConstraints;


public class VentanaSimple extends Ventana {
 
 /*
 * Constructor
 */   
 public VentanaSimple(){}
 
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
  
       //System.out.println("El nombre de ventana de this es" + this.getVentanaPadre().getNombreVentana() ) ; 
     
     
        // Compruebo que el numero de ventanas hijas
        int nroVentanasHijas = this.getListaVentanasHijas().size();
        
        // Como no se permite tener más de 2 ventanas hijas, se lanza una excepción al intentar añadir un 3ª
        if(nroVentanasHijas >= 2){
            throw new RuntimeException(" No se pueden añadir más de 2 ventanas hijas 'SIMPLES'");
                                     
        }else{
            try{
               super.addVentanaHija(ventanaHija, caption);
         
               ventanaHija.setVentanaPadre(super.getVentanaPadre());
             // Si da error lo capturo 
            }catch(Exception e) {

               System.out.println("ERROR VentanaSIMPLE: No puede crear la ventana HIJA");
            
            }
        }
        
            // como mucho puede haber 2 ventanas simples. Entonces o es la primera nroVentanasHijas=0,
            // o ya hay una nroVentanasHijas=1
           nueva_ventana_simple_atributos(ventanaHija, nroVentanasHijas);
           
            //redimensiono
           redimensiona_ventanaSimple(ventanaHija.getSize() , nroVentanasHijas);
           
        
    }
    
   /**
    * nueva_ventana_simple_atributos: Establece los atributos para el dimensionamiento
    * de la nueva ventana que se va añadir que será arriba (fila 0) o abajo (fila 1) 
    * 
    * @param ventanaHija ventana a añadir 
    * @param nrofila solo puede ser 0 o 1 ya que solo se pueden añadir 2 ventanas simples y la fila 2
    *                esta ocupada por los botones
    */
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
 
    protected final void redimensiona_ventanaSimple(Dimension tamano_ventanaHija, int nroVentanasHijas) {
      
      final Dimension tamano_del_padre = this.getVentanaPadre().getSize();
      final Dimension tamano_determinado = new Dimension(tamano_del_padre);

      tamano_determinado.width = Math.max(tamano_del_padre.width, tamano_ventanaHija.width);
      tamano_determinado.height = tamano_del_padre.height + tamano_ventanaHija.height;

      this.setSize(tamano_determinado);
      
    }    

}
