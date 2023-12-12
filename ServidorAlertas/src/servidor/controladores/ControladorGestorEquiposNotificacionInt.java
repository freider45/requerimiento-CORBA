
package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Hereda de la clase Remote, lo cual le convierte en interfaz remota
public interface ControladorGestorEquiposNotificacionInt extends Remote{
    public boolean registrarReferenciaRemota(ControladorCallBackInt referencia) throws RemoteException;
}
