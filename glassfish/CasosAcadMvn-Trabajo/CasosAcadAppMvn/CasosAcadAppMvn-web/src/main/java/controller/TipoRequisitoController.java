/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import casos.acad.acceso.TipoRequisitoFacadeLocal;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.ejb.EJB;
import casos.acad.casosacaddatalibmvn.TipoRequisito;

/**
 *
 * @author omar
 */
@Named(value = "tipoRequisitoController")
@ViewScoped
public class TipoRequisitoController implements Serializable {

    @EJB
    private TipoRequisitoFacadeLocal tipoRequisitoFacade;

    private TipoRequisito tr = new TipoRequisito();
    private boolean editando = false;

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public TipoRequisito getTr() {
        return tr;
    }

    public void setTr(TipoRequisito tr) {
        this.tr = tr;
    }

    public TipoRequisitoController() {
    }

    public List<TipoRequisito> findAll() {
        return this.tipoRequisitoFacade.findAll();
    }

    public void agregar() {
        this.tipoRequisitoFacade.crear(this.tr);
        this.tr = new TipoRequisito();
        this.editando = false;
    }

    public String borrar() {
        if(this.tr.getIdTipoRequisito()!=null){
        this.tipoRequisitoFacade.remover(this.tr);
        this.tr = new TipoRequisito();
        }else{
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "borrar";
        
    }

    public void seleccionar(TipoRequisito tr) {
        this.tr.setIdTipoRequisito(tr.getIdTipoRequisito());
        this.tr.setNombre(tr.getNombre());
        this.tr.setActivo(tr.getActivo());
        this.tr.setDescripcion(tr.getDescripcion());
        this.editando = true;
    }

    public String editar() {
        if (this.tr.getIdTipoRequisito() != null) {
            this.tipoRequisitoFacade.editar(this.tr);
            this.tr = new TipoRequisito();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "index";
    }
    public void limpiar(){
        this.tr = new TipoRequisito();
        this.editando = false;
    }
    
}
