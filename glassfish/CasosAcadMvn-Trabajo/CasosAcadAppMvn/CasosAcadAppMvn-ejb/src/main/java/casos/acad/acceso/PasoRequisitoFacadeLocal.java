/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.acceso;

import casos.acad.casosacaddatalibmvn.PasoRequisito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author omar
 */
@Local
public interface PasoRequisitoFacadeLocal {

    void create(PasoRequisito pasoRequisito);

    void edit(PasoRequisito pasoRequisito);

    void remove(PasoRequisito pasoRequisito);

    PasoRequisito find(Object id);

    List<PasoRequisito> findAll();

    List<PasoRequisito> findRange(int[] range);

    int count();
    
}
