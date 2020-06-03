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
public class Entradaa 
{
    private int numeroequipo;
    private String nombreequipo;
    private String cantidadjugadores;
    private String nombredetecnico;
    private String numerodefactura;
    private String diaderegistro;
    private String tipotorneo;
    

    public int getNumeroequipo() {
        return numeroequipo;
    }

    public void setNumeroequipo(int numeroequipo) {
        this.numeroequipo = numeroequipo;
    }

    public String getNombreequipo() {
        return nombreequipo;
    }

    public void setNombreequipo(String nombreequipo) {
        this.nombreequipo = nombreequipo;
    }

    public String getCantidadjugadores() {
        return cantidadjugadores;
    }

    public void setCantidadjugadores(String cantidadjugadores) {
        this.cantidadjugadores = cantidadjugadores;
    }

    public String getNombredetecnico() {
        return nombredetecnico;
    }

    public void setNombredetecnico(String nombredetecnico) {
        this.nombredetecnico = nombredetecnico;
    }

    public String getNumerodefactura() {
        return numerodefactura;
    }

    public void setNumerodefactura(String numerodefactura) {
        this.numerodefactura = numerodefactura;
    }

    public String getDiaderegistro() {
        return diaderegistro;
    }

    public void setDiaderegistro(String diaderegistro) {
        this.diaderegistro = diaderegistro;
    }


    @Override
    public String toString()
    {
        return "El numero del equipo es : "+this.numeroequipo +"| con nombre :"+this.nombreequipo+ "| con la cantidad de jugadores :" +this.cantidadjugadores
                +"| nombre de tecnico : "+this.nombredetecnico+"| registrado con numero de factura :"+this.numerodefactura+ "| el dia :" +this.diaderegistro;
    }

    public String getTipotorneo() {
        return tipotorneo;
    }

    public void setTipotorneo(String tipotorneo) {
        this.tipotorneo = tipotorneo;
    }
}