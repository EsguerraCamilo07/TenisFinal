import java.util.Random;
import java.util.Scanner;

public class SimuladorTenis {
    private int puntosJugador1;
    private int puntosJugador2;
    private int setsJugador1;
    private int setsJugador2;
    private String nombreJugador1;
    private String nombreJugador2;
    private Scanner scanner;
    private Random random;
    private Validaciones validaciones;

    public SimuladorTenis() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.validaciones = new Validaciones(); // Inicialización de la variable validaciones

    }

    public void iniciarJuego() {
        boolean salir = false;
        while (!salir) {
            System.out.println("¿Desea jugar al tenis? (Si o No)");
            String opcion = scanner.nextLine().toLowerCase();

            if (opcion.equals("si")) {
                iniciarPartido();
            } else if (opcion.equals("no")) {
                salir = true;
            } else {
                System.out.println("Opción no válida. Por favor, ingrese 'Si' o 'No'.");
            }
        }
        System.out.println("Gracias por jugar.");
    }


    public void iniciarPartido() {
        nombreJugador1 = validaciones.obtenerNombre("Ingrese el nombre del Jugador 1:");
        nombreJugador2 = validaciones.obtenerNombre("Ingrese el nombre del Jugador 2:");

        System.out.println("Bienvenido al Simulador de Partido de Tenis");
        System.out.println("Presiona Enter para comenzar el partido.");
        scanner.nextLine();


        while (true) {
            // Generar el punto aleatoriamente para uno de los jugadores
            int jugadorQueGanaPunto = random.nextInt(2); // 0 o 1
            if (jugadorQueGanaPunto == 0) {
                puntosJugador1++;
            } else {
                puntosJugador2++;
            }

            // Mostrar los puntos
            System.out.println("Puntuación:");
            System.out.println(nombreJugador1 + ": " + puntosJugador1 + " puntos");
            System.out.println(nombreJugador2 + ": " + puntosJugador2 + " puntos");

            // Verificar si hay un ganador del set
            if (puntosJugador1 >= 4 && puntosJugador1 >= puntosJugador2 + 2) {
                setsJugador1++;
                System.out.println(nombreJugador1 + " gana el set.");
                System.out.println("Sets:");
                System.out.println(nombreJugador1 + ": " + setsJugador1 + " sets");
                System.out.println(nombreJugador2 + ": " + setsJugador2 + " sets");
                puntosJugador1 = 0;
                puntosJugador2 = 0;
            } else if (puntosJugador2 >= 4 && puntosJugador2 >= puntosJugador1 + 2) {
                setsJugador2++;
                System.out.println(nombreJugador2 + " gana el set.");
                System.out.println("Sets:");
                System.out.println(nombreJugador1 + ": " + setsJugador1 + " sets");
                System.out.println(nombreJugador2 + ": " + setsJugador2 + " sets");
                puntosJugador1 = 0;
                puntosJugador2 = 0;
            }

            // Verificar si hay un ganador del partido
            if (setsJugador1 >= 2) {
                System.out.println(nombreJugador1 + " gana el partido.");
                break;
            } else if (setsJugador2 >= 2) {
                System.out.println(nombreJugador2 + " gana el partido.");
                break;
            }

            // Esperar para mostrar el siguiente punto
            System.out.println("Presiona Enter para continuar.");
            scanner.nextLine();
        }

        // Reiniciar los valores para el siguiente juego
        puntosJugador1 = 0;
        puntosJugador2 = 0;
        setsJugador1 = 0;
        setsJugador2 = 0;
    }
}
