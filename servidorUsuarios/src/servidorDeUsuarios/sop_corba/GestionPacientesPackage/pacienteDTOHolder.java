package servidorDeUsuarios.sop_corba.GestionPacientesPackage;

/**
* servidorDeUsuarios/sop_corba/GestionPacientesPackage/pacienteDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* martes 12 de diciembre de 2023 02:56:10 AM COT
*/

public final class pacienteDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO value = null;

  public pacienteDTOHolder ()
  {
  }

  public pacienteDTOHolder (servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.type ();
  }

}
