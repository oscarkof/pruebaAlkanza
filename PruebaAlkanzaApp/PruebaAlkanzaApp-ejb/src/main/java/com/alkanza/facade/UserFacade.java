package com.alkanza.facade;


import com.alkanza.AbstractFacade;
import com.alkanza.User;
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

public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "ALKANZA_PU", type = PersistenceContextType.TRANSACTION)

    private EntityManager em;

    public UserFacade() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

   
}
