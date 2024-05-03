package ClasePersona;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class MenuManager {
    Scanner sc = new Scanner(System.in);
    /**
     * Método que muestra el menú de manejo de datos y realiza las operaciones correspondientes.
     * 
     * @param usuario       Arreglo de objetos de tipo Persona que contiene los usuarios.
     * @param usuarioCopia  Objeto de tipo Persona que representa una copia del usuario.
     * @param sc            Objeto de tipo Scanner utilizado para leer la entrada del usuario.
     */
    public void menuManejoDatos(ArrayList<Persona> usuario, Persona usuarioCopia){
        char opcion;

        System.out.println("*----------------------Menú de manejo de datos-----------------------*");
        do {
            System.out.println("A Mostrar datos");
            System.out.println("B Modificar datos");
            System.out.println("C Salir");
            opcion = sc.nextLine().toUpperCase().charAt(0);

            switch (opcion) {
                case 'A':
                    menuOrganizar(usuario);
                    break;
                case 'B':
                    menuCorregir(usuario);
                    break;
                case 'C':
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 'C');

        // Llamada al modulo mostrar información para usuario2
        System.out.println(usuarioCopia);
    }

    /**
     * Muestra un menú para organizar y previsualizar los datos de un arreglo de Personas.
     * 
     * @param usuario el arreglo de Personas a organizar y previsualizar
     * @param sc el objeto Scanner utilizado para leer la entrada del usuario
     */
    public void menuOrganizar(ArrayList<Persona> usuario) {
        char opcion;
        do {
            System.out.println("¿Cómo deseas previsualizar los datos?");
            System.out.println("A Por edad de mayor a menor");
            System.out.println("B Por edad de menor a mayor");
            System.out.println("C Por apellido paterno de mayor a menor");
            System.out.println("D Por apellido paterno de menor a mayor");
            System.out.println("E Salir");
            opcion = sc.nextLine().toUpperCase().charAt(0);
            boolean ordenarPorEdad;
            boolean ordenarMayorAMenor;

            switch (opcion) {
                case 'A':
                    System.out.println("Se muestran datos ordenados por edad de mayor a menor");
                    ordenarPorEdad = true;
                    ordenarMayorAMenor = true;
                    Persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                    cicloDatos(usuario);
                    break;
                case 'B':
                    System.out.println("Se muestran datos ordenados por edad de menor a mayor");
                    ordenarPorEdad = true;
                    ordenarMayorAMenor = false;
                    Persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                    cicloDatos(usuario);
                    break;
                case 'C':
                    System.out.println("Se muestran datos ordenados por apellido paterno de mayor a menor");
                    ordenarPorEdad = false;
                    ordenarMayorAMenor = true;
                    Persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                    cicloDatos(usuario);
                    break;
                case 'D':
                    System.out.println("Se muestran datos ordenados por ");
                    ordenarPorEdad = false;
                    ordenarMayorAMenor = false;
                    Persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                    cicloDatos(usuario);
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (opcion != 'E');
    }

    /**
     * Método que muestra un menú para corregir los datos de una Persona.
     * 
     * @param usuario el arreglo de Personas
     * @param sc el objeto Scanner para leer la entrada del usuario
     */
    public void menuCorregir(ArrayList<Persona> usuario) {
        char opcion;
        int numeroPersona;

        do {
            System.out.println("¿Cómo deseas buscar al usuario al que deseas corregir datos?");
            System.out.println("A Por número de usuario");
            System.out.println("B Por nombre y apellido paterno");
            System.out.println("C Salir");
            opcion = sc.nextLine().toUpperCase().charAt(0);

            try {
                switch (opcion) {
                    case 'A':
                        System.out.print("Ingrese el número de la Persona que desea corregir (1-" + usuario.size() + "): ");
                        numeroPersona = sc.nextInt();
                        sc.nextLine();
                        utilidadesPersona.envioCorregirDatos(usuario, numeroPersona);
                        break;
                    case 'B':
                        System.out.println("Ingresa el/los nombre(s): ");
                        String nombreBusqueda = sc.nextLine();
                        System.out.println("Ingresa el apellido paterno: ");
                        String apellidoBusqueda = sc.nextLine();
                        boolean encontrado = false;

                        for (int x = 0; x < usuario.size(); x++) {
                            if (nombreBusqueda.equalsIgnoreCase(usuario.get(x).nombre) && apellidoBusqueda.equalsIgnoreCase(usuario.get(x).apellidoPaterno)) {
                                numeroPersona = x + 1;
                                utilidadesPersona.envioCorregirDatos(usuario, numeroPersona);
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
                        System.out.println("Opción no valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor válido.");
                sc.nextLine(); 
            } catch (NoSuchElementException e) {
                System.out.println("Error: No se encontró el elemento esperado.");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("Error desconocido: " + e.getMessage());
            }
        } while (opcion != 'C');
    }

    /**
     * Método que muestra los datos de un arreglo de objetos Persona.
     * 
     * @param usuario El arreglo de objetos Persona.
     */
    public static void cicloDatos(ArrayList<Persona> usuario) {
        //ciclo para mostrar datos
        System.out.println("*--------------------------------------------*");
        for (int j = 0; j < usuario.size(); j++) {
            System.out.println(usuario.get(j));
            System.out.println();
        }
    }
}