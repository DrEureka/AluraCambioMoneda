import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Ventana extends JFrame implements ActionListener {
    private JTextField importe;
    private JComboBox<Moneda> monedaOrigenComboBox;
    private JComboBox<Moneda> monedaDestinoComboBox;
    private JButton convertirButton;
    private JButton agregarButton;
    private Conversor conversor;

    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        Ventana ventana = new Ventana(conversor);
    }

    public Ventana(Conversor conversor) {
        this.conversor = conversor;

        // Configurar la ventana
        setTitle("Conversor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Crear los componentes de la ventana
        JLabel importeLabel = new JLabel("Importe a cambiar:");
        JLabel monedaOrigenLabel = new JLabel("Moneda de origen:");
        JLabel monedaDestinoLabel = new JLabel("Moneda de destino:");
        importe = new JTextField(10);

        monedaOrigenComboBox = new JComboBox<>(Conversor.obtenerMapaMonedas().values().toArray(new Moneda[0]));
        monedaDestinoComboBox = new JComboBox<>(Conversor.obtenerMapaMonedas().values().toArray(new Moneda[0]));
        convertirButton = new JButton("Convertir");
        convertirButton.addActionListener(this);
        agregarButton = new JButton("Agregar Moneda Personalizada");
        agregarButton.addActionListener(this);

        // Crear el panel para los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(importeLabel);
        panel.add(importe);
        panel.add(monedaOrigenLabel);
        panel.add(monedaOrigenComboBox);
        panel.add(monedaDestinoLabel);
        panel.add(monedaDestinoComboBox);
        panel.add(agregarButton);
        panel.add(convertirButton);

        // Agregar el panel a la ventana
        add(panel);

        // Mostrar la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertirButton) {
            // Obtener el importe, la moneda de origen y la moneda de destino seleccionadas por el usuario
            double cantidad = Double.parseDouble(importe.getText());
            Moneda monedaOrigen = (Moneda) monedaOrigenComboBox.getSelectedItem();
            Moneda monedaDestino = (Moneda) monedaDestinoComboBox.getSelectedItem();

            // Calcular la cantidad convertida y mostrarla en un diálogo de mensaje
            double resultado = monedaOrigen.convertir(cantidad, monedaDestino);
            JOptionPane.showMessageDialog(this, "La cantidad convertida es: " + resultado);
        } else if (e.getSource() == agregarButton) {
            // Crear una nueva ventana para agregar una moneda personalizada
            new VentanaAgregarMoneda(conversor);
        }
    }
}