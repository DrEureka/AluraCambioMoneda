public class Dolar extends Moneda {
    public Dolar(double tasaDeCambio, String nombre) {
        super(tasaDeCambio, nombre);
    }

    @Override
    public double convertir(double cantidad, Moneda monedaDestino) {
        return cantidad * getTasaDeCambio() / monedaDestino.getTasaDeCambio();
    }
}