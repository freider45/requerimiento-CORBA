
package servidor.servicios;

import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import servidor.Repositorios.PacienteRepositorioImpl;
import servidor.controladores.ControladorGestorNotificacionInt;
import servidor.controladores.ControladorGestorPacientesImpl;
import servidor.controladores.ControladorGestorPacientesInt;
import servidor.utilidades.RangosSalud;
import servidorDeAlertas.sop_corba.GestionPacientesHelper;
import servidorDeAlertas.sop_corba.GestionPacientesOperations;

public class ServidorDeObjetos
{
    private static ControladorGestorNotificacionInt objRemoto;
    static GestionPacientesOperations ref;

    public static void main(String args[]) throws RemoteException
    {        
        
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
            vec[1] = direccionIpRMIRegistry;
            vec[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vec[3] = UtilidadesConsola.leerCadena();
            System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry ");
            numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
            
            // se crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objPacientes";
            ref = GestionPacientesHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);
            
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
        
        RangosSalud notificacion = new RangosSalud(ref);
        
        
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
