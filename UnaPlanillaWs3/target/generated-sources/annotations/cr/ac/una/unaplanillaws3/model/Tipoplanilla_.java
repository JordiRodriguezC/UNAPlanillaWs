package cr.ac.una.unaplanillaws3.model;

import cr.ac.una.unaplanillaws3.model.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-28T16:06:52")

@StaticMetamodel(Tipoplanilla.class)
public class Tipoplanilla_ { 

    public static volatile SingularAttribute<Tipoplanilla, Long> tplaId;
    public static volatile SingularAttribute<Tipoplanilla, Integer> tplaAnoultpla;
    public static volatile SingularAttribute<Tipoplanilla, Long> tplaVersion;
    public static volatile SingularAttribute<Tipoplanilla, Integer> tplaPlaxmes;
    public static volatile ListAttribute<Tipoplanilla, Empleado> empleadoList;
    public static volatile SingularAttribute<Tipoplanilla, String> tplaCodigo;
    public static volatile SingularAttribute<Tipoplanilla, String> tplaEstado;
    public static volatile SingularAttribute<Tipoplanilla, Integer> tplaMesultpla;
    public static volatile SingularAttribute<Tipoplanilla, Integer> tplaNumultpla;
    public static volatile SingularAttribute<Tipoplanilla, String> tplaDescripcion;

}