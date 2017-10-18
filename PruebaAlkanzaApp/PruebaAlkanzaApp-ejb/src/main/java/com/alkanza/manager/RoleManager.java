package com.alkanza.manager;

import com.alkanza.ReturnOperation;
import com.alkanza.Role;
import com.alkanza.facade.RoleFacade;
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

public class RoleManager {

    private static final Logger log = Logger.getLogger(RoleManager.class.getName());

    @EJB
    RoleFacade vdf;

    public List<Role> findAll() {
        List<Role> findAll = vdf.findAll();
        return findAll;
    }   
    
    public List<Role> findRange(int numRows,int firstRow) {
        int[] range = {numRows,firstRow};
        List<Role> find = vdf.findRange(range);
        return find;
    }
    
     public Role findById(Long id) {
        Role find = vdf.find(id);
        return find;
    }

    public ReturnOperation save(Role svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.create(svd);
            return result;
        } catch (Exception e) {
            log.error("Error creando RoleManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }

    public ReturnOperation edit(Role svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.edit(svd);
            return result;
        } catch (Exception e) {
            log.error("Error editando RoleManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }

    public ReturnOperation delete(Role svd) {
        ReturnOperation result = new ReturnOperation();
        try {
            vdf.remove(svd);
            return result;
        } catch (Exception e) {
            log.error("Error borrando RoleManager", e);
            result.setCode("FAIL");
            result.setMessage(e.getMessage());
            return result;
        }
    }
}
