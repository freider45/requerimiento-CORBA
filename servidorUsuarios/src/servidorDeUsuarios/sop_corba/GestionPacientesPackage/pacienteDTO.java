package servidorDeUsuarios.sop_corba.GestionPacientesPackage;


/**
* servidorDeUsuarios/sop_corba/GestionPacientesPackage/pacienteDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* martes 12 de diciembre de 2023 02:56:10 AM COT
*/

public final class pacienteDTO implements org.omg.CORBA.portable.IDLEntity
{
  public String nombre = null;
  public String apellido = null;
  public int numeroHabitacion = (int)0;
  public float edad = (float)0;

  public pacienteDTO ()
  {
  } // ctor

  public pacienteDTO (String _nombre, String _apellido, int _numeroHabitacion, float _edad)
  {
    nombre = _nombre;
    apellido = _apellido;
    numeroHabitacion = _numeroHabitacion;
    edad = _edad;
  } // ctor

} // class pacienteDTO
