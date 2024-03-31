package ClasePersona;
import java.util.InputMismatchException;
import java.util.Scanner;

public class utilidadesPersona {
    /**
     * Crea un objeto de tipo persona con los datos ingresados por el usuario.
     * 
     * @param sc el objeto Scanner utilizado para leer la entrada del usuario.
     * @param i el índice del usuario actual.
     * @return el objeto persona creado con los datos ingresados.
     */
    public static persona crearObjeto(Scanner sc, int i) {
        boolean exception = false;
        persona nuevoUsuario = null;
        do {
            System.out.println("*--------------------------------------------------------------------*");
            System.out.println("Ingrese los datos del usuario " + (i + 1) + ":");
        try {
            
            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el apellido paterno: ");
            String apellidoPaterno = sc.nextLine();

            System.out.print("Ingrese el apellido materno: ");
            String apellidoMaterno = sc.nextLine();

            System.out.print("Ingrese la edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            char genero;
            do {
                System.out.print("Ingrese el género (M/F): ");
                genero = sc.nextLine().toUpperCase().charAt(0);
            } while (genero != 'M' && genero != 'F');

            System.out.print("Ingrese el domicilio: ");
            String domicilio = sc.nextLine();

            System.out.print("Ingrese la estatura (Metros): ");
            double estatura = sc.nextDouble();
            sc.nextLine();

            exception = true;

            nuevoUsuario = new persona(nombre, apellidoPaterno, apellidoMaterno, edad, genero, domicilio, estatura);
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese un valor válido.");
            sc.nextLine(); // Limpiar el búfer del scanner
        }

        } while (!exception);
        return nuevoUsuario;
    }


    /**
    * Corrige los datos de un usuario en base a la opción seleccionada.
    *
    * @param id el ID del usuario
    * @param usuario el objeto persona que representa al usuario
    * @param sc el objeto Scanner para leer la entrada del usuario
    */
    public static void corregirDatos(int id, persona usuario, Scanner sc) {
        System.out.println("Datos actuales:");
        usuario.mostrarInformacion(id);

        System.out.println("¿Qué dato desea corregir?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido paterno");
        System.out.println("3. Apellido materno");
        System.out.println("4. Edad");
        System.out.println("5. Género");
        System.out.println("6. Domicilio");
        System.out.println("7. Estatura");

        try {
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    usuario.setNombre(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nuevo apellido paterno: ");
                    usuario.setApellidoPaterno(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nuevo apellido materno: ");
                    usuario.setApellidoMaterno(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nueva edad: ");
                    usuario.setEdad(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.print("Nuevo género (M/F): ");
                    usuario.setGenero(sc.nextLine().toUpperCase().charAt(0));
                    break;
                case 6:
                    System.out.print("Nuevo domicilio: ");
                    usuario.setDomicilio(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Nueva estatura (Metros): ");
                    usuario.setEstatura(sc.nextDouble());
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese una opción válida.");
            sc.nextLine(); // Limpiar el búfer del scanner
        }
    }


    /**
     * Muestra un menú para organizar y previsualizar los datos de un arreglo de personas.
     * 
     * @param usuario el arreglo de personas a organizar y previsualizar
     * @param sc el objeto Scanner utilizado para leer la entrada del usuario
     */
    public static void menuOrganizar(persona[] usuario, Scanner sc) {
        char opciones;
        do {
            try {
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
                    case 'A':
                        System.out.println("Se muestran datos ordenados por edad de mayor a menor");
                        ordenarPorEdad = true;
                        ordenarMayorAMenor = true;
                        persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                        MenuManager.cicloDatos(usuario);
                        break;
                    case 'B':
                        System.out.println("Se muestran datos ordenados por edad de menor a mayor");
                        ordenarPorEdad = true;
                        ordenarMayorAMenor = false;
                        persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                        MenuManager.cicloDatos(usuario);
                        break;
                    case 'C':
                        System.out.println("Se muestran datos ordenados por apellido paterno de mayor a menor");
                        ordenarPorEdad = false;
                        ordenarMayorAMenor = true;
                        persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                        MenuManager.cicloDatos(usuario);
                        break;
                    case 'D':
                        System.out.println("Se muestran datos ordenados por apellido paterno de menor a mayor");
                        ordenarPorEdad = false;
                        ordenarMayorAMenor = false;
                        persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                        MenuManager.cicloDatos(usuario);
                        break;
                    case 'E':
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese una opción válida.");
                sc.nextLine(); // Limpiar el búfer del scanner
                opciones = ' '; // Reiniciar la opción para evitar bucle infinito
            }
        } while (opciones != 'E');
    }


    /**
     * Muestra un menú para corregir los datos de una persona en base a diferentes opciones de búsqueda.
     * 
     * @param usuario el arreglo de personas
     * @param sc el objeto Scanner para leer la entrada del usuario
     */
    public static void menuCorregir(persona[] usuario, Scanner sc) {
        char opcion;
        int numeroPersona;

        do {
            try {
                System.out.println("¿Cómo deseas buscar al usuario al que deseas corregir datos?");
                System.out.println("A Por número de usuario");
                System.out.println("B Por nombre y apellido paterno");
                System.out.println("C Salir");
                opcion = sc.nextLine().toUpperCase().charAt(0);

                switch (opcion) {
                    case 'A':
                        System.out.print("Ingrese el número de la persona que desea corregir (1-" + usuario.length + "): ");
                        numeroPersona = sc.nextInt();
                        sc.nextLine();
                        envioCorregirDatos(usuario, numeroPersona, sc);
                        break;
                    case 'B':
                        System.out.println("Ingresa el/los nombre(s) y apellido paterno de la persona que desea corregir");
                        String nombreBusqueda = sc.nextLine();
                        String apellidoBusqueda = sc.nextLine();
                        boolean encontrado = false;

                        for (int x = 0; x < usuario.length; x++) {
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
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese una opción válida.");
                sc.nextLine(); // Limpiar el búfer del scanner
                opcion = ' '; // Reiniciar la opción para evitar bucle infinito
            }
        } while (opcion != 'C');
    }

    /**
     * Envía los datos de una persona para corregirlos y muestra los datos corregidos.
     * 
     * @param usuario el arreglo de personas
     * @param numeroPersona el número de la persona a corregir
     * @param sc el objeto Scanner para leer la entrada del usuario
     */
    public static void envioCorregirDatos(persona[] usuario, int numeroPersona, Scanner sc) {
        try {
            corregirDatos(numeroPersona, usuario[numeroPersona - 1], sc);
            System.out.println("Datos corregidos:");
            usuario[numeroPersona - 1].mostrarInformacion(numeroPersona);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: El número de usuario especificado está fuera de rango.");
        }
    }
}
