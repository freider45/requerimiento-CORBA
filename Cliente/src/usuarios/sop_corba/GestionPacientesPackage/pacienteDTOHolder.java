package usuarios.sop_corba.GestionPacientesPackage;

/**
* usuarios/sop_corba/GestionPacientesPackage/pacienteDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* jueves 7 de diciembre de 2023 12:31:02 AM COT
*/

public final class pacienteDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public usuarios.sop_corba.GestionPacientesPackage.pacienteDTO value = null;

  public pacienteDTOHolder ()
  {
  }

  public pacienteDTOHolder (usuarios.sop_corba.GestionPacientesPackage.pacienteDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = usuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    usuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return usuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.type ();
  }

}
