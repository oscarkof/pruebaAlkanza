package com.alkanza.facade;


import com.alkanza.AbstractFacade;
import com.alkanza.Role;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author ivanps
 */
@Stateless
@LocalBean

public class RoleFacade extends AbstractFacade<Role> {

    @PersistenceContext(unitName = "ALKANZA_PU", type = PersistenceContextType.TRANSACTION)

    private EntityManager em;

    public RoleFacade() {
        super(Role.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

   
}
