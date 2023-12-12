/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controladores;

import java.util.HashMap;
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

        if (!pacientes.containsKey(objPaciente.numeroHabitacion)) {
            if(pacientes.size() < 5){
                pacientes.put(objPaciente.numeroHabitacion, objPaciente);
                bandera = true;
            }  
        }
        System.out.println("Paciente con identificacion "+objPaciente.numeroHabitacion+" registrado ");
        return bandera;
    }

    @Override
    public pacienteDTO buscarPaciente(int numeroHabitacion) {
        System.out.println("Invocando a consultar paciente");
        pacienteDTO objPaciente = new pacienteDTO("", "", -1,-1);
        if (this.pacientes.get(numeroHabitacion) != null) {
            objPaciente = this.pacientes.get(numeroHabitacion);
            System.out.println("Paciente con identificacion "+numeroHabitacion+" encontrado");
        }
        return objPaciente;
    }

}
