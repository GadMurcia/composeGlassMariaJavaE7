/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.acceso;

import casos.acad.casosacaddatalibmvn.TipoRequisito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author omar
 */
@Local
public interface TipoRequisitoFacadeLocal {

    void create(TipoRequisito tipoRequisito);

    void edit(TipoRequisito tipoRequisito);

    void remove(TipoRequisito tipoRequisito);

    TipoRequisito find(Object id);

    List<TipoRequisito> findAll();

    List<TipoRequisito> findRange(int[] range);

    int count();
    
    TipoRequisito crear(TipoRequisito tipoRequisito);
    
    TipoRequisito editar(TipoRequisito tipoRequisito);
    
    boolean remover(TipoRequisito tipoRequisito);
    
    TipoRequisito findById(Integer id);    
    
}
