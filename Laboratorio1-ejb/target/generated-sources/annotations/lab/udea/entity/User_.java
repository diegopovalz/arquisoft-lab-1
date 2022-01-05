package lab.udea.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lab.udea.entity.Card;
import lab.udea.entity.Payment;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-28T15:24:16")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> clientName;
    public static volatile SingularAttribute<User, Payment> payment;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, Card> cardCollection;
    public static volatile SingularAttribute<User, String> email;

}