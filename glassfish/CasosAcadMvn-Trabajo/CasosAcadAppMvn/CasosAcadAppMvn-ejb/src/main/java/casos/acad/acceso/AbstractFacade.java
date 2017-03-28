/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.acceso;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author omar
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public T crear(T entity) {
        T salida = null;
        try {
            EntityManager em = this.getEntityManager();
            if (em != null && entity != null) {
                em.persist(entity);
                salida = entity;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return salida;
    }

    public T editar(T entity) {
        T salida = null;
        try {
            EntityManager em = this.getEntityManager();
            if (em != null && entity != null) {
                em.merge(entity);
                salida = entity;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return salida;
    }

    public boolean remover(T entity) {
        boolean salida = false;
        try {
            EntityManager em = this.getEntityManager();
            em.remove(em.merge(entity));
            salida = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return salida;
    }
    
    public List<T> findAll() {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
        List salida = null;
        try {
            EntityManager em = this.getEntityManager();
            if (em != null) {
                salida = em.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
                if (salida != null) {
                    return salida;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (salida == null) {
                salida = new ArrayList();
            }
        }
        return salida;
    }
    
    public T findById(Integer id) {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
        T salida = null;
        try {
            EntityManager em = this.getEntityManager();
            if (em != null) {
                salida = (T) em.createQuery("SELECT t FROM TipoPaso t WHERE t."+entityClass.getSimpleName()+" = :"+id);
                if (salida != null) {
                    return salida;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return salida;
    }
    
}
