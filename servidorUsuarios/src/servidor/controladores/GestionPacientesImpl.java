/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controladores;

import java.util.HashMap;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import servidorDeUsuarios.sop_corba.GestionPacientesPOA;
import servidorDeUsuarios.sop_corba.GestionPacientesPackage.pacienteDTO;

/**
 *
 * @author LENOVO
 */
public class GestionPacientesImpl extends GestionPacientesPOA {

    private HashMap<Integer, pacienteDTO> pacientes;
    //private GestionNotificaciones referenciaNotificaciones;

    public GestionPacientesImpl() {
        this.pacientes = new HashMap();
    }

    @Override
    public boolean registrarPaciente(pacienteDTO objPaciente) {
        System.out.println("Invocando a registrar paciente");
        boolean bandera = false;
        int band = 0;

        if (!pacientes.containsKey(objPaciente.numeroHabitacion)) {
            if(pacientes.size() < 5){
                pacientes.put(objPaciente.numeroHabitacion, objPaciente);
                bandera = true;
                band = 1;
            }  
        }
        System.out.println("\nPaciente registrado: ");
        System.out.println("\nNum Habitacion: "+objPaciente.numeroHabitacion);
        System.out.println("\nNombres: "+objPaciente.nombre);
        System.out.println("\nApellidos: "+objPaciente.apellido);
        System.out.println("\nEdad: "+objPaciente.edad+" años");
        return bandera;
    }

    @Override
    public pacienteDTO buscarPaciente(int numeroHabitacion) {
        System.out.println("Invocando a consultar paciente");
        pacienteDTO objPaciente = new pacienteDTO("", "", -1,-1);
        if (this.pacientes.get(numeroHabitacion) != null) {
            objPaciente = this.pacientes.get(numeroHabitacion);
        }
        return objPaciente;
    }

}
