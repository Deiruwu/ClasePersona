package ClasePersona;

public class Alumno extends Persona {
    long numeroContro = 0;
    int semestre = 0;
    String carrera = null;
    int calificacion = 0;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, char genero,
        String domicilio,double estatura, long numeroContro, int semestre, String carrera, int calificacion) {
            
            super(nombre, apellidoPaterno, apellidoMaterno, edad, genero, domicilio, estatura);
            this.numeroContro = numeroContro;
            this.semestre = semestre;
            this.carrera = carrera;
            this.calificacion = calificacion;
        }
    public Alumno(){
        super();
    }



    @Override
    public String toString() {
        return String.format("Alumno: \n\t%s\n\tNumero de contro: %d\n\tSemestre: %d\n\tCarrera: %s\n\tCalificacion: %d\n\t",
        super.toString(),numeroContro, semestre, carrera, calificacion);
    }
}
