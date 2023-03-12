import javax.swing.JFrame;

public class ejemploVentana extends JFrame {

    private Conversor conversor;

    public ejemploVentana(Conversor conversor) {
        this.conversor = conversor;

        // Configurar la ventana
        setTitle("Conversor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Imprimir el mapa de monedas en la consola
        System.out.println(conversor.obtenerMapaMonedas());

        // ...
    }
}