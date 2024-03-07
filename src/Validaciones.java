import java.util.Scanner;

public class Validaciones {
    private Scanner scanner;

    public Validaciones() {
        this.scanner = new Scanner(System.in);
    }

    public String obtenerNombre(String mensaje) {
        System.out.println(mensaje);
        String nombre;
        do {
            nombre = scanner.nextLine();
            if (!nombre.matches("[a-zA-Z]+")) {
                System.out.println("El nombre solo puede contener letras. Por favor, ingrésalo nuevamente:");
            }
        } while (!nombre.matches("[a-zA-Z]+"));
        return nombre;
    }

    public int obtenerOpcion(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextInt();
    }
}
