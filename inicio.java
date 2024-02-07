package paquetote.ClasePersona;
import java.util.Scanner;
public class inicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*--- Bienvenido al programa ---*");
        System.out.print("Por favor, ingrese el número de usuarios con los que desea trabajar: ");
        int n = sc.nextInt();

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

        System.out.println("¿Desea corregir los datos de algún objeto? (S/N)");
        char cambio = sc.nextLine().toUpperCase().charAt(0);

        while (cambio == 'S') {
            System.out.print("Ingrese el número de la persona que desea corregir (1-10): ");
            int numeroPersona = sc.nextInt();
            sc.nextLine();
            getters.corregirDatos(numeroPersona, usuario[numeroPersona-1], sc);
            System.out.println("Datos corregidos:");
            usuario[numeroPersona - 1].mostrarInformacion(numeroPersona);

            System.out.println("¿Desea continuar corrigiendo los datos de algún objeto? (S/N)");
            cambio = sc.nextLine().toUpperCase().charAt(0);
}

        char opcion = 'S';
        boolean ordenarPorEdad;
        boolean ordenarMayorAMenor;
        char opciones;

 do {
        
        
        
        System.out.println("¿Cómo deseas previsualizar los datos?");
        System.out.print("Por edad o por Apellido Paterno (T/F): ");
        opciones = sc.nextLine().toUpperCase().charAt(0);
            if (opciones == 'T')
                ordenarPorEdad = true;
            else
                ordenarPorEdad = false;

        System.out.print("De mayor a menor o de menor a mayor (T/F): ");
        opciones = sc.nextLine().toUpperCase().charAt(0);
            if (opciones == 'T')
                ordenarMayorAMenor = true;
            else
                ordenarMayorAMenor = false;

                persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);
                
                System.out.print("Deseas previsualizar los datos de alguna otra manera (S/N): ");
                opcion = sc.nextLine().toUpperCase().charAt(0);

 } while (opcion != 'S');

        

        System.out.println("*--------------------------------------------*");
        //ciclo para mostrar datos
        for (int j = 0; j < usuario.length; j++) {
            usuario[j].mostrarInformacion(j+1);
            System.out.println();
        }

        // Llamada al modulo mostrar información para usuario2
        usuarioCopia.mostrarInformacion(11);

        sc.close();
    }
}