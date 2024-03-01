import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sumadevectoresmetododeltriangulo extends JFrame {
    private JTextField txtMagnitud1, txtDireccion1, txtMagnitud2, txtDireccion2, txtEscala;
    private JButton btnCalcular;
    private VectorPanel vectorPanel;

    public Sumadevectoresmetododeltriangulo() {
        setTitle("Suma de vectores metodo del triangulo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        initComponents();
        addComponents();
        addActionListeners();
    }

    private void initComponents() {
        vectorPanel = new VectorPanel();
        txtMagnitud1 = new JTextField(10);
        txtDireccion1 = new JTextField(10);
        txtMagnitud2 = new JTextField(10);
        txtDireccion2 = new JTextField(10);
        txtEscala = new JTextField(10);
        btnCalcular = new JButton("Calcular");
    }

    private void addComponents() {
        JPanel panelControl = new JPanel(new GridLayout(5, 2));
        panelControl.add(new JLabel("Magnitud Vector 1:"));
        panelControl.add(txtMagnitud1);
        panelControl.add(new JLabel("Dirección Vector 1 (grados):"));
        panelControl.add(txtDireccion1);
        panelControl.add(new JLabel("Magnitud Vector 2:"));
        panelControl.add(txtMagnitud2);
        panelControl.add(new JLabel("Dirección Vector 2 (grados):"));
        panelControl.add(txtDireccion2);
        panelControl.add(new JLabel("Escala:"));
        panelControl.add(txtEscala);
        panelControl.add(btnCalcular);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(vectorPanel, BorderLayout.CENTER);
        getContentPane().add(panelControl, BorderLayout.SOUTH);
    }

    private void addActionListeners() {
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularVectorResultante();
            }
        });
    }

    private void calcularVectorResultante() {
        try {
            double magnitud1 = Double.parseDouble(txtMagnitud1.getText());
            double direccion1 = Double.parseDouble(txtDireccion1.getText());
            double magnitud2 = Double.parseDouble(txtMagnitud2.getText());
            double direccion2 = Double.parseDouble(txtDireccion2.getText());
            double escala = Double.parseDouble(txtEscala.getText());

            double vector1X = magnitud1 * Math.cos(Math.toRadians(direccion1)) * escala;
            double vector1Y = magnitud1 * Math.sin(Math.toRadians(direccion1)) * escala;

            double vector2X = magnitud2 * Math.cos(Math.toRadians(direccion2)) * escala;
            double vector2Y = magnitud2 * Math.sin(Math.toRadians(direccion2)) * escala;

            double sumaX = vector1X + vector2X;
            double sumaY = vector1Y + vector2Y;

            double magnitudResultado = Math.sqrt(Math.pow(sumaX, 2) + Math.pow(sumaY, 2));
            double direccionResultado = Math.toDegrees(Math.atan2(sumaY, sumaX));

            vectorPanel.setVectores(vector1X, vector1Y, vector2X, vector2Y, sumaX, sumaY, magnitud1, magnitud2, magnitudResultado, direccion1, direccion2, direccionResultado);
            vectorPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese números válidos para las magnitudes, direcciones y escala.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Sumadevectoresmetododeltriangulo ventana = new Sumadevectoresmetododeltriangulo();
                ventana.setVisible(true);
            }
        });
    }
}

class VectorPanel extends JPanel {
    private double vector1X, vector1Y, vector2X, vector2Y, sumaX, sumaY;
    private double magnitud1, magnitud2, magnitudResultado;
    private double direccion1, direccion2, direccionResultado;

    public void setVectores(double vector1X, double vector1Y,
                            double vector2X, double vector2Y, double sumaX, double sumaY,
                            double magnitud1, double magnitud2, double magnitudResultado,
                            double direccion1, double direccion2, double direccionResultado) {
        this.vector1X = vector1X;
        this.vector1Y = vector1Y;
        this.vector2X = vector2X + vector1X;
        this.vector2Y = vector2Y + vector1Y;
        this.sumaX = sumaX + vector2X;
        this.sumaY = sumaY + vector2Y;
        this.magnitud1 = magnitud1;
        this.magnitud2 = magnitud2;
        this.magnitudResultado = magnitudResultado;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.direccionResultado = direccionResultado;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int origenX = getWidth() / 2;
        int origenY = getHeight() / 2;

        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());

        g2d.setColor(Color.LIGHT_GRAY);
        int incrementoEscala = 100;
        for (int i = origenX + incrementoEscala; i < getWidth(); i += incrementoEscala) {
            g2d.drawLine(i, origenY - 5, i, origenY + 5);
        }
        for (int i = origenX - incrementoEscala; i > 0; i -= incrementoEscala) {
            g2d.drawLine(i, origenY - 5, i, origenY + 5);
        }
        for (int i = origenY + incrementoEscala; i < getHeight(); i += incrementoEscala) {
            g2d.drawLine(origenX - 5, i, origenX + 5, i);
        }
        for (int i = origenY - incrementoEscala; i > 0; i -= incrementoEscala) {
            g2d.drawLine(origenX - 5, i, origenX + 5, i);
        }

        g2d.setColor(Color.RED);
        g2d.drawLine(origenX, origenY, (int) (origenX + vector1X), (int) (origenY - vector1Y));
        g2d.drawString("V1 (" + magnitud1 + ", " + direccion1 + "°)", (int) (origenX + vector1X), (int) (origenY - vector1Y));

        g2d.setColor(Color.BLUE);
        g2d.drawLine((int) (origenX + vector1X), (int) (origenY - vector1Y), (int) (origenX + vector2X), (int) (origenY - vector2Y));
        g2d.drawString("V2 (" + magnitud2 + ", " + direccion2 + "°)", (int) (origenX + vector2X), (int) (origenY - vector2Y));

        g2d.setColor(Color.GREEN);
        g2d.drawLine(origenX, origenY, (int) (origenX + sumaX), (int) (origenY - sumaY));
        g2d.drawString("VR (" + magnitudResultado + ", " + direccionResultado + "°)", (int) (origenX + sumaX), (int) (origenY - sumaY));
    }
}
