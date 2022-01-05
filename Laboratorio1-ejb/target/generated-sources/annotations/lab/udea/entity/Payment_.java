package lab.udea.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lab.udea.entity.Card;
import lab.udea.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-28T15:24:16")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, User> clientId;
    public static volatile SingularAttribute<Payment, Card> cardId;
    public static volatile SingularAttribute<Payment, Integer> id;
    public static volatile SingularAttribute<Payment, Long> value;

}