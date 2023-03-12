public class Dolar extends Moneda {
    public Dolar(double tasaCambio, String nombre) {
        super(tasaCambio, nombre, "DOLAR");
    }

    public double convertir(double cantidad, Moneda monedaDestino) {
        return cantidad * getTasaCambio() / monedaDestino.getTasaCambio();
    }
}