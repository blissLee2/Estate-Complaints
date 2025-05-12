/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entities.Resident;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author General_user
 */
@Stateless
public class ResidentFacade extends AbstractFacade<Resident> implements ResidentFacadeLocal {

    @PersistenceContext(unitName = "HomeworkEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResidentFacade() {
        super(Resident.class);
    }

    @Override
public List<Resident> findInEst(String estateName) {
    String stmt = "SELECT r FROM Resident r WHERE r.estate.estateName = :estateName";
    Query q = em.createQuery(stmt);
    q.setParameter("estateName", estateName);
    return (List<Resident>)q.getResultList();
}

   
    
}
