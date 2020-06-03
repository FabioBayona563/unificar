package dao;

import com.vinni.aer.Entrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class Operacion {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Operacion.class);
    public boolean registrar(int id,String nombre, String ciudad, String fecha) throws SQLException
    {
        PreparedStatement objPreparedStatement = null;
        Connection objConexion = null;
        int resInsert = 0;
        int a = 0;
        
        String sqlInsert = "insert into registro(id, nombre, ciudad, fecha) VALUES"
                + "(?, ?, ?, ?)";
          try {
              a = a ++;
              LOG.info("Ingreso");
              LOG.debug("Entrada a registro de datos"+ a);
            Conexion c = new Conexion();
            objConexion = c.conectarse();
            objPreparedStatement = objConexion.prepareStatement(sqlInsert);
            objPreparedStatement.setInt(1, id);
            objPreparedStatement.setString(2, nombre);
            objPreparedStatement.setString(3, ciudad);
            objPreparedStatement.setString(4, fecha);
            LOG.warn("Cambio en base de datos - registro efectuado");
            resInsert = objPreparedStatement.executeUpdate();

            objPreparedStatement.close();
            objConexion.close();

            if (resInsert > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            LOG.error("Error inesperado");
            e.printStackTrace();
            return false;

        } finally {

            if (objConexion != null) {
                objConexion.close();
            }

            if (objPreparedStatement != null) {
                objPreparedStatement.close();
            }

        }
    }
    public List<Entrada> consultar()
    {
        Conexion con = new Conexion();
        Connection cx = con.conectarse();
        List<Entrada> datos = new ArrayList<Entrada>();
        if(cx!= null)
        {
            try {
                LOG.info("Llamada a consultas");
               
                PreparedStatement ps = cx.prepareStatement("select * from registro");
                
                ResultSet rs =ps.executeQuery();
                
                while(rs.next())
                {
                    
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String ciudad = rs.getString("ciudad");
                    String fecha = rs.getString("fecha");

                    Entrada c = new Entrada();
                    c.setId(id);
                    c.setNombre(nombre);
                    c.setCiudad(ciudad);
                    c.setFecha(fecha);
                    
                    
                    datos.add(c);
                    LOG.debug("Consulta efectuada");
                }
                return datos;
                
            } catch (SQLException ex) {
                 LOG.error("Se produjo un error en la consulta a la base de datos");
                Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, "Error en consulta de torneos", ex);
                
            }
        }
        return datos;
    }
    public static void main(String[] args) {
        Operacion oper = new Operacion();
        
        
        
        List<Entrada> lista = oper.consultar();
        System.out.println("Lista"+lista);
        if(lista.size() > 0)
        {
            System.out.println("Hay datos");
            for(Entrada entrada : lista)
            {
                System.out.println("Torneo "+entrada);
            }
        }
    }
   
}

    

      

 
    

