package servidor.DTO;

import java.io.Serializable;

/**
 *
 * @author fre90
 */
public class Paciente implements Serializable{
   private int identificacion;
    private String nombres;
    private String apellidos;
    private float edad;

    public Paciente(int identificacion, String nombres, String apellidos, float edad) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad=edad;
        
    }

    public Paciente() {
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getEdad() {
        return edad;
    }

    public void setEdad(float edad) {
        this.edad = edad;
    }
 
}
