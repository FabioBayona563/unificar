/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo.interfaz;

import com.vinni.aer.Entrada;
import java.util.List;

/**
 *
 * @author FABIO
 */
public interface OperacionesTorneo {
    public interface Operconsola {
    public List<Entrada> consultar(String pk);
    public List<Entrada> consultar();
    public int modificar(Entrada dato);
    public int ingresar(Entrada dato);
    public int eliminConar(Entrada dato);
    
}

}
