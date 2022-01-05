/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.udea.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Poveda
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p ORDER BY p.id DESC")
    , @NamedQuery(name = "Payment.findById", query = "SELECT p FROM Payment p WHERE p.id = :id")
    , @NamedQuery(name = "Payment.findByValue", query = "SELECT p FROM Payment p WHERE p.value = :value")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private long value;
    @JoinColumn(name = "card_id", referencedColumnName = "number")
    @ManyToOne(optional = false)
    private Card cardId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private User clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_date")
    private Date paymentDate;

    public Payment() {
    }

    public Payment(Integer id) {
        this.id = id;
    }

    public Payment(Integer id, long value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Card getCardId() {
        if(cardId == null) {
            this.cardId = new Card();
        }
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public User getClientId() {
        if(clientId == null) {
            this.clientId = new User();
        }
        return clientId;
    }

    public void setClientId(User clientId) {
        this.clientId = clientId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab.udea.entity.Payment[ id=" + id + " ]";
    }
    
}
