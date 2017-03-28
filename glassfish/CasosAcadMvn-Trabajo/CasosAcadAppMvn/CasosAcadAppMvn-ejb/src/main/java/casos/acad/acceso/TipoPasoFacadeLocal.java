/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.acceso;

import casos.acad.casosacaddatalibmvn.TipoPaso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author omar
 */
@Local
public interface TipoPasoFacadeLocal {

    void create(TipoPaso tipoPaso);

    void edit(TipoPaso tipoPaso);

    void remove(TipoPaso tipoPaso);

    TipoPaso find(Object id);

    List<TipoPaso> findRange(int[] range);

    int count();
    //Métodos creados para el manejo de TipoPaso
    List<TipoPaso> findAll();
    
    TipoPaso crear(TipoPaso tipoPaso);
    
    TipoPaso editar(TipoPaso tipoPaso);
    
    boolean remover(TipoPaso tipoPaso);
    
    TipoPaso findById(Integer id);
    
}
