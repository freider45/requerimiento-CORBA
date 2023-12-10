
package servidor.servicios;

import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.Repositorios.PacienteRepositorioImpl;
import servidor.controladores.ControladorGestorNotificacionInt;
import servidor.controladores.ControladorGestorPacientesImpl;

public class ServidorDeObjetos
{
    private static ControladorGestorNotificacionInt objRemoto;

    public static void main(String args[]) throws RemoteException
    {        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
                   
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiRegistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
        
        //Obtener el objeto remoto
        //objRemoto =  (ControladorGestorNotificacionInt) UtilidadesRegistroS.obtenerObjRemoto(direccionIpRMIRegistry,3000, "idGestorPacientes"  );
        //RangosSalud notificacion = new RangosSalud(objRemoto);
        //Crear el repositorio
        PacienteRepositorioImpl objPacienteRepositoryImpl=new PacienteRepositorioImpl();

        //Crear el objeto remoto
        ControladorGestorPacientesImpl objRemotoPacientes= new ControladorGestorPacientesImpl(objPacienteRepositoryImpl);
    
        try
        {
            //se lanza el ns si no existe
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto( objRemotoPacientes, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorPacientes");            
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }

}
