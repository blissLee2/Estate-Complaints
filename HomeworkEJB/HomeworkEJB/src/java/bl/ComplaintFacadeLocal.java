/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entities.Complaint;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author General_user
 */
@Local
public interface ComplaintFacadeLocal {

    void create(Complaint complaint);

    void edit(Complaint complaint);

    void remove(Complaint complaint);

    Complaint find(Object id);

    List<Complaint> findAll();

    List<Complaint> findRange(int[] range);

    int count();
    
}
