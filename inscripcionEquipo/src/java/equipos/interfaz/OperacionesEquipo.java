/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipos.interfaz;

import com.vinni.aer.Entradaa;
import java.util.List;

/**
 *
 * @author FABIO
 */
public interface OperacionesEquipo {
    public interface Operconsola {
    public List<Entradaa> consultar(String pk);
    public List<Entradaa> consultar();
    public int modificar(Entradaa dato);
    public int ingresar(Entradaa dato);
    public int eliminConar(Entradaa dato);
    
}

}
