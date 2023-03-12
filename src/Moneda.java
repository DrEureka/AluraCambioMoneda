public abstract class Moneda {
    private String nombre;
    private double tasaCambio;
    private String simbolo;

    public Moneda(double tasaCambio, String nombre, String simbolo) {
        this.tasaCambio = tasaCambio;
        this.nombre = nombre;
        this.simbolo = simbolo;
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

    public String getSimbolo() {
        return simbolo;
    }

    public abstract double convertir(double cantidad, Moneda monedaDestino);
}