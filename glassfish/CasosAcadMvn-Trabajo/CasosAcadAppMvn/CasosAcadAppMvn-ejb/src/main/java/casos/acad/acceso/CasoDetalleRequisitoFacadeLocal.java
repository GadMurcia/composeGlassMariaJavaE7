/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.acceso;

import casos.acad.casosacaddatalibmvn.CasoDetalleRequisito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author omar
 */
@Local
public interface CasoDetalleRequisitoFacadeLocal {

    void create(CasoDetalleRequisito casoDetalleRequisito);

    void edit(CasoDetalleRequisito casoDetalleRequisito);

    void remove(CasoDetalleRequisito casoDetalleRequisito);

    CasoDetalleRequisito find(Object id);

    List<CasoDetalleRequisito> findAll();

    List<CasoDetalleRequisito> findRange(int[] range);

    int count();
    
}
