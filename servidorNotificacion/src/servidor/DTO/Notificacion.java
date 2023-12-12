
package servidor.DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class Notificacion implements Serializable{
    private String fechaHora;
    private String mensaje;
    private int puntuacion;
    private SensoresDTO objSensor;
    private Paciente objPaciente;
    private ArrayList<Notificacion> alertas;
    private int cantidadAlertas;

    public Notificacion() {
    }

    public Notificacion(String fechaHora, String mensaje, int puntuacion, SensoresDTO objSensor, Paciente objPaciente, int cantidadAlertas) {
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.puntuacion = puntuacion;
        this.objSensor = objSensor;
        this.objPaciente = objPaciente;
        this.cantidadAlertas = cantidadAlertas;
        this.alertas=new ArrayList<>();
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public SensoresDTO getObjSensor() {
        return objSensor;
    }

    public void setObjSensor(SensoresDTO objSensor) {
        this.objSensor = objSensor;
    }

    public Paciente getObjPaciente() {
        return objPaciente;
    }

    public void setObjPaciente(Paciente objPaciente) {
        this.objPaciente = objPaciente;
    }

    public int getCantidadAlertas() {
        return cantidadAlertas;
    }

    public void setCantidadAlertas(int cantidadAlertas) {
        this.cantidadAlertas = cantidadAlertas;
    }

    public ArrayList<Notificacion> getAlertas() {
        return alertas;
    }

    public void setAlertas(ArrayList<Notificacion> alertas) {
        this.alertas = alertas;
    }
    
    
}
