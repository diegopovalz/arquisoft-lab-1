/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.udea.ejb;

import java.util.List;
import javax.ejb.Local;
import lab.udea.entity.Card;

/**
 *
 * @author Poveda
 */
@Local
public interface CardManagerLocal {

    List<Card> getUserCards(Integer userId);

    boolean cardExists(String number);

    void saveCard(Card card);
    
}
