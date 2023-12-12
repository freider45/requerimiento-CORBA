package cliente.servicios;

import cliente.utilidades.UtilidadesConsola;
import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import servidor.controladores.ControladorGestorPacientesInt;
import usuarios.sop_corba.GestionPacientesHelper;
import usuarios.sop_corba.GestionPacientesOperations;

public class ClienteDeObjetos
{
    static GestionPacientesOperations ref;
    private static ControladorGestorPacientesInt objRemoto;

    public static void main(String[] args)
    {   
        try {
            String[] vec = new String[4];
            vec[0] = "-ORBInitialPort";
            System.out.println("Ingrese la dirección IP donde escucha el n_s");
            vec[1] = UtilidadesConsola.leerCadena("opcion");
            vec[2] = "-ORBInitialPort";
            System.out.println("Ingrese el puerto donde escucha el n_s");
            vec[3] = UtilidadesConsola.leerCadena("opcion");
            
            System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
            int numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero(); 
            
            objRemoto =  (ControladorGestorPacientesInt) UtilidadesRegistroC.obtenerObjRemoto(vec[1],numPuertoRMIRegistry, "objServicioGestionPacientes"  );

            // se crea e inicia el ORB
            ORB orb = ORB.init(vec, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***
            String name = "objPacientes";
            ref = GestionPacientesHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);
                        
            Menu objMenu= new Menu(ref, objRemoto);
            objMenu.ejecutarMenuPrincipal();

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}

