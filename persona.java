package ClasePersona;
import java.util.ArrayList;
    /**
     * Clase que representa a una persona.
     */
    
public class Persona {
    String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;  
    public int edad;
    public char genero;
    public String domicilio;
    double estatura;

    /**
     * Constructor de la clase persona.
     * 
     * @param nombre el nombre de la persona
     * @param apellidoPaterno el apellido paterno de la persona
     * @param apellidoMaterno el apellido materno de la persona
     * @param edad la edad de la persona
     * @param genero el género de la persona
     * @param domicilio el domicilio de la persona
     * @param estatura la estatura de la persona
     */
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, char genero, String domicilio, double estatura) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.genero = genero;
        this.domicilio = domicilio;
        this.estatura = estatura;
    }

    public Persona() {
        this.nombre = null;
        this.apellidoPaterno =null;
        this.apellidoMaterno = null;
        this.edad = 0;
        this.genero = ' ';
        this.domicilio = null;
        this.estatura = 0.0;
    }

    /**
     * Constructor de la clase persona.
     * 
     * @param usuario1 objeto de tipo persona que se utilizará para inicializar los atributos de la nueva instancia.
     */
    public Persona (Persona usuario1){
        this.nombre=usuario1.nombre;
        this.apellidoPaterno=usuario1.apellidoPaterno;
        this.apellidoMaterno=usuario1.apellidoMaterno;
        this.edad=usuario1.edad;
        this.genero=usuario1.genero;
        this.domicilio=usuario1.domicilio;
        this.estatura=usuario1.estatura;
    }

    /**
     * Ordena un arreglo de objetos persona según el criterio especificado.
     * 
     * @param usuarios      La lista de objetos persona a ordenar.
     * @param edadOApellido Un valor booleano que indica si se debe ordenar por edad (true) o por apellido (false).
     * @param Mayor_Menor   Un valor booleano que indica si se debe ordenar de mayor a menor (true) o de menor a mayor (false).
     */
    public static void ordenamiento(ArrayList<Persona> usuarios, boolean edadOApellido, boolean Mayor_Menor) {
        usuarios.sort((p1, p2) -> {
            if (edadOApellido) {
                int comparacionEdad = p1.edad - p2.edad;
                return Mayor_Menor ? comparacionEdad : -comparacionEdad;
            } else {
                int comparacionApellido = p1.apellidoPaterno.compareTo(p2.apellidoPaterno);
                return Mayor_Menor ? comparacionApellido : -comparacionApellido;
            }
        });
    }
    /**
     * Muestra la información de una persona.
     * 
     * @param contador el número de la persona
     */


    /**
     * Devuelve el nombre completo de la persona.
     * 
     * @return el nombre completo de la persona
     */
    public String nombreCompleto() {
        return (nombre != null && apellidoMaterno != null && apellidoPaterno != null) 
        ? String.format("%s %s %s", nombre, apellidoPaterno, apellidoMaterno) : "No se ha ingresado un nombre";
    }

    @Override
    public String toString() {
        return String.format("Nombre Completo: %s\n\tEdad: %d\n\tGénero: %c\n\tDomicilio: %s\n\tEstatura: %.2f",
        nombreCompleto(), edad, genero, domicilio != null ? domicilio : "Sin domicilio", estatura);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
}   