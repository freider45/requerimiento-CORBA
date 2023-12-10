
package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.Notificacion;

//Hereda de la clase Remote, lo cual le convierte en interfaz remota
public interface ControladorGestorNotificacionInt extends Remote{
     public boolean enviarNotificacion(Notificacion objNotificacion) throws RemoteException;
}
