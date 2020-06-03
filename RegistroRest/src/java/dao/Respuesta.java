/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.vinni.aer.Entrada;
import java.util.List;

/**
 *
 * @author FABIO
 */
public class Respuesta {
    private int codigo;
    private String mensajeE;
    
    private List<Entrada> entrada;

    public List<Entrada> getEntradas() {
        return entrada;
    }

    public void setEntradas(List<Entrada> entrada) {
        this.entrada = entrada;
    }
    

    public Respuesta() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensajeE() {
        return mensajeE;
    }

    public void setMensajeE(String mensajeE) {
        this.mensajeE = mensajeE;
    }


    
    
}
