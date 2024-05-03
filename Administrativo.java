package ClasePersona;

public class Administrativo extends Persona {
    int nomEmpleados = 0;
    int nivel = 0;
    String puesto = "";
    String areaInscripcion = "";
    String jefeInmediato = "";
    String estadoCivil = "";
    String rfc = "";
    String numtar = "";
    String añoServ = "";

    public Administrativo(){
        super();
    }

    public Administrativo(String nombre, String Apellidopaterno, String Apellidomaterno, int edad, char genero, double estatura, String Domicilio,
            int empleados, int niv, String puest, String areascripcion, String jefeinmediato, String estadocivil, String rfc, String Numtar, String añoserv) {
        
                super(nombre, Apellidopaterno, Apellidomaterno, edad, genero, Domicilio, estatura);
        this.nomEmpleados = empleados;
        this.nivel = niv;
        this.puesto = puest;
        this.areaInscripcion = areascripcion;
        this.jefeInmediato = jefeinmediato;
        this.estadoCivil = estadocivil;
        this.rfc = rfc;
        this.numtar = Numtar;
        this.añoServ = añoserv;
    }

    @Override
    public String toString() {
        return String.format("Administrativo: \n\t%s\n\tNúmero de empleados: %d\n\tNivel: %d\n\tPuesto: %s\n\tÁrea de inscripción: %s\n\tJefe inmediato: %s\n\tEstado civil: %s\n\tRFC: %s\n\tNúmero de tarjeta: %s\n\tAño de servicio: %s\n",
            super.toString(), nomEmpleados, nivel, puesto, areaInscripcion, jefeInmediato, estadoCivil, rfc, numtar, añoServ);
    }

    public String[] consultarTarjetaIscripcion() {
        String[] valores=new String[2];
        System.out.println(String.valueOf(numtar));
        System.out.println(String.valueOf(añoServ));
        return valores;
    }
}