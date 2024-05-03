package ClasePersona;
import java.util.ArrayList;

public class RunHerenciaPersona {
    public static void main(String[] args) {
        ArrayList<Persona> usuario = new ArrayList<Persona>();
        usuario.add(new Alumno("Maria", "González", "Hernández", 22, 'F', "Calle 456", 1.65, 1876543210, 2, "Medicina", 8));
        usuario.add(new Alumno());
        usuario.add(new Alumno_Ext_Ser_Social("Juan", "Pérez", "Gómez", 30, 'M', "Calle 789", 1.70, 1876543210, 456, "Medicina", 5, "Universidad", "Biología"));
        usuario.add(new Alumno_Ext_Ser_Social());
        usuario.add(new Docente("Pedro", "Martínez", "Hernández", 30, 'M', 1.80, "Calle 789", "1234567890", 3, "Ingeniería", 90, "Maestría", 5, "Academia", "C", "01/01/2021", "RFC", 123, "Área"));
        usuario.add(new Docente());
        usuario.add(new Directivo("Ana", "Sánchez", "Gómez", 35, 'F', 1.65, "Calle 1011", "Jefatura", "Área", "Categoría", "01/01/2021", "Jefe", "Casada", "RFC"));
        usuario.add(new Directivo());
        usuario.add(new Administrativo("José", "Hernández", "Gómez", 40, 'M', 1.75, "Calle 1213", 10, 5, "Jefatura", "Área", "Categoría", "01/01/2021", "Jefe", "Casado", "RFC"));
        usuario.add(new Administrativo());

        for (Persona p : usuario) {
            System.out.println(p);
        }
    }
}