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
import lab.udea.entity.Payment;

/**
 *
 * @author Poveda
 */
@Stateless
public class PaymentManager implements PaymentManagerLocal {

    @PersistenceContext(unitName = "lab.udea_Laboratorio1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Payment> getAllPayments() {
        return em.createNamedQuery("Payment.findAll").getResultList();
    }
    
    @Override
    public void savePayment(Payment payment) {
        em.merge(payment);
    }
}
