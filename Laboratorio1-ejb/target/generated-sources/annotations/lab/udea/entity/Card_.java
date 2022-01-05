package lab.udea.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lab.udea.entity.Payment;
import lab.udea.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-28T15:24:16")
@StaticMetamodel(Card.class)
public class Card_ { 

    public static volatile SingularAttribute<Card, Integer> number;
    public static volatile SingularAttribute<Card, String> cvv;
    public static volatile SingularAttribute<Card, User> clientId;
    public static volatile SingularAttribute<Card, Date> expiration;
    public static volatile CollectionAttribute<Card, Payment> paymentCollection;

}