package paquetote.clasePersona;

public class persona {
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;  
    public int edad;
    public char genero;
    public String domicilio;
    public double estatura;


    // Metodo constructo
    public persona(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, char genero, String domicilio, double estatura) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.genero = genero;
        this.domicilio = domicilio;
        this.estatura = estatura;
    }

    //constructo persona copia
    public persona (persona usuario1){
        this.nombre=usuario1.nombre;
        this.apellidoPaterno=usuario1.apellidoPaterno;
        this.apellidoMaterno=usuario1.apellidoMaterno;
        this.edad=usuario1.edad;
        this.genero=usuario1.genero;
        this.domicilio=usuario1.domicilio;
        this.estatura=usuario1.estatura;
    }

    //Modulo para vizualizar la información
    public void mostrarInformacion(int contador) {
        System.out.println("Datos del usuario "+contador);
        System.out.println("Nombre completo: " + nombreCompleto());
        System.out.println("Edad: " + edad);
        System.out.println("Género: " + genero);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Estatura: " + estatura);
    }

    public String nombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
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