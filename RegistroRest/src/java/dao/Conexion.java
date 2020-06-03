package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
/*
public class Conexion {
    public Connection conectarse() {
        String bd = "gestorTorneos"; 
        String usuario = "admin"; 
        String clave = "admin"; 
        try { 
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/"+bd,
                    usuario, clave);
            return conexion;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return null;
    }
    
}

/**
 *
 * @author FABIO
 */
public class Conexion {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Conexion.class);
    public Connection conectarse()
            
    {
        String url="jdbc:postgresql://127.0.0.1:5432/gestorTorneos";
        String usuario="admin";
        String clave="admin"; 
        
        try {
            LOG.info("Efectuando conexión");
            LOG.debug("Conexión efectuada con base de datos");
            Class.forName("org.postgresql.Driver");
            Connection cx = DriverManager.getConnection(url, usuario, clave);
            return cx;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "No está el driver de postgres", ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Usuario o clave incorrectos", ex);
        }
        return null;
    }
    public void desconectarse (Connection conx)
    {
        if(conx !=null)
        {
            try {
                conx.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al cerrar conexion", ex);
            }
        }
    }
   
    /*
    public static void main(String[] args) 
    {
     Conexion con = new Conexion();
     Connection cx = con.conectarse();
     System.out.println("Si conecto "+cx);
    }*/
}
