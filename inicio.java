package paquetote.clasePersona.ClasePersona;
import java.util.Scanner;
public class inicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        persona[] usuario = new persona[10];

        //ciclo para instanciar 5 objetos de la clase persona
        for (int i = 0; i < usuario.length; i++) {
            System.out.println("Ingrese los datos de la persona " + (i + 1) + ":");
            usuario[i] = getters.crearObjeto(sc); //Llama al metodo que nos solicitará los datos para crear un objeto
            System.out.println();
        }

        // Crear usuario11 usando el constructor copia
        persona usuario11 = new persona(usuario[0]);

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

        System.out.println("¿Cómo deseas previsualizar los datos?");
        boolean ordenarPorEdad;
        boolean ordenarMayorAMenor;
        char opciones;

        System.out.print("Por edad o por Apellido Paterno (S/N): ");
        opciones = sc.nextLine().toUpperCase().charAt(0);
            if (opciones == 'S')
                ordenarPorEdad = true;
            else
                ordenarPorEdad = false;

        System.out.print("De mayor a menor o de menor a mayor (S/N): ");
        opciones = sc.nextLine().toUpperCase().charAt(0);
            if (opciones == 'S')
                ordenarMayorAMenor = true;
            else
                ordenarMayorAMenor = false;

        persona.ordenamiento(usuario, ordenarPorEdad, ordenarMayorAMenor);

        System.out.println("*--------------------------------------------*");
        //ciclo para mostrar datos
        for (int j = 0; j < usuario.length; j++) {
            usuario[j].mostrarInformacion(j);
            System.out.println();
        }

        // Llamada al modulo mostrar información para usuario2
        usuario11.mostrarInformacion(11);

        sc.close();
    }
}