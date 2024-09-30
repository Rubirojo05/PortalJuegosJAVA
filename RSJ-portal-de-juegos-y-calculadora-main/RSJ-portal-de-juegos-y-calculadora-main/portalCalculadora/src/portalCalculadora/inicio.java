package portalCalculadora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class inicio extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel textLabel;
    private JLabel textLabel2;
    private Timer timer;
    private int textIndex = 0;
    private int writingSpeed = 250; // Velocidad de escritura del texto en milisegundos
    private String movingText = "HAZ CLICK!";
    private int indice = 0;
    private final String texto = "HAZ CLICK!";
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                inicio frame = new inicio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public inicio() {
        setResizable(false);
        setTitle("Portal de juegos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 1100, 650);
        contentPane = new JPanel(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Código hexadecimal de una capa de texto
        String hexCode = "#A02C5D";
        int red = Integer.parseInt(hexCode.substring(1, 3), 16);
        int green = Integer.parseInt(hexCode.substring(3, 5), 16);
        int blue = Integer.parseInt(hexCode.substring(5, 7), 16);
        Color color = new Color(red, green, blue);

        // Crear el JLabel para mostrar el texton con su tipo de letra
        textLabel = new JLabel();
        textLabel.setFont(loadFont("pixel.ttf", 75f));
        textLabel.setForeground(color);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setBounds(0, 235, 1100, 150); // Ajustar la posición según necesidad
        contentPane.add(textLabel);

        textLabel2 = new JLabel();
        textLabel2.setFont(loadFont("pixel.ttf", 77f));
        textLabel2.setForeground(new Color(0xCC4E45)); // Establecer el color a #CC4E45
        textLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel2.setBounds(0, 235, 1098, 163); // Ajustar la posición según necesidad
        contentPane.add(textLabel2);

        // Iniciar el temporizador para mostrar el texto gradualmente
        timer = new Timer(writingSpeed, e -> {
            if (textIndex < movingText.length()) {
                textIndex++; // Incrementar el índice del texto
                updateTextLabel(); // Actualizar el texto en el JLabel
                repaint(); // Repintar para mostrar el texto con degradado
            } else {
                timer.stop(); // Detener el temporizador cuando se ha mostrado todo el texto
            }
        });
        timer.start();

        // Mostrar el GIF en un JLabel
        JLabel gifLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("videogame.gif")); // ruta del .gif
        Image scaledImage = imageIcon.getImage().getScaledInstance(1084, 611, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        gifLabel.setIcon(scaledIcon);
        gifLabel.setBounds(0, 0, 1084, 611); // Posición y tamaño del JLabel
        contentPane.add(gifLabel);

        // Crear el botón que ocupa toda la pantalla
        JButton closeButton = new JButton();
        closeButton.setBounds(0, 0, 1100, 650);
        closeButton.setContentAreaFilled(false); // Hacer el fondo transparente
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	portal porta = new portal();//abre el portal
            	porta.setVisible(true);
                dispose(); // Cerrar la ventana
            }
        });
        contentPane.add(closeButton);
    }

    // Método para actualizar el texto en el JLabel
    private void updateTextLabel() {
        textLabel.setText(movingText.substring(0, textIndex));
        textLabel2.setText(movingText.substring(0, textIndex));
    }

    // Método para cargar la fuente desde el archivo
    private Font loadFont(String fontPath, float size) {
        try (InputStream fontStream = getClass().getResourceAsStream(fontPath)) {
            return Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (indice < texto.length()) {
            indice++;
        }
    }
}

