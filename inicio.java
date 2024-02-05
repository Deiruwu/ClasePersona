package paquetote.clasePersona;
import java.util.Scanner;
public class inicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        persona[] usuario = new persona[5];

        //ciclo para instanciar 5 objetos de la clase persona
        for (int i = 0; i < usuario.length; i++) {
            System.out.println("Ingrese los datos de la persona " + (i + 1) + ":");
            usuario[i] = getters.crearObjeto(sc); //Llama al metodo que nos solicitará los datos para crear un objeto
        }

        System.out.println("*--------------------------------------------*");
        //ciclo para mostrar datos
        for (int j = 0; j < usuario.length; j++) {
            usuario[j].mostrarInformacion(j);
            System.out.println();
        }

        // Crear usuario2 usando el constructor copia
        persona usuario6 = new persona(usuario[0]);

System.out.println("¿Desea corregir los datos de algún objeto? (S/N)");
        char cambio = sc.nextLine().toUpperCase().charAt(0);
while (cambio == 'S') {

        System.out.print("Ingrese el número de la persona que desea corregir (1-5): ");
        int numeroPersona = sc.nextInt();
        sc.nextLine();
            getters.corregirDatos(numeroPersona, usuario[numeroPersona-1], sc);
            System.out.println("Datos corregidos:");
            usuario[numeroPersona - 1].mostrarInformacion(numeroPersona);

            System.out.println("¿Desea continuar corrigiendo los datos de algún objeto? (S/N)");
            cambio = sc.nextLine().toUpperCase().charAt(0);
}

        // Llamada al modulo mostrar información para usuario2
        usuario6.mostrarInformacion(6);

        sc.close();
    }
       
}
    

