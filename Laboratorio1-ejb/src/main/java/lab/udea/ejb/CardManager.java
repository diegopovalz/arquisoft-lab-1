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
import lab.udea.entity.Card;

/**
 *
 * @author Poveda
 */
@Stateless
public class CardManager implements CardManagerLocal {

    @PersistenceContext(unitName = "lab.udea_Laboratorio1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Card> getUserCards(Integer userId) {
        return em.createNamedQuery("Card.findByClientId")
                .setParameter("clientId", userId)
                .getResultList();
    }

    @Override
    public boolean cardExists(String number) {
        List<Card> cards = em.createNamedQuery("Card.findByNumber").setParameter("number", number).getResultList();
        return cards != null && !cards.isEmpty();
    }

    @Override
    public void saveCard(Card card) {
        em.merge(card);
    }

}
