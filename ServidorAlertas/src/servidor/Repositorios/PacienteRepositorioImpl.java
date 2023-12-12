
package servidor.Repositorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import servidor.DTO.Notificacion;
import servidor.DTO.SensoresDTO;
import servidorDeAlertas.sop_corba.GestionPacientesOperations;
import servidorDeAlertas.sop_corba.GestionPacientesPackage.pacienteDTO;

public class PacienteRepositorioImpl implements PacienteRepositoryInt {

    private LinkedList<SensoresDTO> objSensores;
    private int contador = 0;
    private Notificacion notificacion = new Notificacion();
    
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

            bw.write(paciente.numeroHabitacion+ ",");
            bw.write(paciente.nombre + ",");
            bw.write(paciente.apellido + ",");
            bw.write(fechaHora + ",");
            bw.write(puntuacion + "\n");

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Notificacion> leerInformacionArchivo(int numHabitacion) {
         int cantidad=0;
        ArrayList<Notificacion> listaAlertas = new ArrayList<>();
        ArrayList<Notificacion> alertas = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("historialDeAlertas.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int identificacion = Integer.parseInt(parts[0]);
                
                if (identificacion == numHabitacion) {
                    
                    notificacion.setFechaHora(parts[3]);
                    notificacion.setPuntuacion(Integer.parseInt(parts[4]));
                    
                    listaAlertas.add(notificacion);
 
                    cantidad++;
                   
                }
            }
            if(cantidad>5){
                cantidad=5;
            }
            int pos=0;
            this.contador=cantidad;
            this.notificacion.setCantidadAlertas(cantidad);
            
            for (int i = listaAlertas.size() - 1; i >= 0; i--) {
                if(pos<5){
                    alertas.add(listaAlertas.get(i));
                    pos++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return alertas;
    }
    
    public int cantidad(){
        return this.contador;
    }
}
