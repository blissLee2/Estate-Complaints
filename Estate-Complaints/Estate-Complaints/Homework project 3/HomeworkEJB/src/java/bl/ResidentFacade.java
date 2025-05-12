/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entities.Resident;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
