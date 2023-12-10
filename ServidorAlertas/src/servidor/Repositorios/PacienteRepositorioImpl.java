
package servidor.Repositorios;

import java.util.LinkedList;
import java.util.List;
import servidor.DTO.SensoresDTO;

public class PacienteRepositorioImpl implements PacienteRepositoryInt {

    private LinkedList<SensoresDTO> objSensores;
    
    public PacienteRepositorioImpl(){
        objSensores=new LinkedList();
    }
    /*
    @Override
    public UsuarioDTO registrarPaciente(UsuarioDTO objPaciente) {
        this.pacientes.add(objPaciente);
        return objPaciente;
    }*/

    @Override
    public void almacenarDatosAlerta(SensoresDTO objSensoresDTO) {
        //TODO alamcenar la informacion cuando se genera una alerta
        //: No de habitación, Nombres y apellidos del paciente, 
        //Fecha de la alerta, Hora de alerta y Puntuación.
    }
}
