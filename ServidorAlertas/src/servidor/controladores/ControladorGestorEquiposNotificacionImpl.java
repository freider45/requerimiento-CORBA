
package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import servidor.DTO.Notificacion;

public class ControladorGestorEquiposNotificacionImpl extends UnicastRemoteObject implements ControladorGestorEquiposNotificacionInt{
    
    //La clase UnicastR.. asigna un puerto al objRemoto
    private final LinkedList<ControladorCallBackInt> listaReferencia;
    public ControladorGestorEquiposNotificacionImpl() throws RemoteException{
        super();
        this.listaReferencia = new LinkedList();
    }
    
    @Override
    public boolean registrarReferenciaRemota(ControladorCallBackInt referencia) throws RemoteException {
        return this.listaReferencia.add(referencia);
    }
    
    public void notificarEquiposSobreNuevaAlerta(Notificacion objNotificacion){
        
        this.listaReferencia.forEach(
                obj->{
            try {
                obj.enviarNotificacion(objNotificacion);
            }catch (RemoteException ex){
                System.out.println("Error al notificar al administrador");
            }   
        }
        );
    }
}
