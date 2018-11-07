package udem.edu.co.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-11-07T09:43:43")
@StaticMetamodel(Equipment.class)
public class Equipment_ { 

    public static volatile SingularAttribute<Equipment, Integer> idequipment;
    public static volatile SingularAttribute<Equipment, String> name;
    public static volatile SingularAttribute<Equipment, String> description;
    public static volatile SingularAttribute<Equipment, String> brand;
    public static volatile SingularAttribute<Equipment, Date> dateBuy;
    public static volatile SingularAttribute<Equipment, String> status;

}