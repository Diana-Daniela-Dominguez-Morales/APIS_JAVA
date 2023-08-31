/**
 *
 * @author DANIELA
 */
package edu.utl.dsm.tarea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMySQL {

    Connection conexion;

  /**
   * Metodo para generar y abrir una conexión
   * @return
   * @throws Exception 
   */

    public Connection open() throws Exception {
        // Establecer el driver con el que vamos a trabajar
        String driver = "com.mysql.jdbc.Driver";
        //Establecer la ruta de conexion 
        String url = "jdbc:mysql://localhost:3306/tarea";
        //Establecer los valores para los permisos
        String user = "root";
        String password = "diana123";

        //Damos de alta el uso del driver
        Class.forName(driver);

        //Abrimos la conexion
        conexion = DriverManager.getConnection(url, user, password);
        // retornamos la conexion que se ha creado y abierto
        return conexion;
    }
    /**
     * Este metodo es para cerrar una conexion a BD de MySQL que esta abierta
     */
    public void close() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
