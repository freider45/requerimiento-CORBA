
package servidor.Repositorios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import servidor.DTO.SensoresDTO;
import servidorDeAlertas.sop_corba.GestionPacientesOperations;
import servidorDeAlertas.sop_corba.GestionPacientesPackage.pacienteDTO;

public class PacienteRepositorioImpl implements PacienteRepositoryInt {

    private LinkedList<SensoresDTO> objSensores;
    
    public PacienteRepositorioImpl(){
        objSensores=new LinkedList();
    }
    
    @Override
    public void almacenarDatosAlerta(SensoresDTO objSensoresDTO, int puntuacion, pacienteDTO paciente, String fechaHora) {
        try {
            File file = new File("historialDeAlertas.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("No de habitación: " + objSensoresDTO.getIdUsuario() + "\n");
            bw.write("Nombres y apellidos del paciente: " + paciente.nombre + " " + paciente.apellido + "\n");
            bw.write("Fecha de la alerta: " + fechaHora + "\n");
            bw.write("Puntuación: " + puntuacion + "\n");

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
