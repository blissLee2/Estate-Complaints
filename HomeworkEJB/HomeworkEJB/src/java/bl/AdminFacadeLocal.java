/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entities.Admin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author General_user
 */
@Local
public interface AdminFacadeLocal {

    void create(Admin admin);

    void edit(Admin admin);

    void remove(Admin admin);

    Admin find(Object id);

    List<Admin> findAll();

    List<Admin> findRange(int[] range);

    List<Admin> findInEst(String estateName);
    int count();
    
}
