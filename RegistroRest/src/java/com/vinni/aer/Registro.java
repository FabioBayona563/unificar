/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinni.aer;

import dao.Operacion;
import dao.Respuesta;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import torneo.servicios.Mensajes;

/**
 *
 * @author Fabio Bayona
 */
@Path("Ingreso")
public class Registro {

    

    @Path("registro")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Resultado Registro(Entrada e) {
        int id= e.getId();
        String nombre= e.getNombre();
        String ciudad = e.getCiudad();
        String fecha = e.getFecha();
        String mensaje;
        if (id== 0||nombre == null ||ciudad  == null || fecha == null) {
            mensaje = "El campo de identificacion ,nombre, ciudad o fecha se encuentra vacio, ingrese información en campos";
            System.out.println(mensaje);
            Resultado r = new Resultado();
            r.setNombre(null);
            r.setCiudad(null);
            r.setFecha(null);
            r.setMensaje(mensaje);
        }
        Operacion oper = new Operacion();
        try {
            boolean rta = oper.registrar(id ,nombre, ciudad, fecha); 


            if (rta) {
                mensaje = "El registro fue exitoso";
                Resultado r = new Resultado();
                r.setId(id);
                r.setNombre(nombre);
                r.setCiudad(ciudad);
                r.setFecha(fecha);
                r.setMensaje(mensaje);
                return r;

            } else {
                mensaje = "No fue posible hacer el registro";
                Resultado r = new Resultado();
                r.setId(id);
                r.setNombre(nombre);
                r.setCiudad(ciudad);
                r.setFecha(fecha);
                r.setMensaje(mensaje);
                return r;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        Resultado r = new Resultado();
        r.setId(id);
        r.setCiudad(ciudad);
        r.setFecha(fecha);
        r.setNombre(nombre);
        r.setMensaje("Error inesperado");
        return r;
    }
    @Path("ConsultarTodos")
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
       List<Entrada> lista = oper.consultar();
       r.setEntradas(lista);
       return r;
    }
}
