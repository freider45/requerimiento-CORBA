
package servidor.Repositorios;

import java.util.ArrayList;
import servidor.DTO.Notificacion;
import servidor.DTO.SensoresDTO;
import servidorDeAlertas.sop_corba.GestionPacientesPackage.pacienteDTO;

public interface PacienteRepositoryInt
{    
    public void almacenarDatosAlerta(SensoresDTO objSensoresDTO, int puntuacion, pacienteDTO paciente, String fechaHora);
    ArrayList<Notificacion> leerInformacionArchivo(int numHabitacion);
}


