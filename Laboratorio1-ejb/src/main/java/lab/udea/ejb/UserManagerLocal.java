/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.udea.ejb;

import java.util.List;
import javax.ejb.Local;
import lab.udea.entity.User;

/**
 *
 * @author Poveda
 */
@Local
public interface UserManagerLocal {

    List<User> getAllUsers();

    boolean userExists(Integer id);

    void saveUser(User user);
    
}
