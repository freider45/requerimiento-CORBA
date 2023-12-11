/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.utilidades;

import servidor.DTO.SensoresDTO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import servidor.DTO.Notificacion;
import servidor.controladores.ControladorGestorNotificacionInt;

/**
 *
 * @author Jorge
 */
/*public class RangosSalud {

    static Notificacion objNotificacion = new Notificacion();
    static ControladorGestorNotificacionInt objRemoto;
    static SensoresDTO objSensoresAlerta = new SensoresDTO();

    public RangosSalud(ControladorGestorNotificacionInt objRemoto) {
        this.objRemoto = objRemoto;
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
        int puntuacion = 0;

        puntuacion += RangosSalud.determinarRangoNormalFrecuenciaCardiaca(objSensoresDTO.getPaciente().getEdad(), objSensoresDTO.getFrecuenciaCardiaca());
        puntuacion += RangosSalud.determinarRangoNormalFrecuenciaRespiratoria(objSensoresDTO.getPaciente().getEdad(), objSensoresDTO.getFrecuenciaRespiratoria());
        puntuacion += RangosSalud.determinarRangoNormalPresionArterialSistolica(objSensoresDTO.getPaciente().getEdad(), objSensoresDTO.getTensionArterialSistolica());
        puntuacion += RangosSalud.determinarRangoNormalPresionArterialDiastolica(objSensoresDTO.getPaciente().getEdad(), objSensoresDTO.getTensionArterialDiastolica());
        puntuacion += RangosSalud.determinarRangoNormalSaturacionOxigeno(objSensoresDTO.getPaciente().getEdad(), objSensoresDTO.getSaturacionOxigeno());
        puntuacion += RangosSalud.determinarRangoNormalTemperatura(objSensoresDTO.getPaciente().getEdad(), objSensoresDTO.getTemperatura());
        System.out.println("Puntuacion: " + puntuacion);
            objSensoresAlerta.setPaciente(objSensoresDTO.getPaciente());
        if (puntuacion >= 2) {
            Notificacion objNotificacion = new Notificacion(obtenerFechaHoraActual(), "La enfermera debe revisar el paciente", puntuacion, objSensoresAlerta);

            objRemoto.enviarNotificacion(objNotificacion);
            guardarAlertaTxt(objSensoresDTO, puntuacion);

        }

        if (puntuacion == 2) {
            System.out.println("La enfermera debe revisar al paciente");
        } else if (puntuacion >= 3) {
            System.out.println("La enfermera y el médico deben revisar al paciente");
            Notificacion objNotificacion = new Notificacion(obtenerFechaHoraActual(), "La enfermera y el medico debe revisar el paciente", puntuacion, objSensoresAlerta);

            objRemoto.enviarNotificacion(objNotificacion);
        }

    }

    static void guardarAlertaTxt(SensoresDTO objSensoresDTO, int puntuacion) {
        try {
            File file = new File("historialDeAlertas.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("No de habitación: " + objSensoresDTO.getPaciente().getNoHabitacion() + "\n");
            bw.write("Nombres y apellidos del paciente: " + objSensoresDTO.getPaciente().getNombres() + " " + objSensoresDTO.getPaciente().getApellidos() + "\n");
            bw.write("Fecha de la alerta: " + obtenerFechaHoraActual() + "\n");
            bw.write("Puntuación: " + puntuacion + "\n");

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String obtenerFechaHoraActual() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
*/