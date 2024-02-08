package paquetote.ClasePersona;
import java.util.InputMismatchException;
import java.util.Scanner;

public class inicio {
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

        persona[] usuario = new persona[n];
    
        // Ciclo para instanciar n objetos de la clase persona
        for (int i = 0; i < usuario.length; i++) {
            usuario[i] = utilidadesPersona.crearObjeto(sc, i);
        }

        // Crear usuarioCopia usando el constructor copia
        persona usuarioCopia = new persona(usuario[0]);

        MenuManager menuManager = new MenuManager();
        menuManager.menuManejoDatos(usuario, usuarioCopia, sc);

        System.out.println("El programa ha finalizado");
        sc.close(); 
    }
}
