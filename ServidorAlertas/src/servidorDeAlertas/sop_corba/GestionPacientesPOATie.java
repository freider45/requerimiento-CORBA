package servidorDeAlertas.sop_corba;


/**
* servidorDeAlertas/sop_corba/GestionPacientesPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from alertas.idl
* viernes 8 de diciembre de 2023 12:29:24 AM COT
*/

public class GestionPacientesPOATie extends GestionPacientesPOA
{

  // Constructors

  public GestionPacientesPOATie ( servidorDeAlertas.sop_corba.GestionPacientesOperations delegate ) {
      this._impl = delegate;
  }
  public GestionPacientesPOATie ( servidorDeAlertas.sop_corba.GestionPacientesOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public servidorDeAlertas.sop_corba.GestionPacientesOperations _delegate() {
      return this._impl;
  }
  public void _delegate (servidorDeAlertas.sop_corba.GestionPacientesOperations delegate ) {
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
  public servidorDeAlertas.sop_corba.GestionPacientesPackage.pacienteDTO buscarPaciente (int numeroHabitacion)
  {
    return _impl.buscarPaciente(numeroHabitacion);
  } // buscarPaciente

  private servidorDeAlertas.sop_corba.GestionPacientesOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionPacientesPOATie