package servidorDeUsuarios.sop_corba;


/**
* servidorDeUsuarios/sop_corba/GestionPacientesPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* martes 12 de diciembre de 2023 02:56:10 AM COT
*/

public class GestionPacientesPOATie extends GestionPacientesPOA
{

  // Constructors

  public GestionPacientesPOATie ( servidorDeUsuarios.sop_corba.GestionPacientesOperations delegate ) {
      this._impl = delegate;
  }
  public GestionPacientesPOATie ( servidorDeUsuarios.sop_corba.GestionPacientesOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public servidorDeUsuarios.sop_corba.GestionPacientesOperations _delegate() {
      return this._impl;
  }
  public void _delegate (servidorDeUsuarios.sop_corba.GestionPacientesOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public boolean registrarPaciente (servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO objPaciente)
  {
    return _impl.registrarPaciente(objPaciente);
  } // registrarPaciente

  public servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO buscarPaciente (int numeroHabitacion)
  {
    return _impl.buscarPaciente(numeroHabitacion);
  } // buscarPaciente

  private servidorDeUsuarios.sop_corba.GestionPacientesOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionPacientesPOATie
