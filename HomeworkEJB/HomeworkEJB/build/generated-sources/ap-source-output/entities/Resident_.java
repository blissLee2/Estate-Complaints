package entities;

import entities.Complaint;
import entities.Estate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-12T15:00:34")
@StaticMetamodel(Resident.class)
public class Resident_ extends User_ {

    public static volatile ListAttribute<Resident, Complaint> complaints;
    public static volatile SingularAttribute<Resident, Estate> estate;
    public static volatile SingularAttribute<Resident, Integer> unitNumber;

}