import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<>();
        int cantidadDocentes = solicitarCantidad("Ingrese la cantidad de Docentes:");
        int cantidadAdministradores = solicitarCantidad("Ingrese la cantidad de Administradores:");

        for (int i = 0; i < cantidadDocentes; i++) {
            agregarDocente(empleados);
        }

        // Agregar administradores según la cantidad solicitada
        for (int i = 0; i < cantidadAdministradores; i++) {
            agregarAdministrador(empleados);
        }
        calcularSalarioEmpleados(empleados);
        imprimirSalarios(empleados);
        imprimirSueldoTotalDocentes(empleados);
        imprimirNumeroEmpleados(empleados);
    }

    private static void agregarDocente(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre del docente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido del docente:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese sueldo base del docente:");
        double sueldoBase = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese número de identificación del docente:");
        String numeroIdentificacion = scanner.nextLine();

        NivelAcademico nivelAcademico = solicitarNivelAcademico();

        Docente docente = new Docente(nombre, apellido, sueldoBase, numeroIdentificacion, nivelAcademico);
        empleados.add(docente);

        System.out.println("Docente agregado correctamente.");
    }

    private static void agregarAdministrador(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre del administrador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido del administrador:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese sueldo base del administrador:");
        double sueldoBase = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese número de identificación del administrador:");
        String numeroIdentificacion = scanner.nextLine();

        TipoAdministrador tipoAdministrador = solicitarTipoAdministrador();

        Administrador administrador = new Administrador(nombre, apellido, sueldoBase, numeroIdentificacion, tipoAdministrador);
        empleados.add(administrador);

        System.out.println("Administrador agregado correctamente.");
    }
    private static TipoAdministrador solicitarTipoAdministrador() {
        Scanner scanner = new Scanner(System.in);
        TipoAdministrador tipo = null;

        System.out.println("Ingrese tipo de administrador (PRINCIPAL o GENERAL):");
        String tipoStr = scanner.nextLine().toUpperCase();

        try {
            tipo = TipoAdministrador.valueOf(tipoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de administrador no válido. Debe ser PRINCIPAL o GENERAL.");
        }

        return tipo;
    }

    private static NivelAcademico solicitarNivelAcademico() {
        Scanner scanner = new Scanner(System.in);
        NivelAcademico nivel = null;

        System.out.println("Ingrese nivel académico (PREGRADO, MAESTRIA o DOCTORADO):");
        String nivelStr = scanner.nextLine().toUpperCase();

        try {
            nivel = NivelAcademico.valueOf(nivelStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Nivel académico no válido. Debe ser PREGRADO, MAESTRIA o DOCTORADO.");
        }

        return nivel;
    }
    private static void calcularSalarioEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("\n--- Calculando salarios ---");
        for (Empleado empleado : empleados) {
            double salario = empleado.calcularSalario();
            System.out.println(empleado.getClass().getSimpleName() + ": " + empleado.getNombre() + " - Salario: " + salario);
        }
        System.out.println("--- Fin del cálculo de salarios ---\n");
    }

    private static void imprimirSalarios(ArrayList<Empleado> empleados) {
        System.out.println("Información de Salarios:");

        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellido: " + empleado.getApellido());
            System.out.println("Número de Identificación: " + empleado.getNumeroIdentificacion());
            System.out.println("Salario a Pagar: " + empleado.calcularSalario());
            System.out.println("------------------------");
        }
    }

    private static void imprimirSueldoTotalDocentes(ArrayList<Empleado> empleados) {
        double sueldoTotalDocentes = 0;

        System.out.println("Monto total a pagar a Docentes:");

        for (Empleado empleado : empleados) {
            if (empleado instanceof Docente) {
                double salario = empleado.calcularSalario();
                sueldoTotalDocentes += salario;
                System.out.println(empleado.getNombre() + ": " + salario);
            }
        }

        System.out.println("Total: " + sueldoTotalDocentes);
    }
    private static void imprimirNumeroEmpleados(ArrayList<Empleado> empleados) {
        int numDocentes = 0;
        int numAdministradores = 0;

        for (Empleado empleado : empleados) {
            if (empleado instanceof Docente) {
                numDocentes++;
            } else if (empleado instanceof Administrador) {
                numAdministradores++;
            }
        }

        System.out.println("Número de Docentes: " + numDocentes);
        System.out.println("Número de Administradores: " + numAdministradores);
    }
    private static int solicitarCantidad(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int cantidad = 0;

        while (cantidad <= 0) {
            System.out.println(mensaje);
            try {
                cantidad = scanner.nextInt();
                if (cantidad <= 0) {
                    System.out.println("Por favor, ingrese un número mayor a cero.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el búfer del scanner
            }
        }

        return cantidad;
    }
}
