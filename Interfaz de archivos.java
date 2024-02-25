import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class archivosinterfaz extends JFrame implements ActionListener {

    public archivosinterfaz() {
        setTitle("Abrir archivos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JButton jGraspFile1Button = new JButton("Abrir Conversor a Notación Cientifica");
        JButton jGraspFile2Button = new JButton("Abrir Conversor de Unidades");
        JButton jGraspFile3Button = new JButton("Abrir Cifras Significativas");
        JButton blenderFileButton = new JButton("Abrir Simulacion Primer Ley de Newton en Blender");

        jGraspFile1Button.addActionListener(this);
        jGraspFile2Button.addActionListener(this);
        jGraspFile3Button.addActionListener(this);
        blenderFileButton.addActionListener(this);

        add(jGraspFile1Button);
        add(jGraspFile2Button);
        add(jGraspFile3Button);
        add(blenderFileButton);

       
        Dimension preferredSize = new Dimension(500, 500);
        setPreferredSize(preferredSize);
        setResizable(false);

        pack(); 
        setLocationRelativeTo(null); 
        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String filePath = "";

        switch (command) {
            case "Abrir Conversor a Notación Cientifica":
                filePath = "C:\\Users\\aldor\\Downloads\\ConversorNotacionCientifica.java";
                break;
            case "Abrir Conversor de Unidades":
                filePath = "C:\\Users\\aldor\\Downloads\\ConversorUnidades.java";
                break;
            case "Abrir Cifras Significativas":
                filePath = "C:\\Users\\aldor\\Downloads\\Examen Parcia SIC 2A Cifras Significativas.java";
                break;
            case "Abrir Simulacion Primer Ley de Newton en Blender":
                filePath = "C:\\Users\\aldor\\Downloads\\Simulación Primer Ley de Newton.blend";
                break;
        }

        try {
            if (!filePath.isEmpty()) {
                Desktop.getDesktop().open(new File(filePath));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al abrir el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new archivosinterfaz();
        });
    }
}
