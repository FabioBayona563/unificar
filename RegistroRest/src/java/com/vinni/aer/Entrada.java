/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinni.aer;


/**
 *
 * @author Fabio Bayona
 */
public class Entrada {
    private int id;
    private String nombre;
    private String ciudad;
    private String fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString()
    {
        return "La id de torneo es : "+this.id +"| con nombre :"+this.nombre+ "| con ciudad :" +this.ciudad+"| para la fecha de inicio : "+this.fecha;
    }

    

}