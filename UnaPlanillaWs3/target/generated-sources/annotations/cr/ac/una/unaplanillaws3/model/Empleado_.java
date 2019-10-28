package cr.ac.una.unaplanillaws3.model;

import cr.ac.una.unaplanillaws3.model.Tipoplanilla;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-28T16:06:52")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> empClave;
    public static volatile SingularAttribute<Empleado, Long> empId;
    public static volatile SingularAttribute<Empleado, String> empPapellido;
    public static volatile SingularAttribute<Empleado, String> empUsuario;
    public static volatile SingularAttribute<Empleado, String> empAdministrador;
    public static volatile SingularAttribute<Empleado, String> empEstado;
    public static volatile ListAttribute<Empleado, Tipoplanilla> tipoplanillaList;
    public static volatile SingularAttribute<Empleado, String> empNombre;
    public static volatile SingularAttribute<Empleado, Date> empFingreso;
    public static volatile SingularAttribute<Empleado, String> empSapellido;
    public static volatile SingularAttribute<Empleado, String> empCedula;
    public static volatile SingularAttribute<Empleado, Date> empFsalida;
    public static volatile SingularAttribute<Empleado, Long> empVersion;
    public static volatile SingularAttribute<Empleado, String> empGenero;
    public static volatile SingularAttribute<Empleado, String> empCorreo;

}