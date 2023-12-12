
package servidor.controladores;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.SensoresDTO;
import servidor.Repositorios.PacienteRepositoryInt;
import servidor.utilidades.RangosSalud;

public class ControladorGestorPacientesImpl 
        extends UnicastRemoteObject 
        implements ControladorGestorPacientesInt{
    
   private final PacienteRepositoryInt objRepositorio;
 
    
    public ControladorGestorPacientesImpl(PacienteRepositoryInt objRepositorio) throws RemoteException {
        super();//llamando al constructor de la clase padre, 
        //asignando un puerto de escucha al objeto remoto
        this.objRepositorio=objRepositorio;
        //this.objRemotoGestionEquiposNotificacion = objRemotoGestionEquiposNotificacion;
    }

    @Override
    public boolean enviarLecturaSensores(SensoresDTO objSensoresDTO) throws RemoteException{
        System.out.println("\nLecturas de sensores recibidas..\n");
        System.out.println("\nNumero de habitacion del paciente: "+objSensoresDTO.getIdUsuario());
        System.out.println("\nFrecuencia cardiaca: "+objSensoresDTO.getFrecuenciaCardiaca());
        System.out.println("\nFrecuencia respiratoria: "+objSensoresDTO.getFrecuenciaRespiratoria());
        System.out.println("\nPresión arterial: "+objSensoresDTO.getTensionArterialSistolica()+"/"+
                objSensoresDTO.getTensionArterialDiastolica());
        System.out.println("\nSaturación de oxígeno: "+objSensoresDTO.getSaturacionOxigeno());
        System.out.println("\nTempertatura: "+objSensoresDTO.getTemperatura());
         RangosSalud.tomarAccionesPuntuacion(objSensoresDTO);
        return true;
    }

}
