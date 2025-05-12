package entities;

import entities.Estate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-12T15:00:34")
@StaticMetamodel(Admin.class)
public class Admin_ extends User_ {

    public static volatile SingularAttribute<Admin, Estate> estate;
    public static volatile ListAttribute<Admin, String> announcements;

}