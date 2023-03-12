import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    private JTextField campoTextoCantidad;
    private JComboBox<String> comboBoxOrigen;
    private JComboBox<String> comboBoxDestino;
    private JButton botonConvertir;

    public Ventana() {
        super("Conversor de monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes de la ventana
        campoTextoCantidad = new JTextField(20);
        comboBoxOrigen = new JComboBox<>(new String[]{"Dólar", "Euro"});
        comboBoxDestino = new JComboBox<>(new String[]{"Dólar", "Euro"});
        botonConvertir = new JButton("Convertir");

        // Agregar ActionListener al botón
        botonConvertir.addActionListener(this);

        // Crear panel con los componentes
        JPanel panel = new JPanel();
        panel.add(new JLabel("Cantidad:"));
        panel.add(campoTextoCantidad);
        panel.add(new JLabel("Moneda origen:"));
        panel.add(comboBoxOrigen);
        panel.add(new JLabel("Moneda destino:"));
        panel.add(comboBoxDestino);
        panel.add(botonConvertir);

        // Agregar panel a la ventana
        add(panel);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener valores de los campos de texto y los JComboBox
        double cantidad = Double.parseDouble(campoTextoCantidad.getText());
        String monedaOrigen = (String) comboBoxOrigen.getSelectedItem();
        String monedaDestino = (String) comboBoxDestino.getSelectedItem();

        // Crear instancias de las monedas con las tasas de cambio
        Moneda moneda1, moneda2;
        if (monedaOrigen.equals("Dólar")) {
            moneda1 = new Dolar(1, "USD");
        } else {
            moneda1 = new Euro(1, "EUR");
        }
        if (monedaDestino.equals("Dólar")) {
            moneda2 = new Dolar(1, "USD");
        } else {
            moneda2 = new Euro(1, "EUR");
        }

        // Realizar la conversión
        double resultado = moneda1.convertir(cantidad, moneda2);

        // Mostrar resultado en un JOptionPane
        JOptionPane.showMessageDialog(this, cantidad + " " + monedaOrigen + " = " + resultado + " " + monedaDestino);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ventana();
        });
    }
}