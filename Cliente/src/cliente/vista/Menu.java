package cliente.vista;

import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import servidor.DTO.SensoresDTO;
import servidor.controladores.ControladorGestorPacientesInt;
import usuarios.sop_corba.GestionPacientesOperations;
import usuarios.sop_corba.GestionPacientesPackage.pacienteDTO;

public class Menu {

    private final GestionPacientesOperations ref;
    private final ControladorGestorPacientesInt objRemoto;
    private final SensoresDTO objSensoresDTO = new SensoresDTO();
    private int terminar = 1;

    public Menu(GestionPacientesOperations ref, ControladorGestorPacientesInt objRemoto) {
        this.ref = ref;
        this.objRemoto = objRemoto;
    }

    public void ejecutarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n\t=============Menu Sensores============");
            System.out.println("1. Ingresar datos del paciente");
            System.out.println("2. Comenzar lectura de los sensores");
            System.out.println("3. Salir");
            System.out.println("\nDigite una opción: ");
            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    System.out.println("\nSaliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 4);
    }

    private void Opcion1() {
        String nombres, apellidos;
        int opcion, noHabitacion;
        float edad;
        System.out.println("\n============ Registro del paciente ==============");
        // Captura y validación del número de habitación
        do {
            System.out.println("\nDigite el número de habitación: ");
            noHabitacion = UtilidadesConsola.leerEntero();
            if (noHabitacion < 100 || noHabitacion > 999) {
                System.out.println("\nEl número de la habitación debe estar entre 100 y 999");
            }
        } while (noHabitacion < 100 || noHabitacion > 999);

        // Captura de los nombres del paciente
        System.out.println("\nDigite los nombres: ");
        nombres = UtilidadesConsola.leerCadena("nombres");

        // Captura de los apellidos del paciente
        System.out.println("\nDigite los apellidos: ");
        apellidos = UtilidadesConsola.leerCadena("apellidos");

        // Captura y validación de la edad del paciente
        do {
            System.out.println("\nDigite la edad del paciente: ");
            edad = UtilidadesConsola.leerEntero();

            if (edad < 1) {
                System.out.println("\nLa edad debe ser mayor a 0");
            }
        } while (edad < 1);

        // Captura y validación de la unidad de la edad
        do {
            System.out.println("\nUnidades para expresar la edad");
            System.out.println("1. Dias");
            System.out.println("2. Meses");
            System.out.println("3. años");
            System.out.println("Digite la opcion de unidad: ");
            opcion = UtilidadesConsola.leerEntero();
            // Conversión de la edad según la unidad ingresada
            switch (opcion) {
                case 1:
                    edad = edad / 365;
                    break;
                case 2:
                    edad = edad / 12;
                    break;
                case 3:
                    
                    break;
                default:
                    System.out.println("\nSeleccione una opcion correcta");
                    opcion = -1;
            }
        } while (opcion == -1);

        // Asignamos la identificacion del usuario registrado al objeto sensores
        objSensoresDTO.setIdUsuario(noHabitacion);
        
        pacienteDTO paciente = new pacienteDTO(nombres,apellidos,noHabitacion ,edad);
        boolean bandera=ref.registrarPaciente(paciente);//invocación al método remoto
        
        if (bandera){
            System.out.println("Paciente registrado con éxito");
        }
        else{
            System.out.println("No ha sido posible registrar el Paciente. Ya existe o hay mas de 5 pacientes registrados");
        }
    }

    private void Opcion2() {
        try {

            if (objSensoresDTO.getIdUsuario() > 0) {
                while (terminar > 0) {
                    lecturaSensores(objSensoresDTO);
                    boolean enviar = this.objRemoto.enviarLecturaSensores(objSensoresDTO);
                    if (!enviar) {
                        System.out.println("\nFallo en el envio de información");
                        terminar = 0;
                    }
                    System.out.println("\n\nEnviando indicadores..");
                    System.out.println("\nFrecuencia cardiaca: " + objSensoresDTO.getFrecuenciaCardiaca());
                    System.out.println("\nFrecuencia respiratoria: " + objSensoresDTO.getFrecuenciaRespiratoria());
                    System.out.println("\nPresión arterial: " + objSensoresDTO.getTensionArterialSistolica() + "/"
                            + objSensoresDTO.getTensionArterialDiastolica());
                    System.out.println("\nSaturación de oxígeno: " + objSensoresDTO.getSaturacionOxigeno());
                    System.out.println("\nTempertatura: " + objSensoresDTO.getTemperatura());
                    try {
                        TimeUnit.SECONDS.sleep(8);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("\nDebe registrar al paciente para comenzar con el monitoreo");
            }
        } catch (RemoteException e) {
            System.out.println("La operación no se pudo completar, intente nuevamente...");
            System.out.println("Excepcion generada: " + e.getMessage());
        }
    }

    private int numAleatorioFrecuenciaCardiaca() {
        Random rand = new Random();
        return rand.nextInt(81) + 60; // Genera un número aleatorio entre 60 y 140
    }

    private int numAleatorioFrecuenciaRespiratoria() {
        Random rand = new Random();
        return rand.nextInt(34) + 12; // Genera un número aleatorio entre 12 y 45
    }

    private int numAleatorioTensionArterialSistolica() {
        Random rand = new Random();
        return rand.nextInt(71) + 70; // Genera un número aleatorio entre 70 y 140
    }

    private int numAleatorioTensionArterialDiastolica() {
        Random rand = new Random();
        return rand.nextInt(41) + 50; // Genera un número aleatorio entre 50 y 90
    }

    private float numAleatorioTemperatura() {
        Random rand = new Random();
        int numEntero = rand.nextInt(9) + 36; // Genera un número aleatorio entre 36 y 44
        float numDecimal = rand.nextFloat(); // Genera un número decimal entre 0 y 1
        return numEntero + (numDecimal * 0.8f); // Multiplica el decimal por 0.8 para obtener la parte decimal entre 0 y 0.8
    }

    private int numAleatorioSaturacionOxigeno() {
        Random rand = new Random();
        return rand.nextInt(21) + 80; // Genera un número aleatorio entre 80 y 100
    }

    private void lecturaSensores(SensoresDTO objSensoresDTO) {
        objSensoresDTO.setFrecuenciaCardiaca(numAleatorioFrecuenciaCardiaca());
        objSensoresDTO.setFrecuenciaRespiratoria(numAleatorioFrecuenciaRespiratoria());
        objSensoresDTO.setTensionArterialSistolica(numAleatorioTensionArterialSistolica());
        objSensoresDTO.setTensionArterialDiastolica(numAleatorioTensionArterialDiastolica());
        objSensoresDTO.setSaturacionOxigeno(numAleatorioSaturacionOxigeno());
        objSensoresDTO.setTemperatura(numAleatorioTemperatura());
    }
}
