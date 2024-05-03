package ClasePersona;

public class Docente extends Persona {
    String nivelestudio;
    int añosServicio;
    String academia;
    String categoria;
    String fechaIngreso;
    String rfc;
    int nomTarjeta;
    String areas;

    
    public Docente (String nombre, String Apellidopaterno, String Apellidomaterno, int edad, char genero, double estatura, String Domicilio, String numcontrol,
            int semestre, String carrera, double promedio, String nivelestudio, int añosServicio, String academia, String categoria,
            String fechaIngreso, String rfc, int nomTarjeta, String areas) {
        super(nombre, Apellidopaterno, Apellidomaterno, edad, genero, Domicilio, estatura);
        this.nivelestudio = nivelestudio;
        this.añosServicio = añosServicio;
        this.academia = academia;
        this.categoria = categoria;
        this.fechaIngreso = fechaIngreso;
        this.rfc = rfc;
        this.nomTarjeta = nomTarjeta;
        this.areas = areas;
    }
    
    public Docente() {
        super();
        this.nivelestudio = "";
        this.añosServicio = 0;
        this.academia = "";
        this.categoria = "";
        this.fechaIngreso = "";
        this.rfc = "";
        this.nomTarjeta = 0;
        this.areas = "";
    }   
    
    @Override
    public String toString() {
        
        return String.format("Docente: \n\t%s\n\tNivel de Estudio: %s\n\tAños de Servicio: %d\n\tAcademia: %s\n\tCategoría: %s\n\tFecha de Ingreso: %s\n\tRFC: %s\n\tNúmero de Tarjeta: %d\n\tÁrea de Adscripción: %s\n", super.toString(), nivelestudio, añosServicio, academia, categoria, fechaIngreso, rfc, nomTarjeta, areas);
    }

    public String[] consultanumtarjetayareadeadscripcion() {
        String valores[] = new String[2];
        System.out.println(String.valueOf(nomTarjeta));
        System.out.println(String.valueOf(areas));
        return valores;
    }
}