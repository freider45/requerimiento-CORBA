package usuarios.sop_corba;


/**
* usuarios/sop_corba/GestionPacientesPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* jueves 7 de diciembre de 2023 12:31:02 AM COT
*/

public class GestionPacientesPOATie extends GestionPacientesPOA
{

  // Constructors

  public GestionPacientesPOATie ( usuarios.sop_corba.GestionPacientesOperations delegate ) {
      this._impl = delegate;
  }
  public GestionPacientesPOATie ( usuarios.sop_corba.GestionPacientesOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public usuarios.sop_corba.GestionPacientesOperations _delegate() {
      return this._impl;
  }
  public void _delegate (usuarios.sop_corba.GestionPacientesOperations delegate ) {
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
  public boolean registrarPaciente (usuarios.sop_corba.GestionPacientesPackage.pacienteDTO objPaciente)
  {
    return _impl.registrarPaciente(objPaciente);
  } // registrarPaciente

  private usuarios.sop_corba.GestionPacientesOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionPacientesPOATie
