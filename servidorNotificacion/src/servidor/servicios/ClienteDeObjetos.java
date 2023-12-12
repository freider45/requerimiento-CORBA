
package servidor.servicios;

import static servidor.utilidades.UtilidadesConsola.leerCadena;
import static servidor.utilidades.UtilidadesConsola.leerEntero;
import servidor.utilidades.UtilidadesRegistroC;
import servidor.controladores.ControladorCallBackImpl;
import java.rmi.RemoteException;
import servidor.controladores.ControladorGestorEquiposNotificacionInt;
/**
 *
 * @author brayan
 */
public class ClienteDeObjetos {

    public static void main(String[] args) throws RemoteException {
      int numPuertoRMIRegistry = 0;
      String direccionIpRMIRegistry = "";     
      
      
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry =leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = leerEntero(); 
        
         ControladorCallBackImpl objRemoto= new ControladorCallBackImpl();
         ControladorGestorEquiposNotificacionInt objRemotoServidor=
                (ControladorGestorEquiposNotificacionInt)
                UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorNotificacion");
        objRemotoServidor.registrarReferenciaRemota(objRemoto);
        System.out.println("Esperando notificaciones");
    }
}