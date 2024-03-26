package paquetote.ClasePersona;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
class MenuManager {
    public void menuManejoDatos(persona[] usuario, persona usuarioCopia, Scanner sc) {
        char opcion;

        System.out.println("*----------------------Menú de manejo de datos-----------------------*");
        do {
            System.out.println("A Mostrar datos");
            System.out.println("B Modificar datos");
            System.out.println("C Salir");
            opcion = sc.nextLine().toUpperCase().charAt(0);

            switch (opcion) {
                case 'A':
                    menuOrganizar(usuario, sc);
                    break;
                case 'B':
                    menuCorregir(usuario, sc);
                    break;
                case 'C':
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 'C');

        // Llamada al modulo mostrar información para usuario2
        usuarioCopia.mostrarInformacion(999);
    }

    public void menuOrganizar(persona[] usuario, Scanner sc) {
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
                    persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                    cicloDatos(usuario);
                    break;
                case 'B':
                    System.out.println("Se muestran datos ordenados por edad de menor a mayor");
                    ordenarPorEdad = true;
                    ordenarMayorAMenor = false;
                    persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                    cicloDatos(usuario);
                    break;
                case 'C':
                    System.out.println("Se muestran datos ordenados por apellido paterno de mayor a menor");
                    ordenarPorEdad = false;
                    ordenarMayorAMenor = true;
                    persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                    cicloDatos(usuario);
                    break;
                case 'D':
                    System.out.println("Se muestran datos ordenados por ");
                    ordenarPorEdad = false;
                    ordenarMayorAMenor = false;
                    persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
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

    public void menuCorregir(persona[] usuario, Scanner sc) {
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
                        System.out.print("Ingrese el número de la persona que desea corregir (1-" + usuario.length + "): ");
                        numeroPersona = sc.nextInt();
                        sc.nextLine();
                        utilidadesPersona.envioCorregirDatos(usuario, numeroPersona, sc);
                        break;
                    case 'B':
                        System.out.println("Ingresa el/los nombre(s): ");
                        String nombreBusqueda = sc.nextLine();
                        System.out.println("Ingresa el apellido paterno: ");
                        String apellidoBusqueda = sc.nextLine();
                        boolean encontrado = false;

                        for (int x = 0; x < usuario.length; x++) {
                            if (nombreBusqueda.equalsIgnoreCase(usuario[x].nombre) && apellidoBusqueda.equalsIgnoreCase(usuario[x].apellidoPaterno)) {
                                numeroPersona = x + 1;
                                utilidadesPersona.envioCorregirDatos(usuario, numeroPersona, sc);
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

    public static void cicloDatos(persona[] usuario) {
        //ciclo para mostrar datos
        System.out.println("*--------------------------------------------*");
        for (int j = 0; j < usuario.length; j++) {
            usuario[j].mostrarInformacion(j + 1);
            System.out.println();
        }
    }
}

