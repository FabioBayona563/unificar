/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
            op.registrar(741,"prueba", "narna", "12/12/20");
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, "No se pudo registrar", ex);
        }
    }
}
