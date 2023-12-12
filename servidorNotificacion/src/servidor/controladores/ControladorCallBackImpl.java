
package servidor.controladores;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import servidor.DTO.Notificacion;

/**
 *
 * @author IngSis
 */
public class ControladorCallBackImpl extends UnicastRemoteObject implements ControladorCallBackInt{
   public ControladorCallBackImpl() throws RemoteException{
       super();
   }

    @Override
    public boolean enviarNotificacion(Notificacion objNotificacion) throws RemoteException {
        System.out.println("");
        System.out.println("*********************Alerta Generada****************");
        System.out.println("No de identificacion: "+objNotificacion.getObjPaciente().getIdentificacion());
        System.out.println("Nombres y apellidos: "+objNotificacion.getObjPaciente().getNombres()
                           +" "+objNotificacion.getObjPaciente().getApellidos());
        System.out.println("Edad: "+objNotificacion.getObjPaciente().getEdad());
        System.out.println("Fecha y hora de la alerta: "+objNotificacion.getFechaHora());
        System.out.println("-------------------------------------------------------");
        System.out.println("   Indicadores que generaron a alerta   ");
        System.out.println("-------------------------------------------------------");
        System.out.println("Nombre del Indicador        | Valor |");
        System.out.println("-------------------------------------------------------");
        if(objNotificacion.getObjSensor().getFrecuenciaCardiaca()>=1)
            System.out.println("Frecuencia Cardiaca: "+objNotificacion.getObjSensor().getFrecuenciaCardiaca());
        
        if(objNotificacion.getObjSensor().getTensionArterialSistolica()>=1)
            System.out.println("Presion arterial Sistolica: "+objNotificacion.getObjSensor().getTensionArterialSistolica());
        
        if(objNotificacion.getObjSensor().getTensionArterialDiastolica()>=1)
            System.out.println("Presion arterial Diastolica: "+objNotificacion.getObjSensor().getTensionArterialDiastolica());
        
        if(objNotificacion.getObjSensor().getFrecuenciaRespiratoria()>=1)
            System.out.println("Frecuencia Respiratorio: "+objNotificacion.getObjSensor().getFrecuenciaRespiratoria());
        
        if(objNotificacion.getObjSensor().getSaturacionOxigeno()>=1)
            System.out.println("Saturacion de Oxigeno: "+objNotificacion.getObjSensor().getSaturacionOxigeno());
        
        if(objNotificacion.getObjSensor().getTemperatura()>=1)
            System.out.println("Temperatura: "+objNotificacion.getObjSensor().getTemperatura());
        
        
        System.out.println("");
        System.out.println("\t"+objNotificacion.getMensaje());
        System.out.println("");
        System.out.println("ultimas "+objNotificacion.getCantidadAlertas()+" alertas paciente");
        System.out.println("");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|Fecha de la alerta | Hora de la alerta | Puntuacion|");
        System.out.println("|--------------------------------------------------------------|");
        for(int indice =0;indice<objNotificacion.getCantidadAlertas();indice++){
            
            System.out.print("|"+objNotificacion.getAlertas().get(indice).getFechaHora());
            System.out.println("|"+objNotificacion.getAlertas().get(indice).getPuntuacion());
        }
        return true;
    }
   
           
}
