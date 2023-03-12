public abstract class Moneda {
    private String nombre;
    private double tasaCambio;

    public Moneda(double tasaCambio, String nombre) {
        this.tasaCambio = tasaCambio;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public double getTasaDeCambio() {
        return tasaCambio;
    }

    public abstract double convertir(double cantidad, Moneda monedaDestino);
}