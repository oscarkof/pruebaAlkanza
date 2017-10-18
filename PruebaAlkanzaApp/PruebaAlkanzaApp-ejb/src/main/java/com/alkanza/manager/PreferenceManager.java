package com.alkanza.manager;

import com.alkanza.ReturnOperation;
import com.alkanza.ImgPreference;
import com.alkanza.facade.PreferenceFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.jboss.logging.Logger;

/**
 *
 * @author ivanpena
 */
@Stateless
@LocalBean

public class PreferenceManager {

    private static final Logger log = Logger.getLogger(PreferenceManager.class.getName());

    @EJB
    PreferenceFacade vdf;

    public List<ImgPreference> findAll() {
        List<ImgPreference> findAll = vdf.findAll();
        return findAll;
    }   
    
    public List<ImgPreference> findRange(int numRows,int firstRow) {
        int[] range = {numRows,firstRow};
        List<ImgPreference> find = vdf.findRange(range);
        return find;
    }
    
     public ImgPreference findById(Long id) {
        ImgPreference find = vdf.find(id);
        return find;
    }

    public ReturnOperation save(ImgPreference svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.create(svd);
            return result;
        } catch (Exception e) {
            log.error("Error creando ImgPreferenceManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }

    public ReturnOperation edit(ImgPreference svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.edit(svd);
            return result;
        } catch (Exception e) {
            log.error("Error editando ImgPreferenceManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }

    public ReturnOperation delete(ImgPreference svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.remove(svd);
            return result;
        } catch (Exception e) {
            log.error("Error borrando ImgPreferenceManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }
}
