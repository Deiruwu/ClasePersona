package ClasePersona;

public class Directivo extends Persona {
    String jefatura = "";
    String areadscripcion = "";
    String categorias = "";
    String fechingreso = "";
    String jefinmediato = "";
    String estadocivil = "";
    String rfc = "";


    public Directivo() {
        super();
    }

    public Directivo(String nombre, String Apellidopaterno, String Apellidomaterno, int edad, char genero, double estatura, String Domicilio,
            String jefat, String area, String cat, String feching, String jefin, String estciv, String RFC) {
        super(nombre, Apellidopaterno, Apellidomaterno, edad, genero, Domicilio, estatura);
        this.jefatura=jefat;
        this.areadscripcion=area;
        this.categorias=cat;
        this.fechingreso=feching;
        this.jefinmediato=jefin;
        this.estadocivil=estciv;
        this.rfc=RFC;
    }

    @Override
    public String toString() {
        return String.format("Directivo: \n\t%s\n\tJefatura: %s\n\tÁrea de adscripción: %s\n\tCategorías: %s\n\tFecha de ingreso: %s\n\tJefe inmediato: %s\n\tEstado civil: %s\n\tRFC: %s\n", super.toString(), jefatura, areadscripcion, categorias, fechingreso, jefinmediato, estadocivil, rfc);
    }

    public String[] consultajefaturayjefeinmediato() {
        String valores[]=new String[2];
        System.out.println(String.valueOf(jefatura));
        System.out.println(String.valueOf(jefinmediato));
        return valores;
    }
    
}
