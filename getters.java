package paquetote.ClasePersona;
import java.util.Scanner;
public class getters {
       public static void corregirDatos(int id,persona usuario, Scanner sc) {
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
    }
    
    //Metodo de datos para crear un objeto
    public static persona crearObjeto(Scanner sc) {
        // Cambiamos el alcance de las variables a nivel de clase
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el apellido paterno: ");
        String apellidoPaterno = sc.nextLine();

        System.out.print("Ingrese el apellido materno: ");
        String apellidoMaterno = sc.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el género (M/F): ");
        char genero = sc.nextLine().toUpperCase().charAt(0);

        System.out.print("Ingrese el domicilio: ");
        String domicilio = sc.nextLine();

        System.out.print("Ingrese la estatura (Metros): ");
        double estatura = sc.nextDouble();
        sc.nextLine();

        return new persona(nombre, apellidoPaterno, apellidoMaterno, edad, genero, domicilio, estatura);
    }
}
