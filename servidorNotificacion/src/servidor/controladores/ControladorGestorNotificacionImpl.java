package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Queue;
import servidor.DTO.Notificacion;
import servidor.repositorios.NotificacionRepositoryInt;

public class ControladorGestorNotificacionImpl extends
        UnicastRemoteObject implements ControladorGestorNotificacionInt {

    private NotificacionRepositoryInt repositorio;
    private Queue<Notificacion> colaAlertas;

    public ControladorGestorNotificacionImpl(NotificacionRepositoryInt repositorio) throws RemoteException {
        super();
        this.repositorio = repositorio;
        this.colaAlertas = new LinkedList<>();
    }

    @Override
    public boolean enviarNotificacion(Notificacion notificacion) throws RemoteException {
        System.out.println("\n\n\n\n\t\t         ALERTA GENERADA \n");
        System.out.printf("\n  No de habitación: " + notificacion.getObjSensor().getPaciente().getNoHabitacion());
        System.out.printf("\n  Nombres y apellidos: " + notificacion.getObjSensor().getPaciente().getNombres(),
                notificacion.getObjSensor().getPaciente().getApellidos());
        System.out.printf("\n  Edad: años" + notificacion.getObjSensor().getPaciente().getEdad());
        System.out.printf("\n  Hora  y fecha de la alerta: " + notificacion.getFechaHora());

        System.out.println("\n\t\tIndicadores que generaron la alerta\n");
        if (notificacion.getObjSensor().getFrecuenciaCardiaca() != -1) {
            System.out.println("\nFrecuencia cardiaca: " + notificacion.getObjSensor().getFrecuenciaCardiaca());
        }
        if (notificacion.getObjSensor().getFrecuenciaRespiratoria() != -1) {
            System.out.println("\nFrecuencia respiratoria: " + notificacion.getObjSensor().getFrecuenciaRespiratoria());
        }
        if (notificacion.getObjSensor().getTensionArterialSistolica() != -1) {
            System.out.println("\nPresión arterial sistolica " + notificacion.getObjSensor().getTensionArterialSistolica());
        }

        if (notificacion.getObjSensor().getTensionArterialDiastolica() != -1) {
            System.out.println("\nPresión arterial diastolica " + notificacion.getObjSensor().getTensionArterialDiastolica());

        }
        if (notificacion.getObjSensor().getTemperatura() != -1) {
            System.out.println("\nTemperatura " + notificacion.getObjSensor().getTemperatura());

        }
        if (notificacion.getObjSensor().getSaturacionOxigeno() != -1) {
            System.out.println("\nSaturacion oxigeno " + notificacion.getObjSensor().getSaturacionOxigeno());

        }

        System.out.printf("\n\t", notificacion.getMensaje() + "\n");
        agregarAlerta(notificacion);

        // Muestra las últimas 5 alertas
        mostrarUltimasAlertas();
        return true;
    }

    private void agregarAlerta(Notificacion notificacion) {
        // Añade la alerta a la cola
        colaAlertas.offer(notificacion);

        // Si la cola supera las 5 alertas, elimina la más antigua
        while (colaAlertas.size() > 5) {
            colaAlertas.poll();
        }
    }

    private void mostrarUltimasAlertas() {
        System.out.println("\n\t\tÚltimas 5 alertas\n");
        for (Notificacion alerta : colaAlertas) {
            System.out.printf("Hora y fecha de la alerta: %s%n", alerta.getFechaHora());
            System.out.printf("Puntuacion %n", alerta.getPuntuacion());

        }
    }

}
