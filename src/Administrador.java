// Enum para TipoAdministrador

public class Administrador extends Empleado {
    private TipoAdministrador tipoAdministrador;
    private static final double SUELDO_BASE_MINIMO_ADMIN = 1000.0;
    public Administrador(String nombre, String apellido, double sueldoBase, String numeroIdentificacion, TipoAdministrador tipoAdministrador) {
        super(nombre, apellido, sueldoBase, numeroIdentificacion);
        this.tipoAdministrador = tipoAdministrador;
    }

    @Override
    public double calcularSalario() {
        double salario = sueldoBase;

        switch (tipoAdministrador) {
            case PRINCIPAL:
                salario += sueldoBase * 0.25;
                break;
            case GENERAL:
                salario += sueldoBase * 0.10;
                break;
            default:
                break;
        }


        if (salario < SUELDO_BASE_MINIMO_ADMIN) {
            salario = SUELDO_BASE_MINIMO_ADMIN;
        }

        return salario;
    }



}