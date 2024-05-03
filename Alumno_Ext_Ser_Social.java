package ClasePersona;

public class Alumno_Ext_Ser_Social extends Alumno{
    String programaServicioSocial = "";
    String escuelaProcedente = "";

    public Alumno_Ext_Ser_Social(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, char genero,
    String domicilio,double estatura, long numeroContro, int semestre, String carrera, int calificacion, String programaServicioSocial, String escuelaProcedente) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, genero, domicilio, estatura, numeroContro, semestre, carrera, calificacion);
        this.programaServicioSocial = programaServicioSocial;
        this.escuelaProcedente = escuelaProcedente;
    }

    public Alumno_Ext_Ser_Social(){
        super();
    }

    @Override
    public String toString() {
        return String.format("Servicio Social %sPrograma Servicio Social: %s\n\tEscuela Procedente: %s\n",super.toString(), programaServicioSocial, escuelaProcedente);
    }
    
    public static void main(String[] args) {
        Alumno_Ext_Ser_Social alumno = new Alumno_Ext_Ser_Social("Juan", "Pérez", "García", 20, 'M', "Calle 123", 1.70, 123456789, 3, "Ing. en Sistemas", 90, "Programa 1", "Escuela 1");
        System.out.println(alumno);
        Alumno_Ext_Ser_Social alumno2 = new Alumno_Ext_Ser_Social();
        System.out.println(alumno2);
    }
}