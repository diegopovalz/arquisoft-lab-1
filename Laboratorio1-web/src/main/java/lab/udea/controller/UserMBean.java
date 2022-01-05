/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.udea.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import lab.udea.ejb.CardManagerLocal;
import lab.udea.ejb.PaymentManagerLocal;
import lab.udea.ejb.UserManagerLocal;
import lab.udea.entity.Payment;

/**
 *
 * @author Poveda
 */
public class UserMBean implements Serializable {

    @EJB
    private PaymentManagerLocal paymentManager;

    @EJB
    private CardManagerLocal cardManager;

    @EJB
    private UserManagerLocal userManager;

    private Payment payment;
    private List<Payment> payments;

    public UserMBean() {
    }

    public Payment getPayment() {
        if(this.payment == null) {
            this.payment = new Payment();
        }
        return this.payment;
    }

    /*@PostConstruct
    public void init() {
        this.payment = new Payment();
    }*/

    public List<Payment> getPayments() {
        if (payments == null || payments.isEmpty()) {
            refresh();
        }
        return payments;
    }
    
    public void refresh() {
        this.payments = paymentManager.getAllPayments();
    }

    public String getCardType() {
        //this.cardType = "";
        Integer number = Integer.parseInt((this.payment.getCardId().getNumber() + "").substring(0, 5));
        if (number >= 11111 && number <= 22222) {
            return "American Express";
        } else if (number >= 33334 && number <= 44444) {
            return "Diners";
        } else if (number >= 55555 && number <= 66666) {
            return "Visa";
        } else if (number >= 77777 && number <= 88888) {
            return "Mastercard";
        }
        return "";
    }

    public String newPayment() {
        this.payment = new Payment();
        /*this.payment.setClientId(new User());
        this.payment.setCardId(new Card());*/
        return "NEW";
    }

    public String continuePayment() {
        return "RESUME";
    }

    public String confirm() {
        if (!this.userManager.userExists(this.payment.getClientId().getId())) {
            this.userManager.saveUser(this.payment.getClientId());
        }
        if (!this.cardManager.cardExists(this.payment.getCardId().getNumber())) {
            this.payment.getCardId().setClientId(this.payment.getClientId());
            this.cardManager.saveCard(this.payment.getCardId());
        }
        this.payment.setPaymentDate(new Date());
        this.paymentManager.savePayment(this.payment);
        refresh();
        return "LIST";
    }

    public String goBack() {
        return "DETAILS";
    }
}
