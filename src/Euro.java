public class Euro extends Moneda {
    public Euro(double tasaCambio, String nombre) {
        super(tasaCambio, nombre);
    }

    public double convertir(double cantidad, Moneda monedaDestino) {
        return cantidad * getTasaCambio() / monedaDestino.getTasaCambio();
    }
}