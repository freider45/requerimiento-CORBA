package servidorDeUsuarios.sop_corba;

/**
* servidorDeUsuarios/sop_corba/GestionPacientesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* viernes 8 de diciembre de 2023 12:25:43 AM COT
*/

public final class GestionPacientesHolder implements org.omg.CORBA.portable.Streamable
{
  public servidorDeUsuarios.sop_corba.GestionPacientes value = null;

  public GestionPacientesHolder ()
  {
  }

  public GestionPacientesHolder (servidorDeUsuarios.sop_corba.GestionPacientes initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = servidorDeUsuarios.sop_corba.GestionPacientesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    servidorDeUsuarios.sop_corba.GestionPacientesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return servidorDeUsuarios.sop_corba.GestionPacientesHelper.type ();
  }

}
