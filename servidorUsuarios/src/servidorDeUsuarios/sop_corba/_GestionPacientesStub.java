package servidorDeUsuarios.sop_corba;


/**
* servidorDeUsuarios/sop_corba/_GestionPacientesStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from usuarios.idl
* martes 12 de diciembre de 2023 02:56:10 AM COT
*/

public class _GestionPacientesStub extends org.omg.CORBA.portable.ObjectImpl implements servidorDeUsuarios.sop_corba.GestionPacientes
{

  public boolean registrarPaciente (servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO objPaciente)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registrarPaciente", true);
                servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.write ($out, objPaciente);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return registrarPaciente (objPaciente        );
            } finally {
                _releaseReply ($in);
            }
  } // registrarPaciente

  public servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO buscarPaciente (int numeroHabitacion)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("buscarPaciente", true);
                $out.write_long (numeroHabitacion);
                $in = _invoke ($out);
                servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO $result = servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTOHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return buscarPaciente (numeroHabitacion        );
            } finally {
                _releaseReply ($in);
            }
  } // buscarPaciente

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionPacientes:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GestionPacientesStub
