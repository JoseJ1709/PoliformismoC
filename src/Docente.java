public class Docente extends Empleado {
    private NivelAcademico nivelAcademico;
    private static final double SUELDO_BASE_MINIMO_DOCENTE = 1000.0;

    public Docente(String nombre, String apellido, double sueldoBase, String numeroIdentificacion, NivelAcademico nivelAcademico) {
        super(nombre, apellido, sueldoBase, numeroIdentificacion);
        this.nivelAcademico = nivelAcademico;
    }
    @Override
    public double calcularSalario() {

        double salario;

        switch (nivelAcademico) {
            case PREGRADO:
                salario = sueldoBase * 1;
                break;
            case MAESTRIA:
                salario = sueldoBase * 3;
                break;
            case DOCTORADO:
                salario = sueldoBase * 5;
                break;
            default:
                salario = sueldoBase;
                break;
        }


        if (salario < SUELDO_BASE_MINIMO_DOCENTE) {
            salario = SUELDO_BASE_MINIMO_DOCENTE;
        }

        return salario;
    }
}
