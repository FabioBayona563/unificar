/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinni.microserv;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
/**
 *
 * @author Fabio Bayona
 */
public class CORSRequestFilter implements ContainerRequestFilter {

  public CORSRequestFilter() {
    super();
  }

  @Override
  public void filter(ContainerRequestContext containerRequestContext) throws IOException {
    if (containerRequestContext.getRequest().getMethod().equalsIgnoreCase("OPTIONS")) {
      containerRequestContext.abortWith(Response.status(Response.Status.OK).build());
    }
  }

}

