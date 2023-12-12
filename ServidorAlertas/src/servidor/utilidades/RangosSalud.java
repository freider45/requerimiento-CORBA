
package servidor.utilidades;

import servidor.DTO.SensoresDTO;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import servidor.DTO.Notificacion;
import servidor.DTO.Paciente;
import servidor.Repositorios.PacienteRepositorioImpl;
import servidor.controladores.ControladorGestorEquiposNotificacionImpl;
import servidorDeAlertas.sop_corba.GestionPacientesOperations;
import servidorDeAlertas.sop_corba.GestionPacientesPackage.pacienteDTO;

/**
 *
 * @author Jorge
 */
public class RangosSalud {

    static  ControladorGestorEquiposNotificacionImpl objRemoto;
    static  SensoresDTO objSensoresAlerta = new SensoresDTO();
    static  PacienteRepositorioImpl objPacienteRepositoryImpl=new PacienteRepositorioImpl();
    static  GestionPacientesOperations ref;

    public RangosSalud(GestionPacientesOperations ref, ControladorGestorEquiposNotificacionImpl objRemoto) {
        this.objRemoto = objRemoto;
        this.ref = ref;
    }

    public static int determinarRangoNormalFrecuenciaCardiaca(float edad, int frecuencia) {
        if ((edad >= 0.0 && edad <= 0.1154 && frecuencia >= 120 && frecuencia <= 130)
                || (edad >= 0.1346 && edad <= 1.0 && frecuencia >= 100 && frecuencia <= 130)
                || (edad > 1.0 && edad <= 2.0 && frecuencia >= 100 && frecuencia <= 120)
                || (edad > 2.0 && edad <= 6.0 && frecuencia >= 80 && frecuencia <= 120)
                || (edad > 6.0 && edad <= 13.0 && frecuencia >= 80 && frecuencia <= 100)
                || (edad > 13.0 && edad <= 16.0 && frecuencia >= 70 && frecuencia <= 80)
                || (edad > 16.0 && frecuencia >= 60 && frecuencia <= 80)) {
            objSensoresAlerta.setFrecuenciaCardiaca(-1);

            return 0;
        }
        objSensoresAlerta.setFrecuenciaCardiaca(frecuencia);
        return 1;
    }

    public static int determinarRangoNormalPresionArterialSistolica(float edad, int presion) {
        if ((edad >= 0.0 && edad <= 0.1154 && presion >= 70 && presion <= 100)
                || (edad >= 0.1346 && edad <= 1.0 && presion >= 84 && presion <= 106)
                || (edad > 1.0 && edad <= 2.0 && presion >= 98 && presion <= 106)
                || (edad > 2.0 && edad <= 6.0 && presion >= 99 && presion <= 112)
                || (edad > 6.0 && edad <= 13.0 && presion >= 104 && presion <= 124)
                || (edad > 13.0 && edad <= 16.0 && presion >= 118 && presion <= 132)
                || (edad > 16.0 && presion >= 110 && presion <= 140)) {
            objSensoresAlerta.setTensionArterialSistolica(-1);

            return 0;
        }
        objSensoresAlerta.setTensionArterialSistolica(presion);

        return 1;
    }

    public static int determinarRangoNormalPresionArterialDiastolica(float edad, int presion) {
        if ((edad >= 0.0 && edad <= 0.1154 && presion >= 50 && presion <= 68)
                || (edad >= 0.1346 && edad <= 1.0 && presion >= 56 && presion <= 70)
                || (edad > 1.0 && edad <= 2.0 && presion >= 58 && presion <= 70)
                || (edad > 2.0 && edad <= 6.0 && presion >= 64 && presion <= 70)
                || (edad > 6.0 && edad <= 13.0 && presion >= 64 && presion <= 86)
                || (edad > 13.0 && edad <= 16.0 && presion >= 70 && presion <= 82)
                || (edad > 16.0 && presion >= 70 && presion <= 90)) {
            objSensoresAlerta.setTensionArterialDiastolica(-1);

            return 0;
        }
        objSensoresAlerta.setTensionArterialDiastolica(presion);
        return 1;
    }

    public static int determinarRangoNormalFrecuenciaRespiratoria(float edad, int frecuencia) {
        if ((edad >= 0.0 && edad <= 0.1154 && frecuencia >= 40 && frecuencia <= 45)
                || (edad >= 0.1346 && edad <= 1.0 && frecuencia >= 20 && frecuencia <= 30)
                || (edad > 1.0 && edad <= 2.0 && frecuencia >= 20 && frecuencia <= 30)
                || (edad > 2.0 && edad <= 6.0 && frecuencia >= 20 && frecuencia <= 30)
                || (edad > 6.0 && edad <= 13.0 && frecuencia >= 12 && frecuencia <= 20)
                || (edad > 13.0 && edad <= 16.0 && frecuencia >= 12 && frecuencia <= 20)
                || (edad > 16.0 && frecuencia >= 12 && frecuencia <= 20)) {
            objSensoresAlerta.setFrecuenciaCardiaca(-1);

            return 0;
        }
        objSensoresAlerta.setFrecuenciaRespiratoria(frecuencia);
        return 1;
    }

    public static int determinarRangoNormalSaturacionOxigeno(float edad, int saturacion) {
        if (edad >= 0.0 && edad <= 120.0 && saturacion >= 95 && saturacion <= 100) {
            objSensoresAlerta.setSaturacionOxigeno(-1);
            return 0;

        }
        objSensoresAlerta.setSaturacionOxigeno(saturacion);
        return 1;
    }

    public static int determinarRangoNormalTemperatura(float edad, float temperatura) {
        if ((edad >= 0.0 && edad <= 0.1154 && temperatura == 38.0)
                || (edad >= 0.1346 && edad <= 1.0 && temperatura >= 37.5 && temperatura <= 37.8)
                || (edad > 1.0 && edad <= 2.0 && temperatura >= 37.5 && temperatura <= 37.8)
                || (edad > 2.0 && edad <= 6.0 && temperatura >= 37.5 && temperatura <= 37.8)
                || (edad > 6.0 && edad <= 13.0 && temperatura >= 37 && temperatura <= 37.5)
                || (edad > 13.0 && edad <= 16.0 && temperatura == 37.0)
                || (edad > 16.0 && temperatura >= 36.2 && temperatura <= 37.2)) {
            objSensoresAlerta.setTemperatura(-1);
            return 0;
        }
        objSensoresAlerta.setTemperatura(temperatura);
        return 1;
    }

    public static void tomarAccionesPuntuacion(SensoresDTO objSensoresDTO) throws RemoteException {
        pacienteDTO paciente = new pacienteDTO();
        paciente = ref.buscarPaciente(objSensoresDTO.getIdUsuario());
        System.out.println(paciente.nombre);
        int puntuacion = 0;
        float edad = paciente.edad;
        String mensaje = "";

        puntuacion += RangosSalud.determinarRangoNormalFrecuenciaCardiaca(edad, objSensoresDTO.getFrecuenciaCardiaca());
        puntuacion += RangosSalud.determinarRangoNormalFrecuenciaRespiratoria(edad, objSensoresDTO.getFrecuenciaRespiratoria());
        puntuacion += RangosSalud.determinarRangoNormalPresionArterialSistolica(edad, objSensoresDTO.getTensionArterialSistolica());
        puntuacion += RangosSalud.determinarRangoNormalPresionArterialDiastolica(edad, objSensoresDTO.getTensionArterialDiastolica());
        puntuacion += RangosSalud.determinarRangoNormalSaturacionOxigeno(edad, objSensoresDTO.getSaturacionOxigeno());
        puntuacion += RangosSalud.determinarRangoNormalTemperatura(edad, objSensoresDTO.getTemperatura());
        System.out.println("Puntuacion: " + puntuacion);
        if (puntuacion == 2) {
            mensaje = "La enfermera debe revisar al paciente";
        } else if (puntuacion >= 3) {
            mensaje = "La enfermera y el médico deben revisar al paciente";
        }
        if (puntuacion >= 2) {
            objPacienteRepositoryImpl.almacenarDatosAlerta(objSensoresDTO, puntuacion, paciente, obtenerFechaHoraActual());
            Paciente objPaciente = new Paciente(paciente.numeroHabitacion, paciente.nombre,paciente.apellido,paciente.edad);
            Notificacion objNotificacion = new Notificacion(obtenerFechaHoraActual(), 
                    mensaje, puntuacion, objSensoresAlerta, objPaciente, objPacienteRepositoryImpl.cantidad());
            objNotificacion.setAlertas(objPacienteRepositoryImpl.leerInformacionArchivo(paciente.numeroHabitacion));
            objRemoto.notificarEquiposSobreNuevaAlerta(objNotificacion);
            
        }
    }

    static String obtenerFechaHoraActual() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
