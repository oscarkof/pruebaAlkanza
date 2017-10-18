package com.alkanza.manager;

import com.alkanza.ReturnOperation;
import com.alkanza.User;
import com.alkanza.facade.UserFacade;
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

public class UserManager {

    private static final Logger log = Logger.getLogger(UserManager.class.getName());

    @EJB
    UserFacade vdf;

    public List<User> findAll() {
        List<User> findAll = vdf.findAll();
        return findAll;
    }
    
    public List<User> findRange(int numRows,int firstRow) {
        int[] range = {numRows,firstRow};
        List<User> find = vdf.findRange(range);
        return find;
    }
    
     public User findById(Long id) {
        User find = vdf.find(id);
        return find;
    }

    public ReturnOperation save(User svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.create(svd);
            return result;
        } catch (Exception e) {
            log.error("Error creando UserManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }

    public ReturnOperation edit(User svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.edit(svd);
            return result;
        } catch (Exception e) {
            log.error("Error editando UserManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }

    public ReturnOperation delete(User svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.remove(svd);
            return result;
        } catch (Exception e) {
            log.error("Error borrando UserManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }
}
