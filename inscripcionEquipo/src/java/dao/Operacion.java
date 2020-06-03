package dao;

import com.vinni.aer.Entradaa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;



public class Operacion {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Operacion.class);
    public boolean registrar(int numeroequipo, String nombreequipo, String cantidadjugadores,String nombredetecnico,
                                String numerodefactura, String diaderegistro, String tipotorneo) throws SQLException
    {
        PreparedStatement objPreparedStatement = null;
        Connection objConexion = null;
        int resInsert = 0;
        String sqlInsert = "insert into inscripcion(numeroequipo, "
                + "nombreequipo, cantidadjugadores, nombredetecnico, numerodefactura, diaderegistro, tipotorneo) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?)";
          try {
              LOG.info("Entrada a ingreso");
              LOG.debug("Ingreso de datos efectuados");
            Conexion c = new Conexion();
            objConexion = c.conectarse();
            objPreparedStatement = objConexion.prepareStatement(sqlInsert);
            objPreparedStatement.setInt(1, numeroequipo);
            objPreparedStatement.setString(2, nombreequipo);
            objPreparedStatement.setString(3, cantidadjugadores);
            objPreparedStatement.setString(4, nombredetecnico);
            objPreparedStatement.setString(5, numerodefactura);
            objPreparedStatement.setString(6, diaderegistro);
            objPreparedStatement.setString(7, tipotorneo);
            
            resInsert = objPreparedStatement.executeUpdate();

            objPreparedStatement.close();
            objConexion.close();

            if (resInsert > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            //LOG.catching(e);
            LOG.warn("Se efectuaron problemas en el registro");
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
    //Guardar pdfcon
    public int guardarArchivosProyecto(byte[] archivoPDF)
    {
    
        byte[] archivo = archivoPDF;
        Conexion cx = new Conexion();
        Connection cn = cx.conectarse();
        PreparedStatement consulta;
        int mensaje = 0;
        try
        {
            System.out.println(archivo.getClass().getTypeName());
            consulta = cn.prepareStatement("UPDATE inscripcion SET archivopdf = ? WHERE numero_equipo = ?");
            consulta.setBytes(1, archivo);
            consulta.setString(2,"fgh");
            consulta.executeUpdate();
            mensaje = 1;
        }catch (SQLException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }


    
    public boolean autentica(String usuario, String clave) throws SQLException {
        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex == null) {
            return false;
        } else {
            try {
                PreparedStatement ps = conex.prepareStatement("select * from usuario where cedula = ? and clave = ?");
                ps.setString(1, usuario);
                ps.setString(2, clave);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (conex != null) {
                    conex.close();
                }
            }

        }
        return false;
    }
    public List<Entradaa> consultar()
    {
        Conexion con = new Conexion();
        Connection cx = con.conectarse();
        List<Entradaa> datos = new ArrayList<Entradaa>();
        if(cx!= null)
        {
            try {
                PreparedStatement ps = cx.prepareStatement("SELECT * FROM public.inscripcion");
                
                ResultSet rs =ps.executeQuery();
                
                while(rs.next())
                {
                /*numeroequipo?:bigint;
    nombreequipo?:string;
    cantidadjugadores?:string;
    nombredetecnico?:string;
    numerodefactura?:string;
    diaderegistro?:string;
    tipotorneo?:string;*/
                    int numeroequipo = rs.getInt("numeroequipo");
                    String nombreequipo = rs.getString("nombreequipo");
                    String cantidadjugadores = rs.getString("cantidadjugadores");
                    String nombredetecnico = rs.getString("nombredetecnico");
                    String numerodefactura = rs.getString("numerodefactura");
                    String diaderegistro = rs.getString("diaderegistro");
                    String tipotorneo = rs.getString("tipotorneo");
                    Entradaa c = new Entradaa();
                    c.setNumeroequipo(numeroequipo);
                    c.setNombreequipo(nombreequipo);
                    c.setCantidadjugadores(cantidadjugadores);
                    c.setNombredetecnico(nombredetecnico);
                    c.setNumerodefactura(numerodefactura);
                    c.setDiaderegistro(diaderegistro);
                    c.setTipotorneo(tipotorneo);
                    
                    
                    datos.add(c);
                                    
                }
                return datos;
            } catch (SQLException ex) {
                LOG.error("Error en la consulta de equipos");
                Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, "Error en consulta de equipos", ex);
                
            }
        }
        return datos;
    }
    public static void main(String[] args) {
        Operacion oper = new Operacion();
        
        
        
        List<Entradaa> lista = oper.consultar();
        System.out.println("Lista"+lista);
        if(lista.size() > 0)
        {
            System.out.println("Hay datos");
            for(Entradaa entradaa : lista)
            {
                System.out.println("Equipo = "+entradaa);
            }
        }
    }
}
/*
public class Operacion {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Operacion.class);
    public boolean registrar(int numeroequipo, String nombreequipo, String cantidadjugadores,String nombredetecnico,
                                String numerodefactura, String diaderegistro, String tipotorneo) throws SQLException
    {
        PreparedStatement objPreparedStatement = null;
        Connection objConexion = null;
        int resInsert = 0;
        String sqlInsert = "insert into prueba(numeroequipo, "
                + "nombreequipo, cantidadjugadores, nombredetecnico, numerodefactura, diaderegistro, tipotorneo) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?)";
          try {
              LOG.info("Entrada a ingreso");
              LOG.debug("Ingreso de datos efectuados");
            Conexion c = new Conexion();
            objConexion = c.conectarse();
            objPreparedStatement = objConexion.prepareStatement(sqlInsert);
            objPreparedStatement.setInt(1, numeroequipo);
            objPreparedStatement.setString(2, nombreequipo);
            objPreparedStatement.setString(3, cantidadjugadores);
            objPreparedStatement.setString(4, nombredetecnico);
            objPreparedStatement.setString(5, numerodefactura);
            objPreparedStatement.setString(6, diaderegistro);
            objPreparedStatement.setString(7, tipotorneo);
            
            resInsert = objPreparedStatement.executeUpdate();

            objPreparedStatement.close();
            objConexion.close();

            if (resInsert > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            //LOG.catching(e);
            LOG.warn("Se efectuaron problemas en el registro");
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
    //Guardar pdfcon
    public int guardarArchivosProyecto(byte[] archivoPDF)
    {
    
        byte[] archivo = archivoPDF;
        Conexion cx = new Conexion();
        Connection cn = cx.conectarse();
        PreparedStatement consulta;
        int mensaje = 0;
        try
        {
            System.out.println(archivo.getClass().getTypeName());
            consulta = cn.prepareStatement("UPDATE inscripcion SET archivopdf = ? WHERE numero_equipo = ?");
            consulta.setBytes(1, archivo);
            consulta.setString(2,"fgh");
            consulta.executeUpdate();
            mensaje = 1;
        }catch (SQLException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }


    
    public boolean autentica(String usuario, String clave) throws SQLException {
        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex == null) {
            return false;
        } else {
            try {
                PreparedStatement ps = conex.prepareStatement("select * from usuario where cedula = ? and clave = ?");
                ps.setString(1, usuario);
                ps.setString(2, clave);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (conex != null) {
                    conex.close();
                }
            }

        }
        return false;
    }
    public List<Entrada> consultar()
    {
        Conexion con = new Conexion();
        Connection cx = con.conectarse();
        List<Entrada> datos = new ArrayList<Entrada>();
        if(cx!= null)
        {
            try {
                PreparedStatement ps = cx.prepareStatement("SELECT * FROM public.prueba");
                
                ResultSet rs =ps.executeQuery();
                
                while(rs.next())
                {
                
                    int numeroequipo = rs.getInt("numeroequipo");
                    String nombreequipo = rs.getString("nombreequipo");
                    String cantidadjugadores = rs.getString("cantidadjugadores");
                    String nombredetecnico = rs.getString("nombredetecnico");
                    String numerodefactura = rs.getString("numerodefactura");
                    String diaderegistro = rs.getString("diaderegistro");
                    String tipotorneo = rs.getString("tipotorneo");
                    Entrada c = new Entrada();
                    c.setNumeroequipo(numeroequipo);
                    c.setNombreequipo(nombreequipo);
                    c.setCantidadjugadores(cantidadjugadores);
                    c.setNombredetecnico(nombredetecnico);
                    c.setNumerodefactura(numerodefactura);
                    c.setDiaderegistro(diaderegistro);
                    c.setTipotorneo(tipotorneo);
                    
                    
                    datos.add(c);
                                    
                }
                return datos;
            } catch (SQLException ex) {
                LOG.error("Error en la consulta de equipos");
                Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, "Error en consulta de equipos", ex);
                
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
                System.out.println("Equipo = "+entrada);
            }
        }
    }
}
    */

      

 
    

