public abstract class Moneda {
    protected double tasaDeCambio;
    protected String nombre;

    public Moneda(double tasaDeCambio, String nombre) {
        this.tasaDeCambio = tasaDeCambio;
        this.nombre = nombre;
    }

    public abstract double convertir(double cantidad, Moneda monedaDestino);

    public String getNombre() {
        return nombre;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }
}