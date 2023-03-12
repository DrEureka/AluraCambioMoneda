import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarMoneda extends JFrame implements ActionListener {
    private JTextField nombreMoneda;
    private JTextField tasaCambio;
    private JButton agregarButton;
    private Conversor conversor;

    public VentanaAgregarMoneda(Conversor conversor) {
        this.conversor = conversor;

        // Configurar la ventana
        setTitle("Agregar Moneda");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Crear los componentes de la ventana
        JLabel nombreMonedaLabel = new JLabel("Nombre de la moneda:");
        JLabel tasaCambioLabel = new JLabel("Tasa de cambio:");
        nombreMoneda = new JTextField(10);
        tasaCambio = new JTextField(10);
        agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(this);

        // Crear el panel para los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(nombreMonedaLabel);
        panel.add(nombreMoneda);
        panel.add(tasaCambioLabel);
        panel.add(tasaCambio);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(agregarButton);

        // Agregar el panel a la ventana
        add(panel);

        // Mostrar la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            // Obtener el nombre y la tasa de cambio ingresados por el usuario
            String nombre = nombreMoneda.getText();
            double tasaCambio = Double.parseDouble(this.tasaCambio.getText());

            // Crear una instancia de la moneda y agregarla al conversor
            Moneda moneda = new OtraMoneda(nombre, tasaCambio);
            conversor.agregarMoneda(moneda);

            // Mostrar un mensaje de éxito y cerrar la ventana
            JOptionPane.showMessageDialog(this, "La moneda ha sido agregada exitosamente.");
            dispose();
        }
    }
}