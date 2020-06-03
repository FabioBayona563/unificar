/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;

import java.util.logging.Logger;

/**
 *
 * @author FABIO
 */
public class prueba {
   
        
    public static void main(String datos[]) {

        Operacion op = new Operacion();
        try {
            //numero_equipo, " + "nombre_equipo, cantidad_jugadores, nombre_de_tecnico, numero_de_factura, dia_de_registro
            op.registrar(22,"Real Madrid", "22", "Felipe Neighborhoods","vsa36s21831sfas","2020-05-23","futbol");
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
