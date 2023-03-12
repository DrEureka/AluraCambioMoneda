public class OtraMoneda extends Moneda {
    private String nombre;

    public OtraMoneda(String nombre, double tasaDeCambio) {
        super(tasaDeCambio, nombre, nombre);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double convertir(double cantidad, Moneda monedaDestino) {
        return cantidad * getTasaDeCambio() / monedaDestino.getTasaDeCambio();
    }
}