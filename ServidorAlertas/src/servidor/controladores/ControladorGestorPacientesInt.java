

package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.SensoresDTO;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorPacientesInt extends Remote
{
    //Definicion del segundo método remoto
    public boolean enviarLecturaSensores(SensoresDTO objSensores) throws RemoteException;
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException  
}


