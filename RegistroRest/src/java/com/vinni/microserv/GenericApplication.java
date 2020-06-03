/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinni.microserv;


import com.vinni.aer.Registro;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
/**
 *
 * @author Fabio Bayona 
 */
@ApplicationPath("app")
public class GenericApplication extends ResourceConfig{

    public GenericApplication (){
        register(Registro.class);    
        register(new CORSFilter());
        register(new CORSRequestFilter());

    }
}
