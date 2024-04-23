/***
 * VentanaArbol: proporciona una ventana de dialogo organizada en árbol  
 * 
 * @author VICTOR PERALTA JIMENEZ
 */
package libreriaTFG;

//import java.awt.CardLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class VentanaArbol extends Ventana{
    
 //Necesito la ventana del arbol y la de pantalla de trabajo
 private JTree  el_arbol;   
 private JPanel panel_trabajo;
 
 private DefaultMutableTreeNode rama;
 
 private JSplitPane divisor_arbol;    
 /*
 * Constructor
 */   
 public VentanaArbol(){}
 
 @Override
 public final boolean setUpVentana() {
        return super.setUpVentana();
  }

  
 @Override
 public final void addVentanaHija(final Ventana ventanaHija, final String caption) {
        try {
            // parte común a todos los tipos
            super.addVentanaHija(ventanaHija,caption);
            
            nuevaRama(ventanaHija,caption);
            
                        
            
            //Tengo que redimensionar
            
            
          // Si da error lo capturo 
        }catch(Exception e) {
               System.out.println("ERROR Ventana: No puede crear la ventana HIJA de ARBOL");
         }
 
     
 }

 public final void nuevaRama(Ventana ventanaHija, final String caption){
     // DefaultTreeModel modeloRama;
     
        try {
            
            el_arbol= this.getArbol();
            //rama=this.getRama();
            rama=(DefaultMutableTreeNode) el_arbol.getModel().getRoot();
            //añado la rama
            rama.add(new DefaultMutableTreeNode(caption));
            //modeloRama=new DefaultTreeModel(rama);
            el_arbol.setModel(new DefaultTreeModel(rama));
              
            panel_trabajo=this.getPanel_trabajo();
            //y la pantalla de trabajo
            panel_trabajo.add(caption, ventanaHija);
             
            
                 
            
             //definimos los eventos
             el_arbol.addTreeSelectionListener(new TreeSelectionListener() {
	     public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode nseleccionado = (DefaultMutableTreeNode) el_arbol.getLastSelectedPathComponent();
                System.out.print (nseleccionado.toString());
                setPanel_trabajo(ventanaHija);
		panel_trabajo.setVisible(true); ;
	       }
            });
       
             
            
            
            //Tengo que redimensionar
            
            
          // Si da error lo capturo 
        }catch(Exception e) {
               System.out.println("ERROR VentanaArbol: No puede crear la nueva RAMA de ARBOL");
         }
 
 }
 
 
   /**
   * GETs y SETs       * 
   */
 
    public JTree getArbol() {
        return el_arbol;
    }

    public void setArbol(JTree arbolado) {
        this.el_arbol = arbolado;
    }

    public JPanel getPanel_trabajo() {
        return panel_trabajo;
    }

    public void setPanel_trabajo(JPanel pantalla_trabajo) {
        this.panel_trabajo = pantalla_trabajo;
    }
    
    public void setPanel_trabajo(Ventana ventana_trabajo) {
        this.panel_trabajo = ventana_trabajo;
    }
    public DefaultMutableTreeNode getRama() {
        return rama;
    }

    public void setRama(JTree arbolado) {
        this.rama = (DefaultMutableTreeNode) arbolado.getModel().getRoot();
    }
    
    
    public JSplitPane getDivisor_arbol() {
        return divisor_arbol;
    }

    public void setDivisor_arbol(JSplitPane zona_arbol) {
        this.divisor_arbol = zona_arbol;
    }

    
}
