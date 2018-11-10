package udem.edu.co.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import udem.edu.co.entities.Rol;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-11-07T16:42:08")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Rol> idrol;
    public static volatile SingularAttribute<Users, Integer> idusers;
    public static volatile SingularAttribute<Users, String> username;

}