public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected double sueldoBase;
    protected String numeroIdentificacion;

    public Empleado(String nombre, String apellido, double sueldoBase, String numeroIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldoBase = sueldoBase;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
}
