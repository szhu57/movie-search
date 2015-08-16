package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T22:16:28")
@StaticMetamodel(Moviedb.class)
public class Moviedb_ { 

    public static volatile SingularAttribute<Moviedb, String> title;
    public static volatile SingularAttribute<Moviedb, String> starts;
    public static volatile SingularAttribute<Moviedb, String> description;
    public static volatile SingularAttribute<Moviedb, String> coverurl;
    public static volatile SingularAttribute<Moviedb, Double> rating;
    public static volatile SingularAttribute<Moviedb, String> type;
    public static volatile SingularAttribute<Moviedb, String> director;
    public static volatile SingularAttribute<Moviedb, Integer> movieid;

}