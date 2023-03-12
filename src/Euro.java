public class Euro extends Moneda {
    public Euro(double tasaDeCambio, String nombre) {
        super(tasaDeCambio, nombre);
    }

    @Override
    public double convertir(double cantidad, Moneda monedaDestino) {
        return cantidad * getTasaDeCambio() / monedaDestino.getTasaDeCambio();
    }
}