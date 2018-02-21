package com.storeentity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-21T14:28:46")
@StaticMetamodel(Salesrecord.class)
public class Salesrecord_ { 

    public static volatile SingularAttribute<Salesrecord, Float> paymentamount;
    public static volatile SingularAttribute<Salesrecord, Date> transactiondate;
    public static volatile SingularAttribute<Salesrecord, String> paymentccnumber;
    public static volatile SingularAttribute<Salesrecord, String> transactionrecord;
    public static volatile SingularAttribute<Salesrecord, Float> paymenttotal;
    public static volatile SingularAttribute<Salesrecord, Integer> id;
    public static volatile SingularAttribute<Salesrecord, String> customername;
    public static volatile SingularAttribute<Salesrecord, Date> transactiontime;
    public static volatile SingularAttribute<Salesrecord, Float> paymentchange;
    public static volatile SingularAttribute<Salesrecord, String> paymenttype;

}