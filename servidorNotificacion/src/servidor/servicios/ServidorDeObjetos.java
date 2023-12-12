/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor.servicios;
import java.rmi.RemoteException;
import java.rmi.Remote;
import servidor.controladores.ControladorGestorNotificacionImpl;
import servidor.repositorios.NotificacionRepositoryImpl;
import servidor.utilidades.UtilidadesRegistroS;
/**
 *
 * @author IngSis
 */
public class ServidorDeObjetos {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";        

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = servidor.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = servidor.utilidades.UtilidadesConsola.leerEntero(); 
        
        //Crear el repositorio
        NotificacionRepositoryImpl objNotificacionRepositoryImpl = new NotificacionRepositoryImpl();
        //Crear el objeto remoto
        ControladorGestorNotificacionImpl objRemoto= new ControladorGestorNotificacionImpl(objNotificacionRepositoryImpl);
        try
        {
            //se lanza el ns si no existe
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto((Remote) objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorPacientes");            
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
    
}
