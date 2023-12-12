
package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.Notificacion;


public interface ControladorCallBackInt extends Remote {
    public boolean enviarNotificacion(Notificacion objNotificacion)throws RemoteException;
}
