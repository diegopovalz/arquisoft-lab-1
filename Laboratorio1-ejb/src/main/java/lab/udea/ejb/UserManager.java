/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.udea.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lab.udea.entity.User;

/**
 *
 * @author Poveda
 */
@Stateless
public class UserManager implements UserManagerLocal {

    @PersistenceContext(unitName = "lab.udea_Laboratorio1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public boolean userExists(Integer id) {
        List<User> users = em.createNamedQuery("User.findById").setParameter("id", id).getResultList();
        return users != null && !users.isEmpty();
    }

    @Override
    public void saveUser(User user) {
        em.merge(user);
    }
}
