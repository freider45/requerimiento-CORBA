
package servidor.DTO;
import java.io.Serializable;

public class SensoresDTO implements Serializable{
    //Atributos
    private int frecuenciaCardiaca;
    private int tensionArterialSistolica;
    private int tensionArterialDiastolica;
    private int frecuenciaRespiratoria;
    private int saturacionOxigeno;
    private float temperatura;
    private UsuarioDTO paciente;
    
    //Constructor
    public SensoresDTO() {
    }

    public SensoresDTO(int frecuenciaCardiaca, int tensionArterialSistolica, int tensionArterialDiastolica, int frecuenciaRespiratoria, int saturacionOxigeno, float temperatura, UsuarioDTO paciente) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.tensionArterialSistolica = tensionArterialSistolica;
        this.tensionArterialDiastolica = tensionArterialDiastolica;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.saturacionOxigeno = saturacionOxigeno;
        this.temperatura = temperatura;
        this.paciente = paciente;
    }
    
    //Metodos get and setter
    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public int getTensionArterialSistolica() {
        return tensionArterialSistolica;
    }

    public void setTensionArterialSistolica(int tensionArterialSistolica) {
        this.tensionArterialSistolica = tensionArterialSistolica;
    }

    public int getTensionArterialDiastolica() {
        return tensionArterialDiastolica;
    }

    public void setTensionArterialDiastolica(int tensionArterialDiastolica) {
        this.tensionArterialDiastolica = tensionArterialDiastolica;
    }

    public int getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public int getSaturacionOxigeno() {
        return saturacionOxigeno;
    }

    public void setSaturacionOxigeno(int saturacionOxigeno) {
        this.saturacionOxigeno = saturacionOxigeno;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public UsuarioDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(UsuarioDTO paciente) {
        this.paciente = paciente;
    }
    
}
