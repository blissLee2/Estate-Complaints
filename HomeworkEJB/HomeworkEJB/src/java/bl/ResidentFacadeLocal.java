/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entities.Resident;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author General_user
 */
@Local
public interface ResidentFacadeLocal {

    void create(Resident resident);

    void edit(Resident resident);

    void remove(Resident resident);

    Resident find(Object id);

    List<Resident> findAll();
   
    List<Resident> findRange(int[] range);
    List<Resident> findInEst(String estateName);
    int count();
    
}
