import java.util.Scanner;



public class Conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear instancias de las monedas con las tasas de cambio
        Moneda dolar = new Dolar(0.84, "USD");
        Moneda euro = new Euro(1.18, "EUR");



        // Obtener la cantidad del usuario
        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        // Obtener la moneda de origen del usuario
        Moneda monedaOrigen;
        do {
            System.out.print("Ingrese la moneda origen (EUR o USD): ");
            String monedaOrigenStr = scanner.nextLine().toUpperCase();
            if (monedaOrigenStr.equals("EUR")) {
                monedaOrigen = euro;
            } else if (monedaOrigenStr.equals("USD")) {
                monedaOrigen = dolar;
            } else {
                monedaOrigen = null;
                System.out.println("Moneda origen inválida, intente de nuevo.");
            }
        } while (monedaOrigen == null);

        // Obtener la moneda destino del usuario
        Moneda monedaDestino;
        do {
            System.out.print("Ingrese la moneda destino (EUR o USD): ");
            String monedaDestinoStr = scanner.nextLine().toUpperCase();
            if (monedaDestinoStr.equals("EUR")) {
                monedaDestino = euro;
            } else if (monedaDestinoStr.equals("USD")) {
                monedaDestino = dolar;
            } else {
                monedaDestino = null;
                System.out.println("Moneda destino inválida, intente de nuevo.");
            }
        } while (monedaDestino == null);

        // Realizar la conversión
        double resultado = monedaOrigen.convertir(cantidad, monedaDestino);
        System.out.println(cantidad + " " + monedaOrigen.getNombre() + " = " + resultado + " " + monedaDestino.getNombre());
    }
}