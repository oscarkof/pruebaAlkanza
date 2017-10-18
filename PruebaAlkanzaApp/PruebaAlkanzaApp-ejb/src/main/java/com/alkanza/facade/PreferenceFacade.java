package com.alkanza.facade;


import com.alkanza.AbstractFacade;
import com.alkanza.ImgPreference;
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

public class PreferenceFacade extends AbstractFacade<ImgPreference> {

    @PersistenceContext(unitName = "ALKANZA_PU", type = PersistenceContextType.TRANSACTION)

    private EntityManager em;

    public PreferenceFacade() {
        super(ImgPreference.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

   
}
