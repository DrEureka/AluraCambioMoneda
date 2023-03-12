import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    private static Map<String, Moneda> mapaMonedas = new HashMap<>();

    public static void agregarMoneda(Moneda moneda) {
        mapaMonedas.put(moneda.getNombre(), moneda);
    }

    public static Moneda obtenerMoneda(String nombreMoneda) {
        return mapaMonedas.get(nombreMoneda);


    }
    public static Map<String, Moneda> obtenerMapaMonedas() {
        return mapaMonedas;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear instancias de las monedas con las tasas de cambio
        Moneda dolar = new Dolar(0.84, "USD");
        Moneda euro = new Euro(1.18, "EUR");

        // Agregar las monedas al mapa de monedas
        agregarMoneda(dolar);
        agregarMoneda(euro);

        // Obtener la cantidad del usuario
        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        // Obtener la moneda de origen del usuario
        Moneda monedaOrigen;
        do {
            System.out.print("Ingrese la moneda origen (EUR o USD): ");
            String monedaOrigenStr = scanner.nextLine().toUpperCase();
            monedaOrigen = obtenerMoneda(monedaOrigenStr);
            if (monedaOrigen == null) {
                System.out.println("Moneda origen inválida, intente de nuevo.");
            }
        } while (monedaOrigen == null);

        // Obtener la moneda destino del usuario
        Moneda monedaDestino;
        do {
            System.out.print("Ingrese la moneda destino (EUR o USD): ");
            String monedaDestinoStr = scanner.nextLine().toUpperCase();
            monedaDestino = obtenerMoneda(monedaDestinoStr);
            if (monedaDestino == null) {
                System.out.println("Moneda destino inválida, intente de nuevo.");
            }
        } while (monedaDestino == null);

        // Realizar la conversión
        double resultado = monedaOrigen.convertir(cantidad, monedaDestino);
        System.out.println(cantidad + " " + monedaOrigen.getNombre() + " = " + resultado + " " + monedaDestino.getNombre());
    }
}