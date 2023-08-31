package edu.utl.dsm.tarea.controller;

import edu.utl.dsm.tarea.db.ConexionMySQL;
import edu.utl.dsm.tarea.model.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * ESta clase contieene los métodos necesarios para la permanencia y consulta de
 * la información de las tareas en la BD
 *
 * @author DANIELA
 */
public class ControllerTarea {

    /**
     *
     * @param s Se resibe un parametro de tipo tarea ,que contenga los daatos
     * a almacenar
     * @return Devuelve el id generado con la insercion del regisstro
     * @throws Exception
     */
    //insertar los metodos de una tarea
    public int insert(Tarea s) throws Exception {
        //Definir la sentencia SQL para realizar la inserción de una tarea
        String query = "INSERT INTO tarea(descripcion, estado)"
                + "VALUES(?,?)";

        // Se declara la variable donde se almacena el id que creamos
        int idGenerado = -1;// si es -1 no se realizo la insercion

        //Se genera un objeto de la conexion y la abrimos 
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        //Generar el objeto que lleve la consulta a la BD
        //Que permita recibir el id
        PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);//flecha de ida

        // Terminar la sentencia/ cargar el objeto pstmt-> flecha que va al servicio 
        pstmt.setString(1, s.getDescripcion());
        pstmt.setString(2, s.getEstatus());

        //Generar un objeto que guarda el resultado de la consulta
        ResultSet rs = null;

        //Ejecutamos la consulta
        pstmt.executeUpdate();

        //Solicitar al PreparedStatement el valor que se genero
        rs = pstmt.getGeneratedKeys();

        //tomar el valor generado
        if (rs.next()) {
            idGenerado = rs.getInt(1);
            s.setId(idGenerado);
        }
        //Cerrar los objetos de conexion
        rs.close();
        pstmt.close();
        connMySQL.close();

        //Devolvemos el id 
        return idGenerado;
    }

    /**
     *
     * @return Se devuelve una lista con las tareas encontradas con la SQL
     * la lista dinamica devuelta contiene nodos de tipo {}
     * @throws Exception
     */
    public List<Tarea> getall() throws Exception {
        // 1° Definir la consulta SQL
        String guery = "SELECT * FROM tarea ;";
        // Generar la lista de sucursales que se va a obtener con la consulta
        List<Tarea> sala = new ArrayList<Tarea>();

        //2° Crear un objeto de la coneion a la bd y abrirla 
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        //3° Crear el objeto que nos permite enviar y ejecutar la consulta SQL
        PreparedStatement pstmt = conn.prepareStatement(guery);

        //4° Ejecutammos la sentencia y recibimos el resultado 
        ResultSet rs = pstmt.executeQuery();

        //Recorremos el Rs para sacar los datos de las tareas
        while (rs.next()) {
            //Generar una variable temporal para crear nuevas instancias de la tareas
            Tarea s = new Tarea();

            //Se llena los atrubutos del objeto sucursal con los datos del resutSet
            s.setId(rs.getInt("id"));
            s.setDescripcion(rs.getString("descripcion"));
            s.setEstatus(rs.getString("estado"));

            // Agregamos el objeto de s a la lista tareas 
            sala.add(s);
        }
        //cerrar los objetos a la BD
        rs.close();
        pstmt.close();
        connMySQL.close();

        //Devuelve las lista de tareas
        return sala;
    }

    /**
     * Metodo que elimina de forma logica un registro de tarea
     *
     * @param id Resibe como parametro el id de l sucursal que se desea eliminar
     * @throws Exception
     */
    public void delete(int id) throws Exception {
        //Generar la consulta SQL
        String query = "DELETE FROM tarea WHERE id=" + id + ";";

        //generar la conexion a la bd y abrila
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        //GEnerar el objeto que lleba la consulta
        PreparedStatement pstmt = conn.prepareStatement(query);

        //ejecutamos la consulta SQL
        pstmt.executeUpdate();

        //cerrar los objetos de coneion a la bd
        pstmt.close();
        connMySQL.close();
    }
    /**
     * Este metodo realiza la mmodificacion o la actualizacion de una consulta
     * @param id resibe como parametro id para condicionar que sea esa tarea
     * @param s recibe un objeto de tipo tarea 
     * @throws Exception 
     */
    public void update(int id,Tarea s ) throws Exception {
        //realizamos la consulta mysql
        String query = "UPDATE tarea SET descripcion='"+s.getDescripcion()+
                 "', estado='"+s.getEstatus()+"' WHERE id='"+ id +"';";
        //Se genera un objeto de la conexion y la abrimos 
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
   
       //GEnerar el objeto que lleba la consulta
        PreparedStatement pstmtm = conn.prepareStatement(query);

        //ejecutamos la consulta SQL
        pstmtm.executeUpdate();
        
        //cerrar los objetos
        pstmtm.close();
        connMySQL.close();
    }

  
   

    
    
    
}
