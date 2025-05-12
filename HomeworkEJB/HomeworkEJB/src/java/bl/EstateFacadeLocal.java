/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entities.Estate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author General_user
 */
@Local
public interface EstateFacadeLocal {

    void create(Estate estate);

    void edit(Estate estate);

    void remove(Estate estate);

    Estate find(Object id);

    List<Estate> findAll();

    List<Estate> findRange(int[] range);

    int count();
    
}
