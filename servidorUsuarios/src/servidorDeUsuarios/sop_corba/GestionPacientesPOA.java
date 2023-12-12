package servidorDeUsuarios.sop_corba;


/**
* servidorDeUsuarios/sop_corba/GestionPacientesPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* martes 12 de diciembre de 2023 02:56:10 AM COT
*/

public abstract class GestionPacientesPOA extends org.omg.PortableServer.Servant
 implements servidorDeUsuarios.sop_corba.GestionPacientesOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registrarPaciente", new java.lang.Integer (0));
    _methods.put ("buscarPaciente", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sop_corba/GestionPacientes/registrarPaciente
       {
         servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO objPaciente = servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.read (in);
         boolean $result = false;
         $result = this.registrarPaciente (objPaciente);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // sop_corba/GestionPacientes/buscarPaciente
       {
         int numeroHabitacion = in.read_long ();
         servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO $result = null;
         $result = this.buscarPaciente (numeroHabitacion);
         out = $rh.createReply();
         servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionPacientes:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public GestionPacientes _this() 
  {
    return GestionPacientesHelper.narrow(
    super._this_object());
  }

  public GestionPacientes _this(org.omg.CORBA.ORB orb) 
  {
    return GestionPacientesHelper.narrow(
    super._this_object(orb));
  }


} // class GestionPacientesPOA
