package paquetote.ClasePersona;
import java.util.Scanner;
public class inicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*--- Bienvenido al programa ---*");
        System.out.print("Por favor, ingrese el número de usuarios con los que desea trabajar: ");
        int n = sc.nextInt();
        sc.nextLine();

        persona[] usuario = new persona[n];

        System.out.println("¡De acuerdo! Se creó un arreglo de " + n + " usuarios");

        //ciclo para instanciar n objetos de la clase persona
        for (int i = 0; i < usuario.length; i++) {
            System.out.println("Ingrese los datos del usuario " + (i + 1) + ":");
            usuario[i] = getters.crearObjeto(sc); //Llama al metodo que nos solicitará los datos para crear un objeto
            System.out.println();
        }

        // Crear usuario11 usando el constructor copia
        persona usuarioCopia = new persona(usuario[0]);

        char opcion;

        System.out.println("*------Menú de maenjo de datos------*");
        do {
        System.out.println("A Mostrar datos");
        System.out.println("B Modificar datos");
        System.out.println("C Salir");
        opcion = sc.nextLine().toUpperCase().charAt(0);

        switch (opcion) {
            case 'A': menuOrganizar(usuario, sc);
                
                break;
            case 'B': menuCorregir(usuario, sc);

            default: System.out.println("Opción no valida");
                break;
        }

        } while (opcion != 'C');

                // Llamada al modulo mostrar información para usuario2
                usuarioCopia.mostrarInformacion(999);

                System.out.println("El programa ha finalizado");
                sc.close(); 
        
    }

    public static void cicloDatos(persona[] usuario) {
    //ciclo para mostrar datos
    System.out.println("*--------------------------------------------*");
        for (int j = 0; j < usuario.length; j++) {
            usuario[j].mostrarInformacion(j+1);
            System.out.println();
        }
    }

    public static void menuOrganizar(persona[] usuario, Scanner sc){
        char opciones;

 do {
    System.out.println("¿Cómo deseas previsualizar los datos?");
    System.out.println("A Por edad de mayor a menor");
    System.out.println("B Por edad de menor a mayor");
    System.out.println("C Por apellido paterno de mayor a menor");
    System.out.println("D Por apellido paterno de menor a mayor");
    System.out.println("E Salir");
    opciones = sc.nextLine().toUpperCase().charAt(0);
    boolean ordenarPorEdad;
    boolean ordenarMayorAMenor;

    switch (opciones) {
        case 'A': System.out.println("Se muestran datos ordenados por edad de mayor a menor");
            ordenarPorEdad = true;
            ordenarMayorAMenor = true;
            persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
            cicloDatos(usuario);
            break;
        case 'B': System.out.println("Se muestran datos ordenados por edad de menor a mayor");
            ordenarPorEdad = true;
            ordenarMayorAMenor = false;
            persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
            cicloDatos(usuario);
            break;
        case 'C': System.out.println("Se muestran datos ordenados por apellido paterno de mayor a menor");
            ordenarPorEdad = false;
            ordenarMayorAMenor = true;
            persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
            cicloDatos(usuario);
            break;
        case 'D': System.out.println("Se muestran datos ordenados por ");
            ordenarPorEdad = false;
            ordenarMayorAMenor = false;
            persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
            cicloDatos(usuario);
            break;
        case 'E':
            break;
        default: System.out.println("Opción no valida");
            break;
    }

 } while (opciones != 'E');
    }

    public static void menuCorregir (persona[] usuario, Scanner sc) {
        char opcion;
        int numeroPersona;

        do {
        System.out.println("¿Cómo deseas buscar al usuario al que deseas corregir datos?");
        System.out.println("A Por número de usuario");
        System.out.println("B Por nombre y apellido paterno");
        System.out.println("C Salir");
        opcion=sc.nextLine().toUpperCase().charAt(0);

        switch (opcion) {
            case 'A': System.out.print("Ingrese el número de la persona que desea corregir (1-" + usuario.length + "): ");
            numeroPersona = sc.nextInt();
            sc.nextLine();
            envioCorregirDatos(usuario, numeroPersona, sc);              
                break;
            case 'B': System.out.println("Ingresa el/los nombre(s) y apellido paterno de la persona que desea corregir");
            String nombreBusqueda=sc.nextLine();
            String apellidoBusqueda=sc.nextLine();
            boolean encontrado = false;
            
            for (int x=0; x<usuario.length; x++){
                if (nombreBusqueda.equalsIgnoreCase(usuario[x].nombre) && apellidoBusqueda.equalsIgnoreCase(usuario[x].apellidoPaterno)) {
                numeroPersona = x + 1;
                envioCorregirDatos(usuario, numeroPersona, sc);
                encontrado = true;
                break;
                }    
            }

                if (!encontrado)
                    System.out.println("No se encontró al usuario");
                break;
            case 'C':
                break;
            default: System.out.println("Opción no valida");
                break;
        }
    }while (opcion != 'C');
}

    public static void envioCorregirDatos(persona[] usuario, int numeroPersona, Scanner sc){
            getters.corregirDatos(numeroPersona, usuario[numeroPersona-1], sc);
            System.out.println("Datos corregidos:");
            usuario[numeroPersona - 1].mostrarInformacion(numeroPersona);

    }
}

