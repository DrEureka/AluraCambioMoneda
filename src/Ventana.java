import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;

public class Ventana extends JFrame implements ActionListener {

    private JLabel cantidadLabel, monedaOrigenLabel, monedaDestinoLabel, resultadoLabel;
    private JTextField cantidadField, resultadoField;
    private JComboBox<String> monedaOrigenComboBox, monedaDestinoComboBox;
    private JButton convertirButton;

    private Map<String, Moneda> mapaMonedas;

    public Ventana(Map<String, Moneda> mapaMonedas) {
        this.mapaMonedas = mapaMonedas;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setTitle("Conversor de monedas");

        // Crear componentes
        cantidadLabel = new JLabel("Cantidad:");
        monedaOrigenLabel = new JLabel("Moneda origen:");
        monedaDestinoLabel = new JLabel("Moneda destino:");
        resultadoLabel = new JLabel("Resultado:");
        cantidadField = new JTextField(10);
        resultadoField = new JTextField(10);
        resultadoField.setEditable(false);
        monedaOrigenComboBox = new JComboBox<>(mapaMonedas.keySet().toArray(new String[0]));
        monedaDestinoComboBox = new JComboBox<>(mapaMonedas.keySet().toArray(new String[0]));
        convertirButton = new JButton("Convertir");
        convertirButton.addActionListener(this);

        // Crear paneles
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(cantidadLabel);
        inputPanel.add(cantidadField);
        inputPanel.add(monedaOrigenLabel);
        inputPanel.add(monedaOrigenComboBox);
        inputPanel.add(monedaDestinoLabel);
        inputPanel.add(monedaDestinoComboBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertirButton);

        JPanel outputPanel = new JPanel(new GridLayout(1, 2));
        outputPanel.add(resultadoLabel);
        outputPanel.add(resultadoField);

        // Agregar componentes a la ventana
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertirButton) {
            String cantidadStr = cantidadField.getText();
            String monedaOrigenStr = (String) monedaOrigenComboBox.getSelectedItem();
            String monedaDestinoStr = (String) monedaDestinoComboBox.getSelectedItem();
            Moneda monedaOrigen = mapaMonedas.get(monedaOrigenStr);
            Moneda monedaDestino = mapaMonedas.get(monedaDestinoStr);

            try {
                double cantidad = Double.parseDouble(cantidadStr);
                double resultado = monedaOrigen.convertir(cantidad, monedaDestino);
                resultadoField.setText(String.format("%.2f", resultado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La cantidad ingresada es inválida.");
            }
        }
    }

    public static void main(String[] args) {
        // Crear instancias de las monedas con las tasas de cambio
        Moneda dolar = new Dolar(0.84, "USD");
        Moneda euro = new Euro(1.18, "EUR");
        Moneda otraMoneda = new OtraMoneda("MXN", 0.05);
        Moneda otraMoneda1 = new OtraMoneda("ARG", 0.15);



        // Crear mapa de monedas
        Map<String, Moneda> mapaMonedas = new HashMap<>();
        mapaMonedas.put("USD", dolar);
        mapaMonedas.put("EUR", euro);
        mapaMonedas.put("MXN", otraMoneda);
        mapaMonedas.put("ARG", otraMoneda1);


        // Crear instancia de la GUI
        Ventana Ventana = new Ventana(mapaMonedas);
    }
}