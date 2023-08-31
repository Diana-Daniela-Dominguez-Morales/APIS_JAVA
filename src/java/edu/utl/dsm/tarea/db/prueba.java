/** * @author DANIELA */
package edu.utl.dsm.tarea.db;

import edu.utl.dsm.tarea.controller.ControllerTarea;
import edu.utl.dsm.tarea.model.Tarea;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.utl.dsm.tarea.model.Tarea;

/**
 * * @author DANIELA
 */
public class prueba {

    public static void main(String[] args) throws Exception {
   probarGetall();
   
    }

    public static void probarInsertTarea() {
        try {
            Tarea sa = new Tarea();
            sa.setId(23);
            sa.setDescripcion("Crud java");
            sa.setEstatus("progreso");
           
            ControllerTarea objCs = new ControllerTarea();
         objCs.insert(sa);
         

        } catch (Exception ex) {
            System.out.println("fallo");
        }
    }
    
    public static void probarUpdateTarea() {
        try {
            Tarea sa = new Tarea();
            sa.setId(3);
            sa.setDescripcion("Crud java");
            sa.setEstatus("terminado");
           
            ControllerTarea objCs = new ControllerTarea();
         objCs.update(3,sa);
         

        } catch (Exception ex) {
            System.out.println("fallo");
        }
    }

    public static void probarCon() {
        ConexionMySQL objCon = new ConexionMySQL();
        try {
            objCon.open();//abre la conexion
            System.out.println(objCon.toString());//muestra la dirección 
            objCon.close();//cierra la conexion
        } catch (Exception ex) {
            ex.printStackTrace(); //Muestra el error
            //  Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);//lleva a logger de netbeans
        }
    }

    public static void probarGetall() {
        try {
            ControllerTarea objCS = new ControllerTarea();
            List<Tarea> cliente = objCS.getall();
            for (int i = 0; i < cliente.size(); i++) {
                System.out.println(cliente.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void probarDelete() {
        try {
            ControllerTarea objCS = new ControllerTarea();
            objCS.delete(2);
            System.out.println("Se han eliminado los datos ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    
}
