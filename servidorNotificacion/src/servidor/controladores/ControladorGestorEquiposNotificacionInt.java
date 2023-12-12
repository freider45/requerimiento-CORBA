package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author fre90
 */
public interface ControladorGestorEquiposNotificacionInt extends Remote{
     public boolean registrarReferenciaRemota(ControladorCallBackInt referencia)throws RemoteException;
}
