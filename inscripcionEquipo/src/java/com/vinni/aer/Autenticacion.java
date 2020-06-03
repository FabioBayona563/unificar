/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinni.aer;

import dao.Operacion;
import equipos.dto.Respuesta;
import equipos.servicio.Mensajes;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sun.misc.IOUtils;



/**
 *
 * @author Fabio Bayona
 */
@Path("Registrar")
public class Autenticacion 
{

   
    @Path("registro")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado Registro(Entradaa e) {
        int numeroequipo = e.getNumeroequipo();
        String nombreequipo = e.getNombreequipo();
        String cantidadjugadores = e.getCantidadjugadores();
        String nombredetecnico = e.getNombredetecnico();
        String numerodefactura = e.getNumerodefactura();
        String diaderegistro = e.getDiaderegistro();
        String tipotorneo = e.getTipotorneo();
        String mensaje;
        if (numeroequipo == 0 || nombreequipo == null || cantidadjugadores == null || nombredetecnico == null
                || numerodefactura == null || diaderegistro == null || tipotorneo == null) {
            mensaje = "La información ingresada está incompleta";
            System.out.println(mensaje);
            Resultado r = new Resultado();
            r.setNumeroequipo(0);
            r.setDiaderegistro(null);
            r.setNombredetecnico(null);
            r.setNombreequipo(null);
            r.setNumerodefactura(null);
            r.setCantidadjugadores(null);
            r.setTipotorneo(null);
            //r.setMensaje(mensaje);
        }
        Operacion oper = new Operacion();
        try {
            boolean rta = oper.registrar(numeroequipo, nombreequipo, cantidadjugadores, 
                    nombredetecnico, numerodefactura,diaderegistro,tipotorneo); 
// ARREGLAR PARA LA BASE DE DATOS EN OPERACION

            if (rta) {
                mensaje = "El registro fue exitoso";
                Resultado r = new Resultado();
                r.setNumeroequipo(numeroequipo);
                r.setNombreequipo(nombreequipo);
                r.setCantidadjugadores(cantidadjugadores);
                r.setNumerodefactura(numerodefactura);
                r.setNumerodefactura(numerodefactura);
                r.setDiaderegistro(diaderegistro);
                r.setTipotorneo(tipotorneo);
                //r.setMensaje(mensaje);
                return r;

            } else {
                mensaje = "No es posible registrar, este NMC ya fue tomado";
                Resultado r = new Resultado();
                r.setNumeroequipo(numeroequipo);
                r.setNombreequipo(nombreequipo);
                r.setCantidadjugadores(cantidadjugadores);
                r.setNumerodefactura(numerodefactura);
                r.setNumerodefactura(numerodefactura);
                r.setDiaderegistro(diaderegistro);
                r.setTipotorneo(tipotorneo);
                //r.setMensaje(mensaje);
                return r;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        Resultado r = new Resultado();
        r.setNumeroequipo(-1);
        r.setNombreequipo(nombreequipo);
        r.setCantidadjugadores(cantidadjugadores);
        r.setNumerodefactura(numerodefactura);
        r.setNumerodefactura(numerodefactura);
        r.setDiaderegistro(diaderegistro);
        r.setTipotorneo(tipotorneo);
        //r.setMensaje("Error inesperado");
        return r;
    }

  /*
    @POST
    @Path("cargarDatos")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado cargarDatos(@FormDataParam("file") InputStream uploadedInputStream)
    {
    //System.out.println("So"+solicitud);
        Resultado r = new Resultado();
        try 
        {
            System.out.println("tipo de dato -> "+uploadedInputStream.toString());
            byte[]  data = null;
            //data = IOUtils.to
            data = IOUtils.toByteArray(uploadedInputStream);
            Operacion ddb = new Operacion();
            r.setCodigo(ddb.guardarArchivosProyecto(data));
       
        } catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
        return r;
    }
*/
    @Path("ConsultarEqui")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta consultar()
    {
       Respuesta r = new Respuesta();
       r.setCodigo(Mensajes.COD_EXITO);
       r.setMensajeE(Mensajes.MENSAJE_EXITO);
       //OperConsolaIM oper = new OperConsolaIM();
       Operacion oper = new Operacion();
       List<Entradaa> lista = oper.consultar();
       r.setEntradas(lista);
       return r;
    }
}
