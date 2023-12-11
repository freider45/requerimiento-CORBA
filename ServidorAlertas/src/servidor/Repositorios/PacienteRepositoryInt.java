
package servidor.Repositorios;

import servidor.DTO.SensoresDTO;
import servidorDeAlertas.sop_corba.GestionPacientesPackage.pacienteDTO;

public interface PacienteRepositoryInt
{    
    public void almacenarDatosAlerta(SensoresDTO objSensoresDTO, int puntuacion, pacienteDTO paciente, String fechaHora);
}


