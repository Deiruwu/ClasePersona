package ClasePersona;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class inicio {
    /**
     * Método principal que inicia la ejecución del programa.
     * Solicita al usuario el número de usuarios con los que desea trabajar,
     * crea los objetos de la clase persona correspondientes y gestiona el menú de opciones.
     * 
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*---------------------- Bienvenido al programa ----------------------*");
        int n = 0;
        boolean inputValido = false;

        do {
            try {
                System.out.print("Por favor, ingrese el número de usuarios con los que desea trabajar: ");
                n = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer del scanner
                
                if (n <= 0) {
                    System.out.println("Por favor, ingrese un número válido mayor que cero.");
                } else {
                    inputValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        } while (!inputValido);

        ArrayList<Persona> usuario = new ArrayList<Persona>(n);

        // Ciclo para instanciar n objetos de la clase persona
        for (int i = 0; i < n; i++) {
            Persona persona = utilidadesPersona.crearObjeto(i);
            usuario.add(persona);
        }

        // Crear usuarioCopia usando el constructor copia
        Persona usuarioCopia = new Persona(usuario.get(0));

        MenuManager menuManager = new MenuManager();
        menuManager.menuManejoDatos(usuario, usuarioCopia);

        System.out.println("El programa ha finalizado");
        sc.close(); 
    }
}